package com.example.weather.dao;

import com.example.weather.eneity.UserInfoEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CityDB {
    static Connection conn;
    String name;
    CityDB() throws ClassNotFoundException, SQLException {
        String user="root";
        String password="pgy040427";
        String URL ="jdbc:mysql://localhost:3306/weathersearchsystem?" +
                "useUnicode=true&characterEncoding=utf8&&useSSL=false";
        Class.forName("com.mysql.cj.jdbc.Driver");

        conn = DriverManager.getConnection(URL, user, password);
    }


}
    //TODO CityDBInfo modify

