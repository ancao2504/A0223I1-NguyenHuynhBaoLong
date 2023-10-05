<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<form action="/user-servlet?action=edit" method="post">
    <table border="1px">
        <tr>
            <td>ID:</td>
            <td>${user.getId()}
                <input type="hidden" name="id" value="${user.getId()}">
            </td>
        </tr>
        <tr>
            <td>Name:</td>
            <td>
                <input type="text" name="name" value="${user.getName()}">
            </td>
        </tr>
        <tr>
            <td>Email:</td>
            <td>
                <input type="text" name="email" value="${user.getEmail()}">
            </td>
        </tr>
        <tr>
            <td>Country:</td>
            <td>
                <input type="text" name="country" value="${user.getCountry()}">
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" name="edit" value="save"></td>
        </tr>
    </table>
</form>
<a href="/user-servlet">Back the list</a>
</body>
</html>
