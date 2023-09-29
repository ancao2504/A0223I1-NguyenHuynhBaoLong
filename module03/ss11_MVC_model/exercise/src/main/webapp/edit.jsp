<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<form action="/customer-servlet?action=edit" method="post">
    <fieldset>
        <table>
            <legend>Customer information</legend>
            <tr>
                <td>Name:</td>
                <td> <input type="text" name="name" value="${customer.getName()}"></td>
            </tr>
            <tr>
                <td>ID:</td>
                <td> <input type="number" name="id" value="${customer.getId()}"></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td> <input type="text" name="email" value="${customer.getEmail()}"></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td> <input type="text" name="address" value="${customer.getAddress()}"></td>
            </tr>
            <tr>
                <input type="submit" name="edit">
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
