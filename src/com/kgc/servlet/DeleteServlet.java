package com.kgc.servlet;

import com.kgc.service.ToursinfoService;
import com.kgc.service.impl.ToursinfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        ToursinfoService toursinfoService=new ToursinfoServiceImpl();
        boolean flag = toursinfoService.deleteTour(id);
        String url=request.getContextPath()+"/index.jsp";
        if (flag){
            response.getWriter().print("<script>alert('删除成功');location.href='"+url+"'</script>");
        }else {
            response.getWriter().print("<script>alert('删除失败');history.go(-1)</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
