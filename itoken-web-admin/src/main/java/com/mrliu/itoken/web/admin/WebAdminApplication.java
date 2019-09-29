package com.mrliu.itoken.web.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ProjectName: itoken
 * @Package: com.mrliu.itoken.web.admin
 * @Description: java类作用描述
 * @Author: LLT
 * @Date: 2019/5/7 14:30
 * @UpdateRemark: 更新说明
 */
@SpringBootApplication(scanBasePackages = "com.mrliu.itoken")
@EnableDiscoveryClient
@EnableFeignClients
public class WebAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebAdminApplication.class, args);
    }
}
