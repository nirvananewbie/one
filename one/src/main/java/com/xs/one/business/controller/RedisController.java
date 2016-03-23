package com.xs.one.business.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xusen@asiainfo.com on 2016/3/23.
 */
@Controller
public class RedisController {
    static Logger logger = LoggerFactory.getLogger(RedisController.class);

    @Autowired
    private Jedis jedis;

    @RequestMapping(value="/th/redis",method = RequestMethod.GET)
    public String redis(ModelMap modelMap) throws ParseException {
        String user = "";
        //Jedis jedis = new Jedis("10.20.16.74",6379);
        user = jedis.get("user");
        modelMap.put("user",user);
        return "/thymleaf/redisDemo";
    }
    @RequestMapping(value = {"/setVal"}, method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object setVal(HttpServletRequest request){
        String user = request.getParameter("user");
        //Jedis jedis = new Jedis("10.20.16.74",6379);
        jedis.set("user",user);
        Map<String,String> map = new HashMap<String, String>();
        map.put("msg","success");
        return map;
    }
}
