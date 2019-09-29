package com.mrliu.itoken.common.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ProjectName: itoken
 * @Package: com.mrliu.itoken.common.web.interceptor
 * @Description: 初始化常量拦截器
 * @Author: LLT
 * @Date: 2019/5/27 18:46
 * @UpdateRemark: 更新说明
 */
public class ConstantsInterceptor implements HandlerInterceptor {
    //CDN地址
    private static final String HOST_CDN = "http://192.168.186.128:81";
    public static final String TEMPLATE_ADMIN_LTE = "/adminlte/v2.4.3";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

        if (modelAndView != null) {
            modelAndView.addObject("adminlte", HOST_CDN + TEMPLATE_ADMIN_LTE);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}


