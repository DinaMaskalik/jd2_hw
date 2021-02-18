<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Name</th>
        <th scope="col">Surname</th>
        <th scope="col">Age</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${personList}" var="personItem">
        <tr>
            <td>${personItem.personId}</td>
            <td>${personItem.name}</td>
            <td>${personItem.surname}</td>
            <td>${personItem.age}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
