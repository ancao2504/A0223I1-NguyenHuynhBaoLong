<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Product</title>
</head>
<body>
<form action="/product-servlet?action=create" method="post">
    <table>
        <tr>
            <td>id:</td>
            <td><input type="number" name="id"></td>
        </tr>
        <tr>
            <td>Name: </td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Date Manufacture: </td>
            <td><input type="text" name="dateManufacture"></td>
        </tr>
        <tr>
            <td>Date Expiry: </td>
            <td><input type="text" name="dateExpiry"></td>
        </tr>
        <tr>
            <input type="submit" name="create">
        </tr>
    </table>
</form>
</body>
</html>
