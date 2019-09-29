package com.mrliu.itoken.common.hystrix;

import com.google.common.collect.Lists;
import com.mrliu.itoken.common.constants.HttpStatusConstants;
import com.mrliu.itoken.common.dto.BaseResult;
import com.mrliu.itoken.common.utils.MapperUtils;

/**
 * @ProjectName: itoken
 * @Package: com.mrliu.itoken.common.hystrix
 * @Description: java类作用描述
 * @Author: LLT
 * @Date: 2019/5/23 10:34
 * @UpdateRemark: 更新说明
 */
public class FallBack {
    /**
     * 通用的熔断方法
     *
     * @return
     */
    public static String badGetway() {
        BaseResult baseResult = BaseResult.notok(Lists.newArrayList(
                new BaseResult.Error(
                        String.valueOf(HttpStatusConstants.BAD_GATEWAY.getStatus()),
                        String.valueOf(HttpStatusConstants.BAD_GATEWAY.getContent()))));
        try {
            return MapperUtils.obj2json(baseResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
