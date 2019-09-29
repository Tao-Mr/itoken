package com.mrliu.itoken.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ProjectName: itoken
 * @Package: com.mrliu.itoken.eureka
 * @Description: 服务注册与发现
 * @Author: LLT
 * @Date: 2019/4/17 15:15
 * @UpdateRemark: 更新说明
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }
}
