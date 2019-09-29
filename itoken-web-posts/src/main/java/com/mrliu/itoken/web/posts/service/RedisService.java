package com.mrliu.itoken.web.posts.service;

import com.mrliu.itoken.web.posts.service.fallback.RedisServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ProjectName: itoken
 * @Package: com.mrliu.itoken.web.posts.service
 * @Description: java类作用描述
 * @Author: LLT
 * @Date: 2019/5/29 15:57
 * @UpdateRemark: 更新说明
 */
@FeignClient(value = "itoken-service-redis", fallback = RedisServiceFallback.class)
public interface RedisService {
    @RequestMapping(value = "put", method = RequestMethod.POST)
    public String put(@RequestParam(value = "key") String key, @RequestParam(value = "value") String value, @RequestParam(value = "seconds") int seconds);

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public String get(@RequestParam(value = "key") String key);


}
