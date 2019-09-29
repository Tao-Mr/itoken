package com.mrliu.itoken.web.posts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ProjectName: itoken
 * @Package: com.mrliu.itoken.web.posts
 * @Description: java类作用描述
 * @Author: LLT
 * @Date: 2019/6/5 11:41
 * @UpdateRemark: 更新说明
 */
@SpringBootApplication(scanBasePackages = "com.mrliu.itoken")
@EnableDiscoveryClient
@EnableFeignClients
public class WebPostsApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebPostsApplication.class, args);
    }
}
