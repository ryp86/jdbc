package com.aaa.rong.servlet;

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
 * @Date: 2021/01/15/18:58
 */
@WebServlet("/helloform")
public class HelloForm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置响应内容类型
        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();
        String title = "使用 GET 方法读取表单数据";
        //处理中文
        String name = request.getParameter("name");
        System.out.println(name);

        String docType = "<!DOCTYPE html>\n";
        out.println(docType+
                "<html>\n"+
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>站点名</b>："
                + name + "\n" +
                "  <li><b>网址</b>："
                + request.getParameter("url") + "\n" +
                "</ul>\n" +
                "</body></html>");

    }

    // 处理 POST 方法请求的方法
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
