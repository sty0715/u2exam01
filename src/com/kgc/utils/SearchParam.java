package com.kgc.utils;

public class SearchParam {
    private String cityid;
    private String min_price;
    private String max_price;

    public SearchParam(String cityid, String min_price, String max_price) {
        this.cityid = cityid;
        this.min_price = min_price;
        this.max_price = max_price;
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public String getMin_price() {
        return min_price;
    }

    public void setMin_price(String min_price) {
        this.min_price = min_price;
    }

    public String getMax_price() {
        return max_price;
    }

    public void setMax_price(String max_price) {
        this.max_price = max_price;
    }

    public SearchParam() {

    }
}
