package com.example.weather.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import static com.example.weather.service.cityidsearch.getcityid;


@Controller
public class cityController {
    @RequestMapping("/page/search")
    public String tosearch(){
        return "search";
    }

    @RequestMapping("/city/search")
    @ResponseBody
    public String citysearch(@RequestParam("city") String city,Model model){
        String location = getcityid(city);

        return location;
    }



}