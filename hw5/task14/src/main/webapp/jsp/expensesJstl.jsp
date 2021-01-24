<%--
  Created by IntelliJ IDEA.
  User: Dina Maskalik
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>

        table {
            width: 100%;
        }

        #t01 tr:nth-child(even) {
            background-color: #eee;
        }

        #t01 tr:nth-child(odd) {
            background-color: #fff;
        }

        #t01 th {
            background-color: black;
            color: white;
        }
    </style>
    <title>task17</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>

<table id="t01" border="1">
    <tr>
        <th>Number</th>
        <th>Pay date</th>
        <th>Pay value</th>
        <th>Receiver name</th>

    </tr>
    <c:forEach items="${expenses}" var="expense">
        <tr>
            <td>${expense.num}</td>
            <td>${expense.payDate}</td>
            <td>${expense.payValue}</td>
            <td>${expense.receiverName}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
