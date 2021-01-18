<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<html>
    <head>
        <title>欢迎光临</title>
    </head>
    <body>
        <% for (int i = 0; i < 5; i++) {%>
        <% out.print(i + 1); %>&<%=i + 1%>
        <%}%>
    </body>
</html>
