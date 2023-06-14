package com.example.weather.service;
import com.alibaba.fastjson2.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class realtimeweather implements dojson{
    String KEY = "17b569ad44604504924c54b2e61c86bd";
    @Override
    public String dealJSON(String city) {
        String _city = URLEncoder.encode(city, StandardCharsets.UTF_8);
        String location = cityidsearch.getcityid(_city);
        String URL = "https://devapi.qweather.com/v7/weather/now?location ="+location+"&key ="+KEY+"&gzip=n";
        JSONObject json = JSON.parseObject(URL);
        /*TODO 这里要写一堆处理JSON内容的变量，等待前端*/
        return null;
    }
}//TODO 处理实时天气JSON （现在先写成这样）
