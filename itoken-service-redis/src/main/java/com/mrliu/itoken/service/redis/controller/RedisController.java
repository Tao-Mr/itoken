package com.mrliu.itoken.service.redis.controller;

import com.mrliu.itoken.service.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: itoken
 * @Package: com.mrliu.itoken.service.redis.controller
 * @Description: java类作用描述
 * @Author: LLT
 * @Date: 2019/5/21 10:15
 * @UpdateRemark: 更新说明
 */
@RestController
public class RedisController {
    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "put", method = RequestMethod.POST)
    public String put(String key, String value, long seconds) {
        redisService.put(key, value, seconds);
        return "ok";
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public Object get(String key) {
        Object obj = redisService.get(key);
        if (obj != null) {
            String json = String.valueOf(obj);
            return json;
        } else {
            return null;
        }
    }
}
