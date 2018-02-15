package com.electroproshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	@RequestMapping("/aboutUs")
	public String aboutUs(){
		return "aboutUs";
	}
	
	@RequestMapping("403Error")
	public String Error(){
		return "403";
	}
	
	
}
