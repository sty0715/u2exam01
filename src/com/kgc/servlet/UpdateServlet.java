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

public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String introduce = request.getParameter("introduce");
        double price = Double.parseDouble(request.getParameter("price"));
        Date pubtime = DateUtils.String2Date(request.getParameter("pubtime"), "yyyy-MM-dd");
        int cityid = Integer.parseInt(request.getParameter("cityid"));
        int id = Integer.parseInt(request.getParameter("id"));
        Toursinfo toursinfo=new Toursinfo(id,introduce,pubtime,price,cityid,null);
        ToursinfoService toursinfoService=new ToursinfoServiceImpl();
        boolean flag = toursinfoService.updateTour(toursinfo);
        String url=request.getContextPath()+"/index.jsp";
        if (flag){
            response.getWriter().print("<script>alert('修改成功');location.href='"+url+"'</script>");
        }else {
            response.getWriter().print("<script>alert('修改失败');history.go(-1)</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
