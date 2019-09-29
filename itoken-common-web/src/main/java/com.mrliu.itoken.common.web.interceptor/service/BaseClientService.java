package com.mrliu.itoken.common.web.interceptor.service;

import com.mrliu.itoken.common.hystrix.FallBack;

/**
 * 通用服务消费者接口
 * <p>Title: BaseClientService</p>
 * <p>Description: </p>
 *
 * @version 1.0.0
 */
public interface BaseClientService {
    default String page(int pageNum, int pageSize, String domainJson) {
        return FallBack.badGetway();
    }
}
