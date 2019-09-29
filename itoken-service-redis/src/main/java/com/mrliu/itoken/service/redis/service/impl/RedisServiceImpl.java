package com.mrliu.itoken.service.redis.service.impl;

import com.mrliu.itoken.service.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: itoken
 * @Package: com.mrliu.itoken.service.redis.service.impl
 * @Description: java类作用描述
 * @Author: LLT
 * @Date: 2019/5/21 10:09
 * @UpdateRemark: 更新说明
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void put(String key, Object value, long seconds) {
        redisTemplate.opsForValue().set(key, value, seconds, TimeUnit.SECONDS);

    }

    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
