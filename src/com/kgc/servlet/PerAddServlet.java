package com.kgc.servlet;

import com.kgc.entity.City;
import com.kgc.service.CityService;
import com.kgc.service.impl.CityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PerAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        CityService cityService=new CityServiceImpl();
        List<City> cityList = cityService.getCityList();
        request.getSession().setAttribute("cityList",cityList);
        response.sendRedirect(request.getContextPath()+"/add.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           doPost(request, response);
    }
}
