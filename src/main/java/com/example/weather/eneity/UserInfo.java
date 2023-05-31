package com.example.weather.eneity;

public class UserInfo {
    private String Username;
    private String Userid;
    private String Userpassword;

    private String LocatedCity;
    private int FavoriteCityNum;
    private String FavoriteCity;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getUserid() {
        return Userid;
    }

    public void setUserid(String userid) {
        Userid = userid;
    }

    public String getUserpassword() {
        return Userpassword;
    }

    public void setUserpassword(String userpassword) {
        Userpassword = userpassword;
    }

    public String getLocatedCity() {
        return LocatedCity;
    }

    public void setLocatedCity(String locatedCity) {
        LocatedCity = locatedCity;
    }

    public int getFavoriteCityNum() {
        return FavoriteCityNum;
    }

    public void setFavoriteCityNum(int favoriteCityNum) {
        FavoriteCityNum = favoriteCityNum;
    }

    public String getFavoriteCity() {
        return FavoriteCity;
    }

    public void setFavoriteCity(String favoriteCity) {
        FavoriteCity = favoriteCity;
    }
}
