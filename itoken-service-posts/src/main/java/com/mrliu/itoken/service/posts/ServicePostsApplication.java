package com.mrliu.itoken.service.posts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @ProjectName: itoken
 * @Package: com.mrliu.itoken.service.posts
 * @Description: java类作用描述
 * @Author: LLT
 * @Date: 2019/6/3 17:29
 * @UpdateRemark: 更新说明
 */
@SpringBootApplication(scanBasePackages = "com.mrliu.itoken")
@EnableEurekaClient
@EnableSwagger2
@MapperScan(basePackages = {"com.mrliu.itoken.common.mapper", "com.mrliu.itoken.service.posts.mapper"})

public class ServicePostsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServicePostsApplication.class, args);
    }
}
