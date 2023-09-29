<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Student</title>
</head>
<body>

<form method="post" action="/student-servlet">
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>ID: </td>
                <td><input type="number" name="id" id="id"></td>
            </tr>
            <tr>
                <td>Gender: </td>
                <td><input type="radio" name="gender" value="true">male</td>
                <td><input type="radio" name="gender" value="false">Female</td>
            </tr>
            <tr>
                <td>Point: </td>
                <td><input type="number" name="point" id="point"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="create"></td>
                <input type="hidden" name="action" value="create">
            </tr>
        </table>
    </fieldset>
</form>

</body>
</html>
