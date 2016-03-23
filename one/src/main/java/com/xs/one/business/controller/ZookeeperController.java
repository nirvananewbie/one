package com.xs.one.business.controller;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by xusen@asiainfo.com on 2016/3/23.
 */
@Controller
public class ZookeeperController {
    static Logger logger = LoggerFactory.getLogger(ZookeeperController.class);
    @Autowired
    private ZkClient zkClient;

    @RequestMapping(value="/th/zookeeper",method = RequestMethod.GET)
    public String zookeeper(ModelMap modelMap) throws ParseException {
        logger.debug("进入方法zookeeper......");

        //zookeeper
        //ZkClient zkClient = new ZkClient("10.20.16.74:2181");
        String node = "/app2";
        if (!zkClient.exists(node)) {
            zkClient.createPersistent(node, "hello zk");
        }
        String zkstr = zkClient.readData(node);
        modelMap.put("zk",zkstr);
        return "/thymleaf/zookeeperDemo";
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
