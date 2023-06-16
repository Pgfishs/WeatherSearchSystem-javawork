package com.example.weather.controller;

import com.example.weather.db.userinfoDB;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

@Controller
public class logincontroller {
    @RequestMapping("/user/login")
    public String userlogin(@RequestParam("userinfo") String userinfo,
                            @RequestParam("password") String password,
                            Model model) throws SQLException, ClassNotFoundException {
        if(!ObjectUtils.isEmpty(userinfo) && !ObjectUtils.isEmpty(password)){
            userinfoDB db = userinfoDB.getInstance();
            boolean is = userinfoDB.loginUser(userinfo,password);
            if(is){return "main";}
            else {return "login_error";}
        } else {
            return "login_error";
        }
    }
}
//TODO 写对应css属性login