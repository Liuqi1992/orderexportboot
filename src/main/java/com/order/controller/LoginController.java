package com.order.controller;

import com.order.service.AdminService;
import com.order.model.AdminModel;
import org.apache.commons.httpclient.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@EnableAutoConfiguration
@EnableConfigurationProperties
public class LoginController {

    @Autowired
    private AdminService adminService;
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
    public String login(){
        return "/vm/admin/login";
    }

    @RequestMapping(value="/admin/loginout",method=RequestMethod.GET)
    public String loginOut(HttpServletRequest request){
        request.getSession().setAttribute("adminName","");
        return "/vm/admin/login";
    }

	@RequestMapping(value = "/admin/login", method=RequestMethod.POST)
    @ResponseBody
	public Result logining(HttpServletRequest request, @RequestParam String username, @RequestParam String password) {
	    Result rlt = new Result();
        rlt.setRlt(200);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", username);
        List<AdminModel> list = adminService.list(map);
        boolean flag = false;
        if (list.size() > 0) {
            AdminModel admin = list.get(0);
            if (password.equals(admin.getPassword())) {
                request.getSession().setAttribute("adminName",admin.getName());
                request.getSession().setMaxInactiveInterval(2 * 60 *60);
                flag = true;
            }
        }
        if (!flag) {
            rlt.setRlt(HttpStatus.SC_BAD_REQUEST);
            rlt.setTxt("username or password is incorrect");
        }
	    return rlt;
    }

    @RequestMapping(value = "/system/page", method=RequestMethod.GET)
    public String systemPage() {
        return "/vm/system/page";
    }

    public class Result {
        private int rlt;
        private String txt;

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
