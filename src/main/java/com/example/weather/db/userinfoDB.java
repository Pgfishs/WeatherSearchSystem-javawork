package com.example.weather.db;

import java.sql.*;
import java.util.Objects;

public class userinfoDB {
    private static Connection conn;
    private static final String URL = "jdbc:mysql://localhost:3306/weathersearchsystem?useUnicode=true&characterEncoding=utf8&&useSSL=false";
    private static final String user = "root";
    private static final String password = "pgy040427";
    private static userinfoDB instance;

    // 私有构造函数
    private userinfoDB() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(URL, user, password);
    }

    // 获取单例对象
    public static userinfoDB getInstance() throws SQLException, ClassNotFoundException {
        if (instance == null) {
            instance = new userinfoDB();
        }
        return instance;
    }

    public boolean registerUserinfo(int UserID, String Nickname, String Password, String Location, String VIP)
            throws SQLException {
        String sql = "INSERT INTO userinfo (UserID, Nickname, Password, Location, VIP) VALUES(?,?,?,?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, UserID);
            stmt.setString(2, Nickname);
            stmt.setString(3, Password);
            stmt.setString(4, Location);
            stmt.setString(5, VIP);
            int rows = stmt.executeUpdate();
            return rows > 0;
        }
    }

    public String deleteUserinfo(int UserID) throws SQLException {
        String sql = "DELETE FROM userinfo WHERE UserID = ?";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, UserID);
            int rows = stmt.executeUpdate();
            return "delete user successfully";
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public String modifyUserinfo(int UserID, String Nickname,String Password,String Location)
            throws SQLException {
        String sql = "UPDATE userinfo SET Nickname = ?,Password = ?,Location=? WHERE UserID = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, Nickname);
        stmt.setString(2,Password);
        stmt.setString(3,Location);
        stmt.setInt(4,UserID);
        stmt.executeUpdate();
        return "modify user successfully";
    }

    public String searchUserinfo(int UserID) throws SQLException {
        String sql ="SELECT * FROM userinfo WHERE UserID = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, UserID);
        ResultSet rs = stmt.executeQuery();
        if (!rs.next()) {
            System.out.println("no user information");
        } else {
            String name = rs.getString("Nickname");
            String password = rs.getString("Password");
            String location = rs.getString("Location");
            String vip = rs.getString("VIP");
        }
        return "search user successfully";
    }

    public static Boolean loginUser(String nickname,String password) throws SQLException {
        String sql = "SELECT * FROM userinfo WHERE Nickname = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nickname);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        String p = rs.getString("Password");
        return Objects.equals(password, p);
    }
}
