<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="email" method="post" action="/update">
    id: ${email.id} <form:hidden path="id"  ></form:hidden>
    Languages : <form:checkboxes path="language" items="${languages}"/> <br>
    <span>Page Size:Show </span> <form:checkboxes path="size" items="${size}"/> <span>emails per pages</span> <br>
    Spams Filter: <form:checkbox path="spamsFilter"/> <br>
    signature: <form:input path="sigNature"/> <br>
    <button>EDIT</button>
</form:form>
</body>
</html>
