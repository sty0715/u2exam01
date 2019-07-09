package com.kgc.service.impl;

import com.kgc.dao.CityDao;
import com.kgc.dao.impl.CityDaoImpl;
import com.kgc.entity.City;
import com.kgc.service.CityService;

import java.util.List;

public class CityServiceImpl implements CityService {
    private CityDao cityDao=new CityDaoImpl();

    @Override
    public List<City> getCityList() {
        return cityDao.getCityList();
    }
}
