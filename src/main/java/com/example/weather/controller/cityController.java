package com.example.weather.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.example.weather.service.broadcast;
import com.example.weather.service.cityidsearch;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.*;


@Controller
public class cityController {
    @RequestMapping("/city/search")
    public String citySearch(@RequestParam("city") String city, Model model) {
        String location = cityidsearch.getcityid(city);
        broadcast bd = new broadcast();
        String maxtemp = bd.dealJSON(city);
        model.addAttribute("maxtemp", maxtemp);
        return "cityinfo";
    }
}