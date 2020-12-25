<%@ page import="com.doctorsweb.entities.Doctors" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.doctorsweb.database.DatabaseHandler" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        #developers {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #developers td, #developers th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #developers tr:nth-child(even){background-color: #f2f2f2;}

        #developers tr:hover {background-color: #ddd;}

        #developers th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #52B792;
            color: white;
        }
        #unique
        {
            background-color: #52B792;
            color: white;
        }
    </style>
</head>
    <body>
    <a href="/logout">Logout from the site</a>
    <title>Docror's list</title>
    <table border=1 width=100% cellpadding=5 id="developers">
        <thead>
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Age</th>
            <th>Position</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <%
                DatabaseHandler databaseHandler = new DatabaseHandler();
                ResultSet resultSet = databaseHandler.getDoctors();
                ArrayList<String[]> masResult = new ArrayList<>();
                int count = resultSet.getMetaData().getColumnCount();

                while (resultSet.next()) {
                    String[] arrayString = new String[count];
                    for (int i = 1; i <= count; i++)
                        arrayString[i - 1] = resultSet.getString(i);

                    masResult.add(arrayString);
                }
                int count1=0;

                for (String[] item : masResult) {
                    out.print("<tr><td>"+item[1]+"</td>"+
                            "<td>"+item[2]+"</td>" +
                            "<td>"+item[3]+"</td>"+
                            "<td>"+item[4]+"</td></tr>");
                    count1++;
                }

                out.print("<tr><td id='unique'>Statistics</td></tr><tr><td> Amount of doctors</td><td>"+ count1+ "</td></tr>");
                //out.print("<tr><td> Average employees age</td><td>"+ ageCount/count + "</td></tr>");
            %>
        </tr>
        </tbody>
    </table>
</body>
</html>
