package com.mrliu.itoken.service.upload.fastdfs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: itoken
 * @Package: com.mrliu.itoken.service.upload.fastdfs
 * @Description: Java 配置方式定义 StorageFactory 的 Bean 使其可以被依赖注入
 * @Author: LLT
 * @Date: 2019/7/4 15:00
 * @UpdateRemark: 更新说明
 */

@Configuration
public class FastDFSConfiguration {
    @Bean
    public StorageFactory storageFactory() {
        return new StorageFactory();
    }
}
