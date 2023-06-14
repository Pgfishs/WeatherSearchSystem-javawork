package com.example.weather.db;
import java.sql.*;
public class userandcity {
    //TODO 用户对其账户对应的城市及信息的的增删查
    static Connection conn;
    public String userAddcity(int userid,int cityID) throws SQLException {
        String sql = "INSERT INTO user_city(UserID,CityID) VALUES(?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, userid);
        ps.setInt(2, cityID);
        ps.executeUpdate();
        return"add successfully";
    }
    public String userDeletecity(int userid,int cityID) throws SQLException {
        String sql = "DELETE FROM user_city WHERE UserID = ? AND CityID = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, userid);
        ps.setInt(2,cityID);
        ps.executeUpdate();
        return "delete successfully";
    }

    public String userSearchcity(int userid) throws SQLException {
        String sql = "SELECT CityID FROM user_city WHERE UserID=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, userid);
        ResultSet rs1 = ps.executeQuery();
        while (rs1.next()){
            int cid = rs1.getInt("CityID");
            String _sql = "SELECT Cityname FROM cityinfo WHERE Cityno = ?";
            ps.setInt(1,cid);
            ResultSet rs2 = ps.executeQuery();
            rs2.next();
            String cname = rs2.getString("Cityname");
        }
        return "search successfully";
    }
}
