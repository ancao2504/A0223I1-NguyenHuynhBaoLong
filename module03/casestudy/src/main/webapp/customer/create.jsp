
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/customer-servlet?action=create">
    <fieldset>
        <legend>Customer information</legend>
    <table >

        <tr>
            <td>id customer type:</td>
            <td><input type="text" name="idCustomerType"></td>
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
            <td>gender:</td>
            <td><input type="radio" name="gender" value="true">nam</td>
            <td><input type="radio" name="gender" value="false">nu</td>
        </tr>
        <tr>
            <td>id card:</td>
            <td><input type="text" name="idCard"></td>
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

            <td colspan="2">
                <input type="submit" name="create" value="create">
            </td>
        </tr>
    </table>
    </fieldset>
</form>
<a href="/customer-servlet">Back the list</a>
</body>
</html>
