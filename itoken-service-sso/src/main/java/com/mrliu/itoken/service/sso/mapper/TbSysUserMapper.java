package com.mrliu.itoken.service.sso.mapper;

import com.mrliu.itoken.common.domain.TbSysUser;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.MyMapper;

@Mapper
public interface TbSysUserMapper extends MyMapper<TbSysUser> {
}