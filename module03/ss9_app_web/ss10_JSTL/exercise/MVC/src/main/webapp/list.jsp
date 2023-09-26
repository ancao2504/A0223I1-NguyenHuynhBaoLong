<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list students</title>
</head>
<body>
<table border="1px">
    <thead>
    <tr>
        <th>Number Orders</th>
        <th>Name</th>
        <th>Gender</th>
        <th>Point</th>
        <th>Rank</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="students" var="s" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${s.name}</td>
            <c:if test="${s.gender == true}">
                <td>nam</td>
            </c:if>
            <c:if test="${s.gender == false}">
                <td>nữ</td>
            </c:if>
            <td>${s.point}</td>
            <c:choose>
                <c:when test="${s.point >=8}">
                    <td>Giỏi</td>
                </c:when>
                <c:when test="${s.point >= 5}">
                    <td>Khá</td>
                </c:when>
                <c:when test="${s.point >= 3}">
                    <td>trung bình</td>
                </c:when>
                <c:otherwise>
                    <td>Yếu</td>
                </c:otherwise>
            </c:choose>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/student-servlet">
    <button type="submit">add</button>
</a>

</body>
</html>
