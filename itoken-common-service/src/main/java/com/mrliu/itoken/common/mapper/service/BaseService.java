package com.mrliu.itoken.common.mapper.service;

import com.github.pagehelper.PageInfo;
import com.mrliu.itoken.common.domain.BaseDomain;

/**
 * @ProjectName: itoken
 * @Package: com.mrliu.itoken.common.mapper.service
 * @Description: java类作用描述
 * @Author: LLT
 * @Date: 2019/6/3 14:20
 * @UpdateRemark: 更新说明
 */
public interface BaseService<T extends BaseDomain> {
    int insert(T t, String creatBy);

    int delete(T t);

    int update(T t, String updateBy);

    int count(T t);

    T selectOne(T t);

    PageInfo<T> page(int pageNum, int pageSize, T t);
}
