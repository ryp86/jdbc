<%@ page import="com.aaa.rong.project.dao.IDeptDAO" %>
<%@ page import="com.aaa.rong.project.dao.DeptDAOImpl" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>查询结果</title>
    </head>
    <body>
        <table>
            <tr>
                <th>部门编号</th>
                <th>部门名称</th>
                <th>部门地址</th>
            </tr>
            <%--List<Map> list = (List<Map>) request.getAttribute("list");--%>
            <%
                List<Map> list = (List<Map>) session.getAttribute("list");
                for(Map map : list){ %>
            <tr>
                <td><%=map.get("deptno") %></td>
                <td><%=map.get("dname") %></td>
                <td><%=map.get("loc") %></td>
            </tr>
            <% } %>
        </table>
    </body>
</html>
