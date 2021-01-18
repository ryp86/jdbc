package com.aaa.rong.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author:ryp
 * @Description:
 * @Date: 2021/01/16/14:49
 */
@WebServlet("/string")
public class ToStringServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(req.getAuthType()); //获取身份验证类型 null
        System.out.println(req.getContextPath()); //获取上下文路径 /jdbc
        System.out.println(req.getCookies()); //获取cookies [Ljavax.servlet.http.Cookie;@12a01202
        System.out.println(req.getHeaderNames()); // org.apache.tomcat.util.http.NamesEnumerator@70a605ab
        System.out.println(req.getMethod()); //获取提交方法 GET
        System.out.println(req.getPathInfo()); //获取路径信息 null
        System.out.println(req.getPathTranslated()); // null
        System.out.println(req.getQueryString()); //获取查询字符串 null
        System.out.println(req.getRemoteUser()); //获取远程用户 null
        System.out.println(req.getRequestedSessionId()); //获取请求的会话ID 37FF45A1032D11AD581A43C9B8C6CDF5
        System.out.println(req.getRequestURI()); //获取请求URI /jdbc/string
        System.out.println(req.getServletPath()); //获取Servlet路径 /string
        System.out.println(req.getSession()); //获取Session org.apache.catalina.session.StandardSessionFacade@620429bf
        System.out.println(req.getUserPrincipal()); //获取用户主体 null
        System.out.println(req.getAttributeNames()); //获取属性名称 java.util.Collections$3@8d56a85
        System.out.println(req.getCharacterEncoding()); //获取字符编码 null
        System.out.println(req.getContentType()); //获取内容类型 null
        System.out.println(req.getLocalAddr()); //获取本地地址 0:0:0:0:0:0:0:1
        System.out.println(req.getLocale()); //获取语​​言环境 zh_CN
        System.out.println(req.getLocalName()); //获取本地名称 0:0:0:0:0:0:0:1
        System.out.println(req.getLocalPort()); //获取本地端口 9090

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
