package com.order.controller;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableConfigurationProperties
public class LoginController {
	
	@RequestMapping(value="/user/login",method=RequestMethod.GET)
	public String login(){
		return "/vm/user/login";
	}

	@RequestMapping(value = "/user/logining", method=RequestMethod.POST)
    @ResponseBody
	public String logining(@RequestParam String username, @RequestParam String password) {
	    return "aa";
    }

    @RequestMapping(value = "/user/loginsys", method=RequestMethod.GET)
    public String loginsys() {
        return "/vm/system/login";
    }
}
