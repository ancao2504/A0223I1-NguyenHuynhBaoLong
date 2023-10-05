<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/customer-servlet?action=edit">
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>id :</td>
                ${customer.getId()}
                <td><input type="hidden" name="id" value="${customer.getId()}"></td>
            </tr>
            <tr>
                <td>id customer type:</td>
                <td><input type="text" name="idCustomerType" value="${customer.getIdCustomerType()}"></td>
            </tr>
            <tr>
                <td>name:</td>
                <td><input type="text" name="name" value="${customer.getName()}"></td>
            </tr>
            <tr>
                <td>birthday:</td>
                <td><input type="text" name="birthDay" value="${customer.getBirthDay()}"></td>
            </tr>
            <tr>
                <td>gender:</td>
                <td><input type="radio" name="gender" value="true">nam</td>
                <td><input type="radio" name="gender" value="false">nu</td>
            </tr>
            <tr>
                <td>id card:</td>
                <td><input type="text" name="idCard" value="${customer.getIdCard()}"></td>
            </tr>
            <tr>
                <td>phone:</td>
                <td><input type="text" name="phone" value="${customer.getPhone()}"></td>
            </tr>
            <tr>
                <td>email:</td>
                <td><input type="text" name="email" value="${customer.getEmail()}"></td>
            </tr>
            <tr>
                <td>address:</td>
                <td><input type="text" name="address" value="${customer.getAddress()}"></td>
            </tr>
            <tr>

                <td colspan="2">
                    <input type="submit" name="edit" value="update">
                </td>
            </tr>
        </table>
    </fieldset>
</form>
<a href="/customer-servlet">Back the list</a>
</body>
</html>
