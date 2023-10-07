<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<h2>
    <a href="/contract-servlet?action=create">Create new Contract</a>
</h2>
<%--        //int id, Date startContract, Date endContract, double depositContract, double totalMoney,
        //                    int idEmployee, int idCustomer, int idService--%>
<h3>
    <c:if test="${mess !=null}">
    <span>${mess}</span>
</c:if>
</h3>

<table class="table table striped table-bordered" style="width: 100%;">
    <thead>
    <tr>
        <th>Order</th>
        <th>Start Contract</th>
        <th>End Contract</th>
        <th>Deposit</th>
        <th>Total</th>
        <th>ID Employee</th>
        <th>ID Customer</th>
        <th>ID Service</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${contracts}" var="c" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${c.startContract}</td>
            <td>${c.endContract}</td>
            <td>${c.depositContract}</td>
            <td>${c.totalMoney}</td>
            <td>${c.idEmployee}</td>
            <td>${c.idCustomer}</td>
            <td>${c.idService}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="index.jsp">Back to main screen</a>
</body>
</html>
