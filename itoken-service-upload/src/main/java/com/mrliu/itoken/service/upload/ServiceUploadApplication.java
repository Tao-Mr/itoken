package com.mrliu.itoken.service.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ProjectName: itoken
 * @Package: com.mrliu.itoken.service.upload
 * @Description: java类作用描述
 * @Author: LLT
 * @Date: 2019/7/4 12:40
 * @UpdateRemark: 更新说明
 */
@EnableEurekaClient
@SpringBootApplication
public class ServiceUploadApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceUploadApplication.class, args);
    }
}
