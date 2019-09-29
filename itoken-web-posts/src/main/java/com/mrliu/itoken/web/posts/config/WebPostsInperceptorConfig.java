package com.mrliu.itoken.web.posts.config;

import com.mrliu.itoken.web.posts.Interceptor.WebPostsInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ProjectName: itoken
 * @Package: com.mrliu.itoken.web.admin.config
 * @Description: java类作用描述
 * @Author: LLT
 * @Date: 2019/5/29 15:18
 * @UpdateRemark: 更新说明
 */
@Configuration
class WebInterceptorConfiguration implements WebMvcConfigurer {

    @Bean
    public WebPostsInterceptor webPostsInterceptor() {
        return new WebPostsInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(webPostsInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/static");
    }
}
