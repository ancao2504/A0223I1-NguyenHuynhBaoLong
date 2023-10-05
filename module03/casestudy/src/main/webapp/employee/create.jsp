<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/employee-servlet?action=create">
    <fieldset>
        <legend>Employee information</legend>
        <table>
            <%--                employee = new Employee(id, idCard, name, date, salary, phone, email, address, idPosition,
                                    idEducationDegree, idDivision, userName);--%>
            <tr>
                <td>id card:</td>
                <td><input type="text" name="idCard"></td>
            </tr>
            <tr>
                <td>name:</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>birthday:</td>
                <td><input type="text" name="birthDay"></td>
            </tr>
            <tr>
                <td>salary:</td>
                <td><input type="text" name="salary"></td>
            </tr>
            <tr>
                <td>phone:</td>
                <td><input type="text" name="phone"></td>
            </tr>
            <tr>
                <td>email:</td>
                <td><input type="text" name="email"></td>
            </tr>
            <tr>
                <td>address:</td>
                <td><input type="text" name="address"></td>
            </tr>
            <tr>
                <td>idPosition:</td>
                <td><input type="text" name="idPosition"></td>
            </tr>
            <tr>
                <td>idEducationDegree:</td>
                <td><input type="text" name="idEducationDegree"></td>
            </tr>
            <tr>
                <td>idDivision:</td>
                <td><input type="text" name="idDivision"></td>
            </tr>
            <tr>
                <td>userName:</td>
                <td><input type="text" name="userName"></td>
            </tr>
            <tr>

                <td colspan="2">
                    <input type="submit" name="create" value="create">
                </td>
            </tr>
        </table>
    </fieldset>
</form>
<a href="/employee-servlet">Back the list</a>
</body>
</html>
