<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Create Customer</title>
    <link rel="stylesheet" href="bootstrap520/css/bootstrap.min.css" />
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css" />
</head>
</head>
<body>
<form method="post" action="/customer-servlet?action=create">

    <fieldset>
        <legend>Customer information</legend>
    <table class="table table striped table-bordered" style="width: 100%;">

        <tr>
            <td>Name type Customer</td>
            <td>
            <select  name="idCustomerType">
                <c:forEach items="${customerTypes}" var="c" varStatus="loop">
                <option  value="${c.getId()}">${c.getName()}</option>
                </c:forEach>
            </select>
            </td>
        </tr>
        <tr>
            <td>name:</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>birthday:</td>
            <td><input type="date" name="birthDay"></td>
        </tr>
        <tr>
            <td>gender:</td>
            <td><input type="radio" name="gender" value="true">nam</td>
            <td><input type="radio" name="gender" value="false">nu</td>
        </tr>
        <tr>

            <td>id card:
                <c:if test="${errorCode !=null}">
                    <span style="color: red">${errorCode}</span>
                </c:if></td>
            <td><input type="text" name="idCard"></td>
        </tr>
        <tr>
            <td>phone:
                <c:if test="${errorPhone !=null}">
                    <span style="color: red">${errorPhone}</span>
                </c:if></td></td>
            <td><input type="text" name="phone"></td>
        </tr>
        <tr>
            <td>email:
                <c:if test="${errorEmail !=null}">
                    <span style="color: red">${errorEmail}</span>
                </c:if></td></td>
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
