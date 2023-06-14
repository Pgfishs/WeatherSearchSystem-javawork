package com.example.weather.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class userlogin {
    //@RequestMapping("/user/login")
    @ResponseBody
    public String login(){
        return "login successfully";//这段应该要改成重定向
    }
}//TODO 完成一下login页面后端函数的实现（感觉要一段时间）
