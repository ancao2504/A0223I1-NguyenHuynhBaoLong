<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>order</th>
        <th>Language</th>
        <th>Page Size</th>
        <th>Spams Filter</th>
        <th>Signature</th>
        <th>Edit</th>
    </tr>
    <c:forEach items="${email}" var="e" varStatus="loop">
        <tr>
            <input name="id" value="${e.id}" type="hidden"/>
            <td>${loop.count}</td>
            <td>
                <c:forEach items="${e.language}" varStatus="loop" var="l">
                    <span>${l}</span>
                </c:forEach>
            </td>
            <td>
                <c:forEach items="${e.size}" varStatus="loop" var="s">
                    <span>${s}</span>
                </c:forEach>
            </td>
            <td>
                    ${e.spamsFilter}
            </td>
            <td>
                <c:forEach items="${e.sigNature}" varStatus="loop" var="sn">
                    <span>${sn}</span>
                </c:forEach>
            </td>

            <td>
                <a href="/edit?id=${e.id}">edit</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
