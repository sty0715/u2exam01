package com.kgc.dao;

import com.kgc.entity.City;

import java.util.List;

public interface CityDao {
    City getCityByID(Integer cityid);

    List<City> getCityList();
}
