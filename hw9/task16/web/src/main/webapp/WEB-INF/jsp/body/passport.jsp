<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Series</th>
        <th scope="col">Number</th>
        <th scope="col">Age</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${passportList}" var="passportItem">
        <tr>
            <td>${passportItem.passportId}</td>
            <td>${passportItem.passportSeries}</td>
            <td>${passportItem.passportNumber}</td>
            <td>${passportItem.visaType}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>