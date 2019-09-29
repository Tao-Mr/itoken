package com.mrliu.itoken.service.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @ProjectName: itoken
 * @Package: com.mrliu.itoken.service.admin
 * @Description: 管理员服务提供者
 * @Date: 2019/4/17 14:21
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.mrliu.itoken.common.mapper", "com.mrliu.itoken.service.admin.mapper"})
public class ServiceAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAdminApplication.class, args);
    }
}
