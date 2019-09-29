package com.mrliu.itoken.service.admin.test.service;

//import com.mrliu.itoken.service.admin.domain.TbSysUser;
//import com.mrliu.itoken.service.admin.service.AdminService;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.util.DigestUtils;
//
//import java.util.Date;
//import java.util.UUID;
//
///**
// * @ProjectName: itoken
// * @Package: com.mrliu.itoken.service.admin.test.service
// * @Description: java类作用描述
// * @Author: LLT
// * @Date: 2019/4/23 17:07
// * @UpdateRemark: 更新说明
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Transactional
//@Rollback

public class ServiceAdminTest {

//    @Autowired
//    private AdminService adminService;
//    @Test
//    @Rollback
//    public void register(){
//        TbSysUser tbSysUser = new TbSysUser();
//        tbSysUser.setUserCode(UUID.randomUUID().toString());
//        tbSysUser.setLoginCode("lusifer@funtl.com");
//        tbSysUser.setUserName("Lusifer");
//        tbSysUser.setUserType("1");
//        tbSysUser.setMgrType("1");
//        tbSysUser.setStatus("0");
//        tbSysUser.setCreateBy(tbSysUser.getUserCode());
//        tbSysUser.setCreateDate(new Date());
//        tbSysUser.setUpdateBy(tbSysUser.getUserCode());
//        tbSysUser.setUpdateDate(new Date());
//        tbSysUser.setCorpCode("0");
//        tbSysUser.setCorpName("iToken");
//        tbSysUser.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
//        adminService.register(tbSysUser);
//
//    }
//    @Test
//    public void login(){
//        TbSysUser tbSysUser=adminService.login("11111","11111");
//        Assert.assertNotNull(tbSysUser);
//
//    }
}
