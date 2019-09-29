package com.mrliu.itoken.service.redis.service;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ProjectName: itoken
 * @Package: com.mrliu.itoken.service.redis.service
 * @Description: java类作用描述
 * @Author: LLT
 * @Date: 2019/5/21 10:06
 * @UpdateRemark: 更新说明
 */
public interface RedisService {
    /**
     * @param key
     * @param value
     * @param seconds 超时时间
     */
    public void put(String key, Object value, long seconds);

    public Object get(String key);

}
