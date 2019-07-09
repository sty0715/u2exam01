package com.kgc.dao.impl;

import com.kgc.dao.CityDao;
import com.kgc.entity.City;
import com.kgc.utils.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class CityDaoImpl implements CityDao {
    @Override
    public City getCityByID(Integer cityid) {
        QueryRunner queryRunner=new QueryRunner(C3p0Utils.getDataSource());
        String sql="select * from city where cityid=?";
        try {
            return queryRunner.query(sql,new BeanHandler<City>(City.class),cityid);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<City> getCityList() {
        QueryRunner queryRunner=new QueryRunner(C3p0Utils.getDataSource());
        String sql="select * from city";
        try {
            return queryRunner.query(sql,new BeanListHandler<City>(City.class));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
