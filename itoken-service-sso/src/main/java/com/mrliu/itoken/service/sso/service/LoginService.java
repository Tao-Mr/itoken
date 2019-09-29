package com.mrliu.itoken.service.sso.service;

import com.mrliu.itoken.common.domain.TbSysUser;

/**
 * @ProjectName: 登录接口
 * @Package: com.mrliu.itoken.service.sso.service
 * @Description: java类作用描述
 * @Author: LLT
 * @Date: 2019/5/23 10:17
 * @UpdateRemark: 更新说明
 */
public interface LoginService {
    /**
     * @param loginCode
     * @param plantPassword
     * @return
     */
    public TbSysUser login(String loginCode, String plantPassword);
}
