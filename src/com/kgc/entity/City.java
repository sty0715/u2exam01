package com.kgc.entity;

public class City {
    private Integer cityid;
    private String cityname;

    public City(Integer cityid, String cityname) {
        this.cityid = cityid;
        this.cityname = cityname;
    }

    public City() {
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }
}
