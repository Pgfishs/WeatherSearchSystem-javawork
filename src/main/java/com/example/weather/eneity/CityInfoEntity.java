package com.example.weather.eneity;

public class CityInfoEntity {
    private String Cityname;
    private int CityID;
    private String CityLocation;

    public String getCityname() {
        return Cityname;
    }

    public void setCityname(String cityname) {
        Cityname = cityname;
    }

    public int getCityID() {
        return CityID;
    }

    public void setCityID(int cityID) {
        CityID = cityID;
    }

    public String getCityLocation() {
        return CityLocation;
    }

    public void setCityLocation(String cityLocation) {
        CityLocation = cityLocation;
    }
}