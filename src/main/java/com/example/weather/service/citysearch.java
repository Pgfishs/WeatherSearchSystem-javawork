package com.example.weather.service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import com.alibaba.fastjson2.*;

public class citysearch{
    String KEY = "17b569ad44604504924c54b2e61c86bd";
    String locationid;

    public String getcityid(String city) {
        String _city = URLEncoder.encode(city, StandardCharsets.UTF_8);
        String URL = "https://geoapi.qweather.com/v2/city/lookup?location="+city+"&key="+KEY;
        JSONObject json =JSON.parseObject(URL);
        JSONArray locations =(JSONArray)json.get("location");
        if(locations == null || locations.isEmpty()) {
            System.out.println("do not search this city");
        }
        if (locations != null) {
            JSONObject location= locations.getJSONObject(0);
            locationid =  location.getString("id");
        }
        return locationid;
    }

}
