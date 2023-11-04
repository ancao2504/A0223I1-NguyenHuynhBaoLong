
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="convert" method="post">
    <input type="text" name="usd">
    <input type="text" name="vnd" value="21000" readonly>
    <input type="submit" value="Change">
    <br>
</form>
<input type="text" value="${result}" readonly>
</body>
</html>
