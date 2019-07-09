package com.kgc.dao;

import com.kgc.entity.Toursinfo;
import com.kgc.utils.SearchParam;

import java.util.List;

public interface ToursinfoDao {
    Integer getCount(SearchParam searchParam);

    List<Toursinfo> getListByPage(Integer pageNo, Integer pageSize, SearchParam searchParam);

    int addTour(Toursinfo toursinfo);

    Toursinfo getTourById(int id);

    int updateTour(Toursinfo toursinfo);

    int deleteTour(int id);
}
