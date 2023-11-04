
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/">
    <input type="text" name="number1">
    <input type="text" name="number2">
    <button type="submit" value="+" name="val">+</button>
    <button type="submit" value="-" name="val">-</button>
    <button type="submit" value="*" name="val">*</button>
    <button type="submit" value="/" name="val">/</button>
</form>
<h3>${result}</h3>
</body>
</html>
