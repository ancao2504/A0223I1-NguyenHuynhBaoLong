<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 9/21/2023
  Time: 6:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/product-servlet" method="get">
  <label>product Description: <input type="text" name="productDescription"> </label>
  <label>price:<input type="number" name="price"> </label>
  <label>percent:<input type="number" name="percent"> </label>
  <label> <input type="submit" value="Calculate"> </label>
</form>
</body>
</html>
