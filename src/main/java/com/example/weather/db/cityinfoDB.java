package com.example.weather.db;
import java.sql.*;
public class cityinfoDB {
    static Connection conn;
    public static String addcityinfo(String cityname, int cityno) throws SQLException {
        String sql = "INSERT INTO cityinfo (Cityname, Cityno) VALUES (?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, cityname);
        stmt.setInt(2,cityno);
        stmt.executeUpdate();
        return "add city successfully";
    }

    public static String deletecityinfo(int cityno) throws SQLException {
        String sql = "DELETE FROM cityinfo WHERE Cityno = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, cityno);
        stmt.executeUpdate();
        return "delete city successfully";
    }

    public static String modifycityinfo(int cityno,String cityname) throws SQLException{
        String sql = "UPDATE cityinfo SET Cityname = ? WHERE Cityno = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, cityname);
        stmt.setInt(2,cityno);
        stmt.executeUpdate();
        return "modify city successfully";
    }

    public static String searchcityinfo(int cityno) throws SQLException{
        String sql = "SELECT * FROM cityinfo WHERE Cityno = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,cityno);
        ResultSet rs = stmt.executeQuery();
        if(!rs.next()){
            System.out.println("no city information");
        }else{
            int no = rs.getInt("Cityno");
            String cityname = rs.getString("Cityname");
        }
        return "delete city successfully";
    }
}