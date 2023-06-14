package com.example.weather.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class logincontroller {
    @RequestMapping("/user/login")
    @ResponseBody
    public String userlogin(){
        return "login successfully";
    }
}
//TODO 写对应css属性login