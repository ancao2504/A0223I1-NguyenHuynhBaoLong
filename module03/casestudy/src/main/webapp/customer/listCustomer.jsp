<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer list</title>
<%--    <link rel="stylesheet" href="table.css">--%>
</head>
<body>
<h2>
    <a href="/customer-servlet?action=create">Create new Customer</a>
</h2>

<form action="/customer-servlet?action=search" method="post">
    <table>
        <tr>
            <td><input type="text" name="name" ></td>
            <td><input type="submit" name="search" value="search"></td>
        </tr>
    </table>
</form>
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
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${customers}" var="c" varStatus="loop">
                <tr>
                    <td>${loop.count}</td>
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
                    <td>
                        <a href="/customer-servlet?action=edit&id=${c.id}">edit</a>
                        <a href="/customer-servlet?action=delete&id=${c.id}">delete</a>
                    </td>
                </tr>
        </c:forEach>
    </tbody>
</table>
<a href="index.jsp">Back to main screen</a>
</body>
</html>
