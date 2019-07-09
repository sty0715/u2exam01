package com.kgc.servlet;

import com.kgc.entity.Toursinfo;
import com.kgc.service.ToursinfoService;
import com.kgc.service.impl.ToursinfoServiceImpl;
import com.kgc.utils.DateUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String introduce = request.getParameter("introduce");
        Date pubtime = DateUtils.String2Date(request.getParameter("pubtime"), "yyyy-MM-dd");
        Double price = Double.parseDouble(request.getParameter("price"));
        Integer cityid = Integer.parseInt(request.getParameter("cityid"));
        Toursinfo toursinfo=new Toursinfo(null,introduce,pubtime,price,cityid,null);
        ToursinfoService toursinfoService=new ToursinfoServiceImpl();
        boolean flag = toursinfoService.addTour(toursinfo);
        String url=request.getContextPath()+"/index.jsp";
        if (flag){
            response.getWriter().print("<script>alert('添加成功');location.href='"+url+"'</script>");
        }else {
            response.getWriter().print("<script>alert('添加失败');history.go(-1)</script>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
