<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 11/3/2023
  Time: 5:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Email Validate</h1>
<h3 style="color:red">${message}</h3>
<form method="post" action="/validate">
    <input type="text" name="email">
    <input type="submit" value="submit">
</form>
</body>
</html>
