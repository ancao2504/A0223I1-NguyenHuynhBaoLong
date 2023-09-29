<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
</head>
<body>
<form action="/product-servlet?action=delete" method="post">
    <table>
        <tr>
            <td>id:</td>
            <td ><input type="hidden" name="id" value="${product.getId()}">${product.getId()}</td>
        </tr>
        <tr>
            <td>Name: </td>
            <td>${product.getName()}</td>
        </tr>
        <tr>
            <td>Date Manufacture: </td>
            <td>${product.getPrice()}</td>
        </tr>
        <tr>
            <td>Date Expiry: </td>
            <td>${product.getDetail()}</td>
        </tr>
        <tr>
            <td>
                <p>Are you sure?</p>
                <input type="submit" name="delete" value="yes">
            </td>
        </tr>
        <tr>
            <td>
                <a href="/product-servlet">Back to list</a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
