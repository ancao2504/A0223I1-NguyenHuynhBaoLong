
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/customer-servlet?action=delete">
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>id :</td>
                <td>${customer.getId()}
                    <input type="hidden" name="id" value="${customer.getId()}">
                </td>
            </tr>
            <tr>
                <td>id customer type:</td>
                <td>${customer.getIdCustomerType()}
                    <input type="hidden" name="idCustomerType" value="${customer.getIdCustomerType()}">
                </td>
            </tr>
            <tr>
                <td>name:</td>
                <td>${customer.getName()}
                    <input type="hidden" name="name" value="${customer.getName()}">
                </td>
            </tr>
            <tr>
                <td>birthday:</td>
                <td>${customer.getBirthDay()}
                    <input type="hidden" name="birthDay" value="${customer.getBirthDay()}">
                </td>
            </tr>
            <tr>
                <td>gender:</td>
                <td>
                    ${customer.isGender()}
                </td>
            </tr>
            <tr>
                <td>id card:</td>
                <td>${customer.getIdCard()}
                    <input type="hidden" name="idCard" value="${customer.getIdCard()}">
                </td>
            </tr>
            <tr>
                <td>phone:</td>
                <td>${customer.getPhone()}
                    <input type="hidden" name="phone" value="${customer.getPhone()}">
                </td>
            </tr>
            <tr>
                <td>email:</td>
                <td>${customer.getEmail()}
                    <input type="hidden" name="email" value="${customer.getEmail()}">
                </td>
            </tr>
            <tr>
                <td>address:</td>
                <td>${customer.getAddress()}
                    <input type="hidden" name="address" value="${customer.getAddress()}">
                </td>
            </tr>
            <tr>
                <td>Are you sure?</td>
                <td >
                    <input type="submit" name="delete" value="delete">
                </td>
            </tr>
        </table>
    </fieldset>
</form>
<a href="/customer-servlet">Back the list</a>
</body>
</html>
