<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Dina Maskalik
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%--    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
    <title>Title</title>
</head>


<body>
<%
    if (request.getAttribute("expenses") != null) {
        for (String item : (String[]) request.getAttribute("expenses")) {
            out.println( "<h2>"+ item+"</h2>");
        }
    }
%>
</body>
</html>
