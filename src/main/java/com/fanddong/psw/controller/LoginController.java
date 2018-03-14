package com.fanddong.psw.controller;

import com.fanddong.psw.entity.LoginStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/pswkey")
public class LoginController {

    @GetMapping(value = "login")
    public String login() {
        return "login";
    }

    @PostMapping("login/submit")
    @ResponseBody
    public int loginSubmit(String usrname, String pwd) {
        System.out.println(usrname + "-" + pwd);
        LoginStatus loginStatus = LoginStatus.getInstance();
        boolean flag = LoginStatus.identity(usrname, pwd);
        if(flag) {
            loginStatus.setStatus(1);
            return 1;
        }
        return 0;
    }
}
