package com.mrliu.itoken.web.admin.service.fallback;

import com.google.common.collect.Lists;
import com.mrliu.itoken.common.constants.HttpStatusConstants;
import com.mrliu.itoken.common.domain.TbSysUser;
import com.mrliu.itoken.common.dto.BaseResult;
import com.mrliu.itoken.common.hystrix.FallBack;
import com.mrliu.itoken.common.utils.MapperUtils;
import com.mrliu.itoken.web.admin.service.AdminService;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: itoken
 * @Package: com.mrliu.itoken.web.admin.service.fallback
 * @Description: java类作用描述
 * @Author: LLT
 * @Date: 2019/5/7 15:15
 * @UpdateRemark: 更新说明
 */
@Component
public class AdminServiceFallback implements AdminService {
    @Override
    public String get(String userCode) {
        try {
            String json = MapperUtils.obj2json(new TbSysUser());
            return json;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String save(String tbSysUserJson, String optsBy) {
        return FallBack.badGetway();
    }

    @Override
    public String page(int pageNum, int pageSize, String tbSysUserJson) {
        return FallBack.badGetway();
    }
}
