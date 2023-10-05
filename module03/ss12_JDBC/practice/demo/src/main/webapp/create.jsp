
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>

<form method="post" action="/student-servlet?action=create" >
    <table >
        <tr border="1px">
            <td>Name:</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr border="1px">
            <td>Gender:</td>
            <td><input type="radio" name="gender" value="true"> Nam</td>
            <td><input type="radio" name="gender" value="false"> Nữ</td>
        </tr>
        <tr>
            <td>Point:</td>
            <td><input type="text" name="point"></td>
        </tr>
        <tr><td><input type="submit" name="create" value="create"></td></tr>
    </table>
</form>
</body>
</html>
