package com.kgc.entity;

import java.util.Date;

public class Toursinfo {
    private Integer id;
    private String introduce;
    private Date pubtime;
    private Double price;
    private Integer cityid;
    private City city;

    public Toursinfo(Integer id, String introduce, Date pubtime, Double price, Integer cityid, City city) {
        this.id = id;
        this.introduce = introduce;
        this.pubtime = pubtime;
        this.price = price;
        this.cityid = cityid;
        this.city = city;
    }

    public Toursinfo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Date getPubtime() {
        return pubtime;
    }

    public void setPubtime(Date pubtime) {
        this.pubtime = pubtime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
