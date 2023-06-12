package com.example.weather.eneity;

public class UserInfoEntity {
    private String Nickname;
    private int UserID;
    private String Password;
    private String Location;
    private Boolean VIP;

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String nickname) {
        Nickname = nickname;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public Boolean getVIP() {
        return VIP;
    }

    public void setVIP(Boolean VIP) {
        this.VIP = VIP;
    }
}
