package com.mrliu.itoken.web.admin.Interceptor;

import com.mrliu.itoken.common.domain.TbSysUser;
import com.mrliu.itoken.common.utils.CookieUtils;
import com.mrliu.itoken.common.utils.MapperUtils;
import com.mrliu.itoken.common.web.interceptor.utils.HttpServletUtils;
import com.mrliu.itoken.web.admin.service.RedisService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ProjectName: itoken
 * @Package: com.mrliu.itoken.web.admin.Interceptor
 * @Description: java类作用描述
 * @Author: LLT
 * @Date: 2019/5/29 15:16
 * @UpdateRemark: 更新说明
 */
public class WebAdminInterceptor implements HandlerInterceptor {

    @Autowired
    RedisService redisService;

    private static String HOSTS_SSO = "http://localhost:8503";
    private static String LOCAL_SSO = "http://localhost:8601";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = CookieUtils.getCookieValue(request, "token");

        //为空一定没有登录
        if (StringUtils.isBlank(token)) {
            try {
                //response.sendRedirect("http://localhost:8503/login?url=http://localhsot:8602");
                response.sendRedirect(String.format("%s/login?url=%s", HOSTS_SSO, LOCAL_SSO + request.getServletPath()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;

        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

        HttpSession session = request.getSession();
        TbSysUser tbSysUser = (TbSysUser) session.getAttribute("admin");
        //已登录状态
        if (tbSysUser != null) {
            if (modelAndView != null) {
                modelAndView.addObject("admin", tbSysUser);
            }
        }
        //未登录状态
        else {
            String token = CookieUtils.getCookieValue(request, "token");

            if (StringUtils.isNotBlank(token)) {
                String loginCode = redisService.get(token);
                if (StringUtils.isNotBlank(loginCode)) {
                    String json = redisService.get(loginCode);
                    if (StringUtils.isNotBlank(json)) {
                        try {
                            //you登录信息，已登录，创建局部会话
                            tbSysUser = MapperUtils.json2pojo(json, TbSysUser.class);
                            if (modelAndView != null) {
                                modelAndView.addObject("admin", tbSysUser);
                            }
                            request.getSession().setAttribute("admin", tbSysUser);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        //二次确认
        if (tbSysUser == null) {
            try {
                response.sendRedirect(String.format("%s/login?url=%s", HOSTS_SSO, LOCAL_SSO + request.getServletPath()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
