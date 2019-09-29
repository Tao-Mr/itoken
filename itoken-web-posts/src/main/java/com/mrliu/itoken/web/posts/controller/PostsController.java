package com.mrliu.itoken.web.posts.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mrliu.itoken.common.domain.TbPostsPost;
import com.mrliu.itoken.common.domain.TbSysUser;
import com.mrliu.itoken.common.dto.BaseResult;
import com.mrliu.itoken.common.utils.MapperUtils;
import com.mrliu.itoken.common.web.interceptor.constants.WebConstants;
import com.mrliu.itoken.common.web.interceptor.controller.BaseController;
import com.mrliu.itoken.web.posts.service.PostsService;
import org.apache.commons.lang.StringUtils;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @ProjectName: itoken
 * @Package: com.mrliu.itoken.web.posts.controller
 * @Description: java类作用描述
 * @Author: LLT
 * @Date: 2019/6/5 14:59
 * @UpdateRemark: 更新说明
 */
@Controller
public class PostsController extends BaseController<TbPostsPost, PostsService> {

    @Autowired
    private PostsService postsService;

    @ModelAttribute
    public TbPostsPost tbPostsPost(String postGuid) {
        TbPostsPost tbPostsPost = null;
        if (StringUtils.isBlank(postGuid)) {
            tbPostsPost = new TbPostsPost();
        } else {
            String json = postsService.get(postGuid);
            try {
                tbPostsPost = MapperUtils.json2pojo(json, TbPostsPost.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 二次确认是否为空
            if (tbPostsPost == null) {
                tbPostsPost = new TbPostsPost();
            }
        }
        return tbPostsPost;
    }

    /**
     * 跳转到首页
     * @return main.html
     */
    @RequestMapping(value = {"main", ""}, method = RequestMethod.GET)
    public String main() {
        return "main";
    }

    /**
     * 跳转列表页
     * @return index.html
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    /**
     * 跳转表单页面
     * @return form.html
     */
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(String id, Model model) {
        if(id==null){
            return "form";
        }else{
            String json = postsService.get(id);
            try {
                JSONObject jsonObject= JSON.parseObject(json);
                String pJson=jsonObject.getString("data");
                TbPostsPost tbPostsPost = MapperUtils.json2pojo(pJson, TbPostsPost.class);
                model.addAttribute(tbPostsPost);
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "form";
        }
    }
    /**
     * 跳转详细信息页面
     * @return detail.html
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail(String id, Model model) {
        if(id==null){
            return "error";
        }else{
            String json = postsService.get(id);
            try {
                JSONObject jsonObject= JSON.parseObject(json);
                String pJson=jsonObject.getString("data");
                TbPostsPost tbPostsPost = MapperUtils.json2pojo(pJson, TbPostsPost.class);
                model.addAttribute(tbPostsPost);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "detail";
        }
    }
    /**
     * 保存文章
     * @param tbPostsPost
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbPostsPost tbPostsPost, HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        // 初始化
        tbPostsPost.setTimePublished(new Date());
        tbPostsPost.setStatus("0");
        TbSysUser admin = (TbSysUser) request.getSession().getAttribute(WebConstants.SESSION_USER);
        String tbPostsPostJson = MapperUtils.obj2json(tbPostsPost);
        String json = postsService.save(tbPostsPostJson, admin.getUserCode());
        BaseResult baseResult = MapperUtils.json2pojo(json, BaseResult.class);

        redirectAttributes.addFlashAttribute("baseResult", baseResult);
        //约定末尾成功为成功
        if (baseResult.getSuccess().startsWith("成功")) {
            return "redirect:/index";
        }
        return "redirect:/form";
    }
    /*
    *删除
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String deletePosts(String id,Model model,HttpServletRequest request){
        if(id==null){
            return "error";
        }else{
            String json = postsService.get(id);
            try {
                JSONObject jsonObject= JSON.parseObject(json);
                String pJson=jsonObject.getString("data");
                TbSysUser admin = (TbSysUser) request.getSession().getAttribute(WebConstants.SESSION_USER);
                String jsonRes=postsService.delete(pJson,admin.getUserCode());
                JSONObject jsonObjectRes= JSON.parseObject(jsonRes);
                String pJsonRes=jsonObjectRes.getString("data");
                model.addAttribute("JsonResult",pJsonRes);
                BaseResult baseResult = MapperUtils.json2pojo(jsonRes, BaseResult.class);
                if (baseResult.getSuccess().startsWith("成功")) {
                    return "redirect:/index";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "detail";
        }
    }
}
