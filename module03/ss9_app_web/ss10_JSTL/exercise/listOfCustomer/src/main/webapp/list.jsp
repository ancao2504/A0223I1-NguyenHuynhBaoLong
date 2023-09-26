<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Of Customer</title>
  <style>
    img{
      width: 50px;
      height: 50px;
    }
  </style>
</head>
<body>
<table border="1">
  <thead>
    <tr>
      <th>Name</th>
      <th>Date Of Birth</th>
      <th>Address</th>
      <th>Ava</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${list}" var="c" varStatus="loop">
      <tr>
        <td>${c.name}</td>
        <td>${c.dateOfBirth}</td>
        <td>${c.address}</td>
        <td>
          <img src="${c.img}">
        </td>
      </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>
