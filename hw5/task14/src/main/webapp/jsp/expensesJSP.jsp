<%@ page import="java.io.PrintWriter" %>
<%@ page import="it.academy.data.Expenses" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Dina Maskalik
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>task15</title>
</head>

<body>
<%
    List<Expenses> expenses = (List<Expenses>) request.getAttribute("expenses");
    if (expenses != null) {
        for (Expenses item : expenses) {
            out.println("<h2>" + "num= " + item.getNum() + " date= " + item.getPayDate() + " value= " + item.getPayValue() + " receiver= " + item.getReceiverName() + "</h2>");
        }
    }
%>
</body>
</html>
