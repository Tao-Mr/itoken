package com.mrliu.itoken.service.sso.controller;

import com.mrliu.itoken.common.domain.TbSysUser;
import com.mrliu.itoken.common.utils.CookieUtils;
import com.mrliu.itoken.common.utils.MapperUtils;
import com.mrliu.itoken.service.sso.consumer.RedisService;
import com.mrliu.itoken.service.sso.service.LoginService;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @ProjectName: itoken
 * @Package: com.mrliu.itoken.service.sso.controller
 * @Description: java类作用描述
 * @Author: LLT
 * @Date: 2019/5/23 10:48
 * @UpdateRemark: 更新说明
 */
@Controller
public class LoginController {

    @Autowired
    private RedisService redisService;
    @Autowired
    private LoginService loginService;

    /**
     * 跳转登录页
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(@RequestParam(required = false) String url, HttpServletRequest request, Model model) {
        String token = CookieUtils.getCookieValue(request, "token");
        if (StringUtils.isNotBlank(token)) {
            String loginCode = redisService.get(token);
            if (StringUtils.isNotBlank(loginCode)) {
                try {
                    TbSysUser tbSysUser = MapperUtils.json2pojo(loginCode, TbSysUser.class);
                    if (tbSysUser != null) {
                        return "redircet:" + url;
                    }
                    //将登录信息返回给前端
                    model.addAttribute("tbSysUser", tbSysUser);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        if (StringUtils.isNotBlank(url)) {
            model.addAttribute("url", url);
        }
        return "login";
    }

    /**
     * 登录业务
     *
     * @param loginCode
     * @param password
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(String loginCode, String password, @RequestParam(required = false) String url, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        TbSysUser tbSysUser = loginService.login(loginCode, password);

        //登陆
        if (tbSysUser != null) {//登陆成功
            String token = UUID.randomUUID().toString();
            //将token放入缓存
            String result = redisService.put(token, loginCode, 60 * 60 * 24);
            if (StringUtils.isNotBlank(result) && result.equals("ok")) {
                CookieUtils.setCookie(request, response, "token", token);
                if (StringUtils.isNotBlank(url)) {
                    return "redirect:" + url;
                }
            } else {
                redirectAttributes.addFlashAttribute("message", "服务器异常，请稍后再试！");
            }
        } else {
            //登录失败
            redirectAttributes.addFlashAttribute("message", "用户名或密码错误，请重新输入！");
        }
        return "redirect:/login";

    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response
            , Model model, @RequestParam(required = false) String url) {
        CookieUtils.deleteCookie(request, response, "token");
        return login(url, request, model);
    }
}
