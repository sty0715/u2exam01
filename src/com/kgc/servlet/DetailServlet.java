package com.kgc.servlet;

import com.kgc.entity.City;
import com.kgc.entity.Toursinfo;
import com.kgc.service.CityService;
import com.kgc.service.ToursinfoService;
import com.kgc.service.impl.CityServiceImpl;
import com.kgc.service.impl.ToursinfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        ToursinfoService toursinfoService=new ToursinfoServiceImpl();
        Integer id = Integer.parseInt(request.getParameter("id"));
        Toursinfo toursinfo=toursinfoService.getTourById(id);
        CityService cityService=new CityServiceImpl();
        request.getSession().setAttribute("toursinfo",toursinfo);
        response.sendRedirect(request.getContextPath()+"/detail.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          doPost(request, response);
    }
}
