<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Edit Customer </title>
    <link rel="stylesheet" href="bootstrap520/css/bootstrap.min.css" />
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css" />
</head>
</head>
<body>
<form method="post" action="/customer-servlet?action=edit">
    <fieldset>
        <legend>Customer information</legend>
        <table class="table table striped table-bordered" style="width: 100%;">
            <tr>
                <td><input type="hidden" name="id" value="${customer.getId()}"></td>

            </tr>
            <tr>
                <td>Name type customer:</td>
                <td>
                    <select  name="idCustomerType">
                        <c:forEach items="${customerType}" var="ct" varStatus="loop">
                            <c:if test="${customer.getIdCustomerType() == ct.id}">
                                <option value="${ct.getId()}" selected>${ct.getName()}</option>
                            </c:if>
                            <c:if test="${customer.getIdCustomerType() != ct.id}">
                                <option value="${ct.getId()}" >${ct.getName()}</option>
                            </c:if>
                        </c:forEach>
                    </select>

                </td>
            </tr>
            <tr>
                <td>name:</td>
                <td><input type="text" name="name" value="${customer.getName()}"></td>
            </tr>
            <tr>
                <td>birthday:</td>
                <td><input type="date" name="birthDay" value="${customer.getBirthDay()}"></td>
            </tr>
            <tr>
                <td>gender:</td>

                    <c:if test="${customer.isGender() == true}">
                        <td><input type="radio" name="gender" value="true" checked>nam</td>
                        <td> <input type="radio" name="gender" value="false">nu</td>
                    </c:if>
                <c:if test="${customer.isGender() == false}">
                    <td><input type="radio" name="gender" value="true" >nam</td>
                    <td> <input type="radio" name="gender" value="false" checked>nu</td>
                </c:if>
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
