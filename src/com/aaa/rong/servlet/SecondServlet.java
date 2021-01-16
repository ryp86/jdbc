package com.aaa.rong.servlet;

import com.aaa.rong.project.dao.DeptDAOImpl;
import com.aaa.rong.project.dao.IDeptDAO;
import com.aaa.rong.project.pojo.Dept;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author:ryp
 * @Description:
 * @Date: 2021/01/15/11:18
 */
@WebServlet("/second")
public class SecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符集
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //接收请求
        String deptno = req.getParameter("deptno");
        String dname = req.getParameter("dname");
        String loc = req.getParameter("loc");
        //添加数据
        IDeptDAO deptDAO = new DeptDAOImpl();
        Dept dept = new Dept(Integer.parseInt(deptno), dname, loc);
        int add = deptDAO.add(dept);
        //做出响应
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("成功");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
