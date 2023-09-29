<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<h2>
    <a href="/product-servlet?action=create">
        Create new product
    </a>
</h2>

<br>
<body>
    <table border="1px">
        <thead>
        <tr>
            <th>Number Orders</th>
            <th>Name</th>
            <th>date Manufacture</th>
            <th>date Expiry</th>
            <th>edit</th>
            <th>delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${product}" var="p" varStatus="loop">
            <tr>
                <td>${loop.count}</td>
                <td><a href="/product-servlet?action=view&id=${p.getId()}">${p.name}</a></td>
                <td>${p.dateManufacture}</td>
                <td>${p.dateExpiry}</td>
                <td><a href="/product-servlet?action=edit&id=${p.id}">edit</a></td>
                <td><a href="/product-servlet?action=delete&id=${p.id}">delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
