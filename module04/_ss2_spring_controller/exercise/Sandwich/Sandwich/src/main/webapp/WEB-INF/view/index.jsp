<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="sandwich" method="post" action="/" >
  <form:checkboxes path="spice" items="${sandwichSpice}"/>
  <input type="submit" value="save">

</form:form>
<h3>${sandwich}</h3>
</body>
</html>
