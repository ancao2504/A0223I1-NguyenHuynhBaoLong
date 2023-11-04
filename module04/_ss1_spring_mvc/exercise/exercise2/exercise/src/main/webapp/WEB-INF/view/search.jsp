<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 11/3/2023
  Time: 3:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="get" action="/search">
    <input type="text" name="word">
    <input type="text" value="${result}">
    <input type="submit" value="search">
</form>
</body>
</html>
