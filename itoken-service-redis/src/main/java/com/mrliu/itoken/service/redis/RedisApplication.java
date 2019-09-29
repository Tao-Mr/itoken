package com.mrliu.itoken.service.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ProjectName: itoken
 * @Package: com.mrliu.itoken.service.redis
 * @Description: java类作用描述
 * @Author: LLT
 * @Date: 2019/5/21 9:54
 * @UpdateRemark: 更新说明
 */
@EnableEurekaClient
@SpringBootApplication
public class RedisApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }
}
