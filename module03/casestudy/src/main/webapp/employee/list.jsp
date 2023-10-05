<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>
    <a href="/employee-servlet?action=create">Create new Customer</a>
</h2>

<%--<form action="/customer-servlet?action=search" method="post">--%>
<%--    <table>--%>
<%--        <tr>--%>
<%--            <td><input type="text" name="name" ></td>--%>
<%--            <td><input type="submit" name="search" value="search"></td>--%>
<%--        </tr>--%>
<%--    </table>--%>
<%--</form>--%>
<table border="1px">
    <thead>

    <tr>
        <th>Order</th>
        <th>id card</th>
        <th>name</th>
        <th>birthday</th>
        <th> salary</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Address</th>
        <th>idPosition</th>
        <th>idEducationDegree</th>
        <th>idDivision</th>
        <th>userName</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${employees}" var="e" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${e.idCard}</td>
            <td>${e.name}</td>
            <td>${e.birthDay}</td>
            <td>${e.salary}</td>
            <td>${c.phone}</td>
            <td>${c.email}</td>
            <td>${c.address}</td>
            <td>${e.idPosition}</td>
            <td>${e.idEducationDegree}</td>
            <td>${e.idDivision}</td>
            <td>${e.userName}</td>
            <td>
                <a href="/employee-servlet?action=edit&id=${e.id}">edit</a>
                <a href="/employee-servlet?action=delete&id=${e.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="index.jsp">Back to main screen</a>
</body>
</html>
