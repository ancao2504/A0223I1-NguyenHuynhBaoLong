<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>View</title>
</head>
<body>
<form action="/product-servlet?action=view" method="post">
    <table border="1px">
        <tr>
            <td>id:</td>
            <td>${product.getId()}</td>
        </tr>
        <tr>
            <td>Name: </td>
            <td>${product.getName()}</td>
        </tr>
        <tr>
            <td>Date Manufacture: </td>
            <td>${product.getDateManufacture()}</td>
        </tr>
        <tr>
            <td>Date Expiry: </td>
            <td>${product.getDateExpiry()}</td>
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
