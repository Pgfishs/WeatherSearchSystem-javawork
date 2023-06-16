package com.example.weather.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import com.alibaba.fastjson2.*;

public class cityidsearch {
    static String KEY = "17b569ad44604504924c54b2e61c86bd";
    static String locationid;

    public static String getcityid(String city) {
        String _city = URLEncoder.encode(city, StandardCharsets.UTF_8);
        String URL = "https://geoapi.qweather.com/v2/city/lookup?location="+_city+"&key="+KEY+"&gzip=n";
        String locationid = null;
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(URL).openConnection();
            connection.setRequestMethod("GET");
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                inputStream.close();

                JSONObject json = JSON.parseObject(response.toString());
                JSONArray locations = json.getJSONArray("location");
                if (locations != null && !locations.isEmpty()) {
                    JSONObject location= locations.getJSONObject(0);
                    locationid =  location.getString("id");
                } else {
                    System.out.println("do not search this city");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return locationid;
    }

}//获取对应城市的location id
