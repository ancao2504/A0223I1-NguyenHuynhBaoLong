<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<form action="/product-servlet" method="get">
    <label>product Description: <input type="text" name="productDescription"> </label>
    <label>price:<input type="number" name="price"> </label>
    <label>percent:<input type="number" name="percent"> </label>
    <input type="submit" value="calculate">
</form>
kết quả: ${discount}
</body>
</html>