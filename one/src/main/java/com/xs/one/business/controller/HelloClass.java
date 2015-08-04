package com.xs.one.business.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloClass {
	@RequestMapping(value="/hello",method = RequestMethod.GET)
	public String hello(ModelMap modelMap){
		modelMap.put("msg", "hello,world!");
		return "HelloWorld";
	}
}
