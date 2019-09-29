package com.mrliu.itoken.service.admin.mapper;

import com.mrliu.itoken.common.domain.TbSysUser;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.MyMapper;

@Repository
public interface TbSysUserExtendMapper extends MyMapper<TbSysUser> {
}