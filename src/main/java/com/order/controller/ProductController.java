package com.order.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
@EnableConfigurationProperties
@RequestMapping("/product")
public class ProductController {


	@RequestMapping(value = "/list", method=RequestMethod.POST)
    @ResponseBody
	public Result logining(@RequestParam String username, @RequestParam String password) {
	    Result rlt = new Result();

	    return rlt;
    }

    public class Result {
        private int rlt;
        private String txt;

        private

        public int getRlt() {
            return rlt;
        }

        public void setRlt(int rlt) {
            this.rlt = rlt;
        }

        public String getTxt() {
            return txt;
        }

        public void setTxt(String txt) {
            this.txt = txt;
        }
    }
}
