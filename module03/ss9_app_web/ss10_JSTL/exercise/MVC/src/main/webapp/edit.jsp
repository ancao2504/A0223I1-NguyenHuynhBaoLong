<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
    <c:if test="${message != null}" >
        <span>${message}</span>
    </c:if>
</p>
<form method="post" action="/student-servlet">
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name" value="${student.name}"></td>
            </tr>
            <tr>
                <td>ID: </td>
                <td><input type="number" name="id" id="id" value="${student.id}"></td>
            </tr>
            <tr>
                <td>Gender: </td>
                <td><input type="radio" name="gender" value="true" value="${student.gender}">male</td>
                <td><input type="radio" name="gender" value="false"value="${student.gender}">Female</td>
            </tr>
            <tr>
                <td>Point: </td>
                <td><input type="number" name="point" id="point" value="${student.point}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="edit"></td>
                <input type="hidden" name="action" value="edit">
            </tr>
        </table>
    </fieldset>
</form>
<a href="/student-servlet" name="action">Back to list</a>
</body>
</html>
