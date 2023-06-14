package com.example.weather.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexcontroller {
    @RequestMapping("/user/login")
    public String index(){
        return "login";
    }
}
