<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Delete</title>
</head>
<body>
<form action="/customer-servlet?action=delete" method="post">
    <fieldset>
        <table>
            <legend>Customer information</legend>
            <tr>
                <td>Name:</td>
                <td> ${customer.getName()}</td>
            </tr>
            <tr>
                <td>ID:</td>
                <td><input type="hidden" name="id" value="${customer.getId()}"> ${customer.getId()}</td>
            </tr>
            <tr>
                <td>Email:</td>
                <td> ${customer.getEmail()}</td>
            </tr>
            <tr>
                <td>Address:</td>
                <td>${customer.getAddress()}</td>
            </tr>
        </table>
        <p>Are you sure?</p>
        <input type="submit" name="delete" value="yes">
        <br>
        <a href="/customer-servlet">Back to list</a>
    </fieldset>
</form>
</body>
</html>
