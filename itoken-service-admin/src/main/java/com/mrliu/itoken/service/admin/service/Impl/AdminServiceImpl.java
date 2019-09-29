package com.mrliu.itoken.service.admin.service.Impl;

import com.mrliu.itoken.common.domain.TbSysUser;
import com.mrliu.itoken.common.mapper.TbSysUserMapper;
import com.mrliu.itoken.common.mapper.service.Impl.BaseServiceImpl;
import com.mrliu.itoken.service.admin.service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends BaseServiceImpl<TbSysUser, TbSysUserMapper> implements AdminService {
}
