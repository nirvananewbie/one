package com.xs.one.business.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by xusen on 2015/8/4.
 */
@Controller
public class ThDemoClass {
    static Logger logger = LoggerFactory.getLogger(ThDemoClass.class);

    @RequestMapping(value="/th/demo",method = RequestMethod.GET)
    public String thdemo(ModelMap modelMap){
        logger.debug("进入方法thdemo......");
        String msg = "这是thymleaf示例。";
        modelMap.put("msg",msg);

        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        Set<String> keySet = map.keySet();
        ArrayList<String> keyList = new ArrayList<String>();
        keyList.addAll(keySet);
        modelMap.put("list",keyList);


        return "/thymleaf/demo";
    }
}
