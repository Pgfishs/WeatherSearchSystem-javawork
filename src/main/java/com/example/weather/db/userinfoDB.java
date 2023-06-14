package com.example.weather.db;
import java.sql.*;
public class userinfoDB {
    static Connection conn;

    public String registerUserinfo(int UserID, String Nickname,String Password,String Location,String VIP)
            throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO userinfo (UserID, Nickname, Password, Location, VIP) VALUES(?,?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, UserID);
        stmt.setString(2, Nickname);
        stmt.setString(3,Password);
        stmt.setString(4,Location);
        stmt.setString(5,VIP);
        stmt.executeUpdate();
        return "register user successfully";
    }

    public String deleteUserinfo(int UserID) throws SQLException {
        String sql = "DELETE FROM userinfo WHERE UserID = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, UserID);
        stmt.executeUpdate();
        return "delete user successfully";
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
}
