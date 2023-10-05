
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form name="delete" action="/student-servlet?action=delete" method="post">
    <table border="1px">
        <tr>
            <td>id:</td>
            <td>${student.id}
                <input type="hidden" name="id" value="${student.id}">
            </td>
        </tr>
        <tr>
            <td>Name:</td>
            <td>${student.name}
                <input type="hidden" name="name" value="${student.name}">
            </td>
        </tr>
        <tr>
            <td>Gender:</td>
            <td>${student.gender}
                <input type="hidden" name="gender" value="${student.gender}">
            </td>
        </tr>
        <tr>
            <td>point:</td>
            <td>${student.point}
                <input type="hidden" name="point" value="${student.point}">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" name="delete" value="yes">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
