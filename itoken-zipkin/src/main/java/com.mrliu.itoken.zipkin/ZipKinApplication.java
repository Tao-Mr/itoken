package com.mrliu.itoken.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import zipkin.server.internal.EnableZipkinServer;

/**
 * @ProjectName: itoken
 * @Package: com.mrliu.itoken.zipkin
 * @Description: 分布式链路追踪
 * @Date: 2019/4/17 15:25
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
public class ZipKinApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZipKinApplication.class, args);
    }
}
