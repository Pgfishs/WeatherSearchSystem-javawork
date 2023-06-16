package com.example.weather.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.*;
import org.springframework.util.*;

import java.sql.SQLException;

import com.example.weather.db.userinfoDB;

@Controller
public class registercontroller {
    @RequestMapping("/page/register")
    public String registerpage() {
        return "register";
    }

    @RequestMapping("/user/register")
    public String userregister(@RequestParam("nickname") String nickname,
                               @RequestParam("password") String password,
                               @RequestParam("userid") String userid) throws SQLException, ClassNotFoundException {
        if (!ObjectUtils.isEmpty(nickname) && !ObjectUtils.isEmpty(password) && !ObjectUtils.isEmpty(userid)) {
            String location = "UNKNOWN";
            String VIP = "N";
            userinfoDB db = userinfoDB.getInstance();
            boolean is = db.registerUserinfo(Integer.parseInt(userid), nickname, password, location, VIP);
            if (is) {
                return "register_successfully";
            } else {
                return "register_error";
            }
        } else {
            return "register_error";
        }
    }
}
//TODO 写对应css属性register
