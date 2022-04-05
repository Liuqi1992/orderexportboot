package com.order.controller;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableConfigurationProperties
public class WelcomeController {
	
	@RequestMapping(value="/welcome",method=RequestMethod.GET)
	@ResponseBody
	public String welcome(){
		return "welcome";
	}
}
