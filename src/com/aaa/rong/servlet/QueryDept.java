package com.aaa.rong.servlet;

import com.aaa.rong.project.dao.DeptDAOImpl;
import com.aaa.rong.project.dao.IDeptDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:ryp
 * @Description:
 * @Date: 2021/01/16/10:38
 */
@WebServlet("/query")
public class QueryDept extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String loc = req.getParameter("loc");

        IDeptDAO deptDAO = new DeptDAOImpl();
        List<Map> list = deptDAO.queryByLoc(loc);

        req.setAttribute("list",list);
        //转发
        req.getRequestDispatcher("query.jsp").forward(req,resp);
        //重定向
        resp.sendRedirect("query.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
