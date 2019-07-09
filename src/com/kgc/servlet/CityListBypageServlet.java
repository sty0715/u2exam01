package com.kgc.servlet;

import com.kgc.entity.City;
import com.kgc.entity.Toursinfo;
import com.kgc.service.CityService;
import com.kgc.service.ToursinfoService;
import com.kgc.service.impl.CityServiceImpl;
import com.kgc.service.impl.ToursinfoServiceImpl;
import com.kgc.utils.PageUtil;
import com.kgc.utils.SearchParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CityListBypageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");
        String s_pageNo = request.getParameter("pageNo");
        String cityid = request.getParameter("cityid");
        String min_price = request.getParameter("min_price");
        String max_price = request.getParameter("max_price");
        SearchParam searchParam=new SearchParam(cityid,min_price,max_price);
        if (s_pageNo==null){
            s_pageNo="1";
        }
        Integer pageNo=Integer.parseInt(s_pageNo);
        Integer pageSize=3;
        ToursinfoService toursinfoService=new ToursinfoServiceImpl();
        CityService cityService=new CityServiceImpl();
        PageUtil page=toursinfoService.getToursinfoListBypage(pageNo,pageSize,searchParam);
        List<City> cityList=cityService.getCityList();
        request.getSession().setAttribute("cityList",cityList);
        request.getSession().setAttribute("page",page);
        request.getSession().setAttribute("searchParam",searchParam);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           doPost(request, response);
    }
}
