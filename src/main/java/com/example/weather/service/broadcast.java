package com.example.weather.service;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class broadcast implements dojson {
    String KEY = "17b569ad44604504924c54b2e61c86bd";

    @Override
    public String dealJSON(String city) {
        String _city = URLEncoder.encode(city, StandardCharsets.UTF_8);
        String location = cityidsearch.getcityid(_city);
        String URL = "https://devapi.qweather.com/v7/weather/7d?location=" + location + "&key=" + KEY + "&gzip=n";
        String tempMax = null;
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(URL).openConnection();
            connection.setRequestMethod("GET");
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                inputStream.close();
                tempMax = response.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tempMax;
    }//TODO 改bug
}
//TODO 处理天气预报JSON
