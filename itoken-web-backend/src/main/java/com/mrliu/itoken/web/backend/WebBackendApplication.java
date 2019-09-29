package com.mrliu.itoken.web.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ProjectName: itoken
 * @Package: com.mrliu.itoken.web.backend
 * @Description: java类作用描述
 * @Author: LLT
 * @Date: 2019/7/4 17:23
 * @UpdateRemark: 更新说明
 */
@SpringBootApplication(scanBasePackages = "com.mrliu.itoken")
@EnableDiscoveryClient
@EnableFeignClients

public class WebBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebBackendApplication.class, args);
    }
}
