<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/customer-servlet?action=create"> Create New Customer</a>
<table border="1">
    <tr>
        <td>Name</td>
        <td>Email</td>
        <td>Address</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items="${list}" var="c" varStatus="loop">
        <tr>
            <td><a href="/customer-servlet?action=view&id=${c.id}">${c.name}</a></td>
            <td><a >${c.email}</a></td>
            <td><a>${c.address}</a></td>
            <td><a href="/customer-servlet?action=edit&id=${c.id}">edit</a></td>
            <td><a href="/customer-servlet?action=delete&id=${c.id}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
