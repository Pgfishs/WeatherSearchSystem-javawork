package com.example.weather.service;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class disasters implements dojson {
    String KEY = "17b569ad44604504924c54b2e61c86bd";
    @Override
    public String dealJSON(String city) {
        String _city = URLEncoder.encode(city, StandardCharsets.UTF_8);
        String location = cityidsearch.getcityid(_city);
        String URL = "https://devapi.qweather.com/v7/warning/now?location ="+location+"&key ="+KEY+"&gzip=n";
        JSONObject json = JSON.parseObject(URL);
        //TODO 等待
        return null;
    }
}//TODO 处理灾难预警JSON
