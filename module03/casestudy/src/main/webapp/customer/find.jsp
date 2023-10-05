<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<h1>ababasbas</h1>
<body>
    <table border="1px">
        <thead>
        <tr>
            <th>Order</th>
            <th>Name</th>
            <th>BirthDay</th>
            <th>gender</th>
            <th>id Card</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Address</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customer}" var="c" varStatus="loop">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td>${c.birthDay}</td>
                <c:if test="${c.gender == false}">
                    <td>Nữ</td>
                </c:if>
                <c:if test="${c.gender == true}">
                    <td>Nam</td>
                </c:if>
                <td>${c.idCard}</td>
                <td>${c.phone}</td>
                <td>${c.email}</td>
                <td>${c.address}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
<a href="/customer-servlet">Back the list</a>
</body>
</html>
