<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Phone number</th>
        <th scope="col">Balance</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${phoneNumberList}" var="phoneNumberItem">
        <tr>
            <td>${phoneNumberItem.phoneId}</td>
            <td>${phoneNumberItem.phoneNumber}</td>
            <td>${phoneNumberItem.balance}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
