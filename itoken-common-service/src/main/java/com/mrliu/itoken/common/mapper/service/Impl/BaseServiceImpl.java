package com.mrliu.itoken.common.mapper.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mrliu.itoken.common.domain.BaseDomain;
import com.mrliu.itoken.common.mapper.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.MyMapper;

import java.util.Date;

/**
 * @ProjectName: itoken
 * @Package: com.mrliu.itoken.common.mapper.service.Impl
 * @Description: java类作用描述
 * @Author: LLT
 * @Date: 2019/6/3 14:24
 * @UpdateRemark: 更新说明
 */
@Service
@Transactional(readOnly = true)
public abstract class BaseServiceImpl<T extends BaseDomain, D extends MyMapper<T>> implements BaseService<T> {

    @Autowired
    private D dao;

    @Override
    @Transactional(readOnly = false)
    public int insert(T t, String creatBy) {
        t.setCreateBy(creatBy);
        t.setCreateDate(new Date());
        return dao.insert(t);
    }

    @Override
    @Transactional(readOnly = false)
    public int delete(T t) {
        return dao.delete(t);
    }

    @Override
    @Transactional(readOnly = false)
    public int update(T t, String updateBy) {
        t.setUpdateBy(updateBy);
        t.setUpdateDate(new Date());
        return dao.updateByPrimaryKey(t);
    }

    @Override
    public int count(T t) {
        return dao.selectCount(t);
    }

    @Override
    public T selectOne(T t) {
        return dao.selectOne(t);
    }

    @Override
    public PageInfo<T> page(int pageNum, int pageSize, T t) {
        PageHelper pageHelper = new PageHelper();
        pageHelper.startPage(pageNum, pageSize);

        PageInfo<T> pageInfo = new PageInfo<>(dao.select(t));
        return pageInfo;
    }
}
