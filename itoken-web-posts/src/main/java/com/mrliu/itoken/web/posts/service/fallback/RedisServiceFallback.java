package com.mrliu.itoken.web.posts.service.fallback;

import com.mrliu.itoken.common.hystrix.FallBack;
import com.mrliu.itoken.web.posts.service.RedisService;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: itoken
 * @Package: com.mrliu.itoken.service.sso.consumer.failBack
 * @Description: java类作用描述
 * @Author: LLT
 * @Date: 2019/5/23 10:28
 * @UpdateRemark: 更新说明
 */
@Component
public class RedisServiceFallback implements RedisService {
    @Override
    public String put(String key, String value, int seconds) {
        return FallBack.badGetway();
    }

    @Override
    public String get(String key) {
        return null;
    }
}
