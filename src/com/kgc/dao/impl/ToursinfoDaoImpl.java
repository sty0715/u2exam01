package com.kgc.dao.impl;

import com.kgc.dao.CityDao;
import com.kgc.dao.ToursinfoDao;
import com.kgc.entity.City;
import com.kgc.entity.Toursinfo;
import com.kgc.service.impl.CityServiceImpl;
import com.kgc.utils.C3p0Utils;
import com.kgc.utils.SearchParam;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.ArrayList;
import java.util.List;

public class ToursinfoDaoImpl implements ToursinfoDao {
    @Override
    public Integer getCount(SearchParam searchParam) {
        QueryRunner queryRunner=new QueryRunner(C3p0Utils.getDataSource());
        StringBuffer sb=new StringBuffer();
        if (searchParam!=null){
            sb.append("select count(*) as rows from toursinfo where 1=1");
            if (searchParam.getCityid()!=null&&!searchParam.getCityid().equals("-1")){
                sb.append(" and cityid="+searchParam.getCityid());
            }
            if (searchParam.getMin_price()!=null&&!searchParam.getMin_price().equals("")){
                sb.append(" and price>="+searchParam.getMin_price());
            }
            if (searchParam.getMax_price()!=null&&!searchParam.getMax_price().equals("")){
                sb.append(" and price<="+searchParam.getMax_price());
            }
        }
        String sql=sb.toString();
        try {
            Long rows=(Long)queryRunner.query(sql,new ScalarHandler("rows"));
            return rows.intValue();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Toursinfo> getListByPage(Integer pageNo, Integer pageSize, SearchParam searchParam) {
        List<Toursinfo> list=new ArrayList<>();
        QueryRunner queryRunner=new QueryRunner(C3p0Utils.getDataSource());
        StringBuffer sb=new StringBuffer();
        if (searchParam!=null){
            sb.append("select * from toursinfo where 1=1");
            if (searchParam.getCityid()!=null&&!searchParam.getCityid().equals("-1")){
                sb.append(" and cityid="+searchParam.getCityid());
            }
            if (searchParam.getMin_price()!=null&&!searchParam.getMin_price().equals("")){
                sb.append(" and price>="+searchParam.getMin_price());
            }
            if (searchParam.getMax_price()!=null&&!searchParam.getMax_price().equals("")){
                sb.append(" and price<="+searchParam.getMax_price());
            }
        }
        sb.append(" limit ?,?");
        String sql=sb.toString();
        try {
            list=queryRunner.query(sql,new BeanListHandler<Toursinfo>(Toursinfo.class),(pageNo-1)*pageSize,pageSize);
            for (int i = 0; i <list.size() ; i++) {
                Toursinfo toursinfo = list.get(i);
                Integer cityid=toursinfo.getCityid();
                CityDao cityDao=new CityDaoImpl();
                City city= cityDao.getCityByID(cityid);
                toursinfo.setCity(city);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public int addTour(Toursinfo toursinfo) {
        QueryRunner queryRunner=new QueryRunner(C3p0Utils.getDataSource());
        String sql="insert into toursinfo(introduce,price,pubtime,cityid) values(?,?,?,?)";
        try {
            return queryRunner.update(sql,toursinfo.getIntroduce(),
                    toursinfo.getPrice(),
                    toursinfo.getPubtime(),
                    toursinfo.getCityid());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Toursinfo getTourById(int id) {
        Toursinfo toursinfo;
        QueryRunner queryRunner=new QueryRunner(C3p0Utils.getDataSource());
        String sql="select * from toursinfo where id=?";
        try {
            toursinfo=queryRunner.query(sql,new BeanHandler<Toursinfo>(Toursinfo.class),id);
            CityDao cityDao=new CityDaoImpl();
            City city = cityDao.getCityByID(toursinfo.getCityid());
            toursinfo.setCity(city);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return toursinfo;
    }

    @Override
    public int updateTour(Toursinfo toursinfo) {
        QueryRunner queryRunner=new QueryRunner(C3p0Utils.getDataSource());
        String sql="update toursinfo set introduce=?,price=?,pubtime=?,cityid=? where id=?";
        try {
            return queryRunner.update(sql,toursinfo.getIntroduce(),
                    toursinfo.getPrice(),
                    toursinfo.getPubtime(),
                    toursinfo.getCityid(),
                    toursinfo.getId());

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteTour(int id) {
        QueryRunner queryRunner=new QueryRunner(C3p0Utils.getDataSource());
        String sql="delete from toursinfo where id=?";
        try {
            return queryRunner.update(sql,id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
