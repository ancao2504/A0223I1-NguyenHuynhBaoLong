<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${mess!=null}">
    <p name="mess">${mess}</p>
</c:if>

<h1>
    <a href="/student-servlet?action=create">Create new student</a>
</h1>
<table border="1px">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>gender</th>
        <th>point</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${students}" var="s" varStatus="loop">
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.gender}</td>
            <td>${s.point}</td>
            <td>
                <a href="/student-servlet?action=edit&id=${s.id}">edit</a>
                <a href="/student-servlet?action=delete&id=${s.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
