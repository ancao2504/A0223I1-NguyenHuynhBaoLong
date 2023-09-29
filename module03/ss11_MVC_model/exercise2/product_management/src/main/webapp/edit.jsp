<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<form action="/product-servlet?action=edit" method="post">
    <table>
        <tr>
            <td>id:</td>
            <td><input type="number" name="id" value="${product.getId()}"></td>
        </tr>
        <tr>
            <td>Name: </td>
            <td><input type="text" name="name" value="${product.getName()}"></td>
        </tr>
        <tr>
            <td>Price: </td>
            <td><input type="text" name="price" value="${product.getPrice()}"></td>
        </tr>
        <tr>
            <td>Detail: </td>
            <td><input type="text" name="detail" value="${product.getDetail()}"></td>
        </tr>
        <tr>
            <td>
            <p>Are you sure?</p>
            <input type="submit" name="edit" value="yes">
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
