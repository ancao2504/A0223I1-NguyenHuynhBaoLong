<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
</head>
<body>
<table border="1px">
    <tr>
        <td>ID:</td>
        <td>${user.getId()}
            <input type="hidden" name="id" value="${user.getId()}">
        </td>
    </tr>
    <tr>
        <td>Name:</td>
        <td>${user.getName()}
            <input type="hidden" name="name" value="${user.getName()}">
        </td>
    </tr>
    <tr>
        <td>Email:</td>
        <td>${user.getEmail()}
            <input type="hidden" name="email" value="${user.getEmail()}">
        </td>
    </tr>
    <tr>
        <td>Country:</td>
        <td>${user.getCountry()}
            <input type="hidden" name="country" value="${user.getCountry()}">
        </td>
    </tr>
</table>
<a href="/user-servlet">Back the list</a>
</body>
</html>
