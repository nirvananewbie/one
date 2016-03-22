package com.xs.one.business.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.xs.one.business.domain.entity.TUser;
import com.xs.one.business.service.ThDemoService;
import org.I0Itec.zkclient.ZkClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by xusen on 2015/8/4.
 */
@Controller
public class ThDemoClass {
    static Logger logger = LoggerFactory.getLogger(ThDemoClass.class);
    @Autowired
    private ThDemoService thDemoService;
    @Autowired
    private ZkClient zkClient;

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

        //zookeeper
        //ZkClient zkClient = new ZkClient("10.20.16.74:2181");
        String node = "/app2";
        if (!zkClient.exists(node)) {
            zkClient.createPersistent(node, "hello zk");
        }
        String zkstr = zkClient.readData(node);
        modelMap.put("zk",zkstr);
        return "/thymleaf/demo";
    }
    @RequestMapping(value = {"/setZkVal"}, method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object setZkVal(HttpServletRequest request){
        String str = request.getParameter("zk");
        //ZkClient zkClient = new ZkClient("10.20.16.74:2181");
        String node = "/app2";
        if (!zkClient.exists(node)) {
            zkClient.createPersistent(node, str);
        }else{
            zkClient.writeData(node,str);
        }

        /*String zkstr = zkClient.readData(node);
        Map<String,String> map = new HashMap<String, String>();
        map.put("zk",zkstr);*/
        return "success";
    }
}
