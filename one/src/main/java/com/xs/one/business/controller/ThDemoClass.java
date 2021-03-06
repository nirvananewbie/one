package com.xs.one.business.controller;

import com.xs.one.business.domain.entity.TUser;
import com.xs.one.business.service.ThDemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.ParseException;
import java.util.*;

/**
 * Created by xusen on 2015/8/4.
 */
@Controller
public class ThDemoClass {
    static Logger logger = LoggerFactory.getLogger(ThDemoClass.class);
    @Autowired
    private ThDemoService thDemoService;

    @RequestMapping(value="/th/demo",method = RequestMethod.GET)
    public String thdemo(ModelMap modelMap) throws ParseException {
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
        modelMap.put("list", keyList);

        modelMap.put("flag","yes");

        TUser user = thDemoService.getUserById("1");
        modelMap.put("user",user);

        return "/thymleaf/demo";
    }
}
