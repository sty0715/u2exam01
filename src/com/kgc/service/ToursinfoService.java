package com.kgc.service;

import com.kgc.entity.Toursinfo;
import com.kgc.utils.PageUtil;
import com.kgc.utils.SearchParam;

public interface ToursinfoService {
    PageUtil getToursinfoListBypage(Integer pageNo, Integer pageSize, SearchParam searchParam);

    boolean addTour(Toursinfo toursinfo);

    Toursinfo getTourById(int id);

    boolean updateTour(Toursinfo toursinfo);

    boolean deleteTour(int id);
}
