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
import java.util.zip.GZIPInputStream;

public class broadcast implements dojson {
    String KEY = "17b569ad44604504924c54b2e61c86bd";

    @Override
    public String dealJSON(String city) {
        String _city = URLEncoder.encode(city, StandardCharsets.UTF_8);
        String location = cityidsearch.getcityid(_city);
        String URL = "https://devapi.qweather.com/v7/weather/3d?location=" + location + "&key=" + KEY;
        String json = null;
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(URL).openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept-Encoding", "gzip");

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                String contentEncoding = connection.getContentEncoding();
                if (contentEncoding != null && contentEncoding.equalsIgnoreCase("gzip")) {
                    inputStream = new GZIPInputStream(inputStream);
                }

                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                inputStream.close();

                json = response.toString();
                System.out.println(json);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
}
