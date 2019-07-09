package com.kgc.service.impl;

import com.kgc.dao.ToursinfoDao;
import com.kgc.dao.impl.ToursinfoDaoImpl;
import com.kgc.entity.Toursinfo;
import com.kgc.service.ToursinfoService;
import com.kgc.utils.PageUtil;
import com.kgc.utils.SearchParam;

import java.util.List;

public class ToursinfoServiceImpl implements ToursinfoService {
    private ToursinfoDao toursinfoDao=new ToursinfoDaoImpl();
    @Override
    public PageUtil getToursinfoListBypage(Integer pageNo, Integer pageSize, SearchParam searchParam) {
        Integer count = toursinfoDao.getCount(searchParam);
        PageUtil pageUtil=new PageUtil(pageNo,count,pageSize);
        List<Toursinfo> list=toursinfoDao.getListByPage(pageUtil.getPageNo(),pageSize,searchParam);
        pageUtil.setList(list);
        return pageUtil;
    }

    @Override
    public boolean addTour(Toursinfo toursinfo) {
        return toursinfoDao.addTour(toursinfo)>0?true:false;
    }

    @Override
    public Toursinfo getTourById(int id) {
        return toursinfoDao.getTourById(id);
    }

    @Override
    public boolean updateTour(Toursinfo toursinfo) {
        return toursinfoDao.updateTour(toursinfo)>0?true:false;
    }

    @Override
    public boolean deleteTour(int id) {
        return toursinfoDao.deleteTour(id)>0?true:false;
    }
}
