<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create Customer</title>
</head>
<body>
<form action="/customer-servlet?action=create" method="post">

    <fieldset>
        <table>
            <legend>Customer information</legend>
            <tr>
                <td>
                    name:
                </td>
                <td>
                    <input type="text" name="name">
                </td>
            </tr>
            <tr>
                <td>
                    id:
                </td>
                <td>
                    <input type="number" name="id">
                </td>
            </tr>
            <tr>
                <td>
                    email:
                </td>
                <td>
                    <input type="text" name="email">
                </td>
            </tr>
            <tr>
                <td>
                    address:
                </td>
                <td>
                    <input type="text" name="address">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" name="create">
                </td>
            </tr>
    </table>
        <a href="/customer-servlet">Back to list</a>
    </fieldset>
</form>
</body>
</html>
