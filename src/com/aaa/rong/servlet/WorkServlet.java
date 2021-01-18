package com.aaa.rong.servlet;

import com.aaa.rong.project.dao.DeptDAOImpl;
import com.aaa.rong.project.dao.IDeptDAO;
import com.aaa.rong.project.pojo.Dept;
import com.aaa.rong.project.util.BaseDBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * @Author:ryp
 * @Description:
 * @Date: 2021/01/16/15:09
 */
@WebServlet("/work")
public class WorkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String deptno = req.getParameter("deptno");
        String dname = req.getParameter("dname");
        String loc = req.getParameter("loc");

        int dno = deptno.isEmpty() ? -1 : Integer.parseInt(deptno);
        dname = dname.isEmpty() ? null : dname;
        loc = loc.isEmpty() ? null : loc;
        System.out.println(deptno);
        System.out.println(dname);
        System.out.println(loc);

        Dept dept = new Dept(dno, dname, loc);
        IDeptDAO deptDAO = new DeptDAOImpl();
        List<Map> list = deptDAO.queryByDept(dept);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        StringBuilder sb = new StringBuilder();
        sb.append("<html><head><meta charset='UTF-8'><title>查询结果</title></head>");
        sb.append("<body><table border=1>");
        sb.append("<tr><td>部门编号</td><td>部门名称</td><td>部门地址</td></tr>");

        for (Map map : list) {
            sb.append("<tr><td>" + map.get("deptno") + "</td><td>" + map.get("dname") + "</td><td>" + map.get("loc") + "</td></tr>");
        }
        sb.append("</table></body></html>");

        out.print(sb);
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
