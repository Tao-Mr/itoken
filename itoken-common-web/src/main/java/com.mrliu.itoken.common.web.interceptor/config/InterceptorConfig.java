package com.mrliu.itoken.common.web.interceptor.config;

import com.mrliu.itoken.common.web.interceptor.ConstantsInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ProjectName: itoken
 * @Package: com.mrliu.itoken.common.web.interceptor.config
 * @Description: 拦截器配置文件
 * @Author: LLT
 * @Date: 2019/5/27 18:58
 * @UpdateRemark: 更新说明
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public ConstantsInterceptor constantsInterceptor() {
        return new ConstantsInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(constantsInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/static/**");
    }
}
