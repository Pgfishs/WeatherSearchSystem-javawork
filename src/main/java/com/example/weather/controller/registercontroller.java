package com.example.weather.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.*;
import org.springframework.util.*;
@Controller
public class registercontroller {
    @RequestMapping("/page/register")
    public String registerpage() {
        return "register";
    }
    @RequestMapping("/user/register")
    @ResponseBody
    public String userregister(@RequestParam("userid") int userid,
                               @RequestParam("nickname") String nickname,
                               @RequestParam("password") String password){
        return "register successfully";
    }

}
//TODO 写对应css属性register
// 研究怎么实现userregister调用到db中的方法