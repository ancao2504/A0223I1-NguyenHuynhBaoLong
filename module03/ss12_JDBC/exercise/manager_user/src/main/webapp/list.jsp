<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<h3>
    <a href="/user-servlet?action=create">Create new user</a>
</h3>
<form method="post" action="/user-servlet?action=search" >
    <input type="text" name="name" placeholder="Name">
    <input type="submit" name="search" value="search">
</form>

<table border="1px">
    <tr>
        <th>Order</th>
        <th>Name</th>
        <th>Email</th>
        <th>Country</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${users}" var="u" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${u.name}</td>
            <td>${u.email}</td>
            <td>${u.country}</td>
            <td>
                <a href="/user-servlet?action=edit&id=${u.id}">edit</a>
                <a href="/user-servlet?action=delete&id=${u.id}">delete</a>
            </td>
        </tr>

    </c:forEach>
</table>
</body>
</html>
