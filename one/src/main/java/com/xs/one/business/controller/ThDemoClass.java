package com.xs.one.business.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by xusen on 2015/8/4.
 */
@Controller
public class ThDemoClass {
    @RequestMapping(value="/th/demo",method = RequestMethod.GET)
    public String thdemo(ModelMap modelMap){
        String msg = "这是thymleaf示例。";
        modelMap.put("msg",msg);
        return "/thymleaf/demo";
    }
}
