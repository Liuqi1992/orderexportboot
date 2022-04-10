package com.order.controller;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableConfigurationProperties
public class LoginController {
	
	@RequestMapping(value="/user/login",method=RequestMethod.GET)
	public String welcome(){
		return "/vm/user/login";
	}
}
