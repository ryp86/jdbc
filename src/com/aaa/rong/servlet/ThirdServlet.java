package com.aaa.rong.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * @Author:ryp
 * @Description:
 * @Date: 2021/01/15/11:47
 */
@WebServlet("/third")
public class ThirdServlet implements Servlet {

    public ThirdServlet() {
        System.out.println("该servlet诞生了");
    }


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("该servlet诞生之后，执行一次初始化");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    //每发一次请求，就会执行一次
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("处理请求的方法被调用了..............");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("该servlet没有了");
    }
}
