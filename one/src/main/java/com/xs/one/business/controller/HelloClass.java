package com.xs.one.business.controller;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Controller
public class HelloClass {
	private Logger logger = LoggerFactory.getLogger(HelloClass.class);

	@RequestMapping(value="/hello",method = RequestMethod.GET)
	public String hello(ModelMap modelMap){
		modelMap.put("msg", "hello,world!");
		return "HelloWorld";
	}

	/**
	 * 通过HttpClient发送HTTP请求
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/http",method = RequestMethod.GET)
	public String http(ModelMap modelMap){
		logger.info("开始捕获URL内容...");
		String url = "http://www.baidu.com";
		//组装请求
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		//接收响应
		HttpResponse response = null;
		try {
			response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			byte[] bytes = EntityUtils.toByteArray(entity);
			String result = new String(bytes,"utf8");
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
}
