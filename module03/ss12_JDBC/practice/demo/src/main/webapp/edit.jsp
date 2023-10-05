
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<form name="edit" action="/student-servlet?action=edit" method="post">
    <table border="1px">
        <tr>
            <td>id:</td>
            <td>${student.id}
                <input type="hidden" name="id" value="${student.id}">
            </td>
        </tr>
        <tr>
            <td>Name:</td>
            <td>
                <input type="text" name="name" value="${student.name}">
            </td>
        </tr>
        <tr>
            <td>Gender:</td>
            <td>
                <input type="text" name="gender" value="${student.gender}">
            </td>
        </tr>
        <tr>
            <td>point:</td>
            <td>
                <input type="text" name="point" value="${student.point}">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" name="edit" value="Save">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
