package com.xs.one.business.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by xusen on 2015/8/5.
 */
@Controller
public class IndexController {
    @RequestMapping(value={"/index","/"},method = RequestMethod.GET)
    public String index(ModelMap modelMap){
        return "/index";
    }
}
