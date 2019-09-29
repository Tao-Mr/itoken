package com.mrliu.itoken.service.sso.service.Impl;

import com.mrliu.itoken.common.domain.TbSysUser;
import com.mrliu.itoken.common.utils.MapperUtils;
import com.mrliu.itoken.service.sso.consumer.RedisService;
import com.mrliu.itoken.service.sso.mapper.TbSysUserMapper;
import com.mrliu.itoken.service.sso.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.entity.Example;

/**
 * @ProjectName: itoken
 * @Package: com.mrliu.itoken.service.sso.service.Impl
 * @Description: java类作用描述
 * @Author: LLT
 * @Date: 2019/5/23 10:20
 * @UpdateRemark: 更新说明
 */
@Service
public class LoginServiceImpl implements LoginService {

    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private RedisService redisService;
    @Autowired
    private TbSysUserMapper tbSysUserMapper;

    @Override
    public TbSysUser login(String loginCode, String plantPassword) {

        TbSysUser tbSysUser = null;
        String json = redisService.get(loginCode);
        //缓存中没有数据
        if (json == null) {
            Example example = new Example(TbSysUser.class);
            example.createCriteria().andEqualTo("loginCode", loginCode);

            tbSysUser = tbSysUserMapper.selectOneByExample(example);
            String password = DigestUtils.md5DigestAsHex(plantPassword.getBytes());
            if (tbSysUser != null && password.equals(tbSysUser.getPassword())) {
                try {
                    redisService.put(loginCode, MapperUtils.obj2json(tbSysUser), 60 * 60 * 24);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return tbSysUser;
            }
            return null;

        } else {
            try {
                tbSysUser = MapperUtils.json2pojo(json, TbSysUser.class);
            } catch (Exception e) {
                logger.warn("触发了熔断：{}", e.getMessage());
            }
        }
        return tbSysUser;
    }

}
