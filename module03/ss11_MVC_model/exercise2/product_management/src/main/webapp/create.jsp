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
            <td>Price: </td>
            <td><input type="text" name="price"></td>
        </tr>
        <tr>
            <td>Detail: </td>
            <td><input type="text" name="detail"></td>
        </tr>
        <tr>
            <input type="submit" name="create">
        </tr>
    </table>
</form>
</body>
</html>
