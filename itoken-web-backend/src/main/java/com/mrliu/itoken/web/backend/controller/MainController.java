package com.mrliu.itoken.web.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ProjectName: itoken
 * @Package: com.mrliu.itoken.web.backend.controller
 * @Description: java类作用描述
 * @Author: LLT
 * @Date: 2019/7/5 10:35
 * @UpdateRemark: 更新说明
 */
@Controller
public class MainController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String main() {
        return "main";
    }

    @RequestMapping(value = "welcome", method = RequestMethod.GET)
    public String welcome() {
        return "welcome";
    }
}
