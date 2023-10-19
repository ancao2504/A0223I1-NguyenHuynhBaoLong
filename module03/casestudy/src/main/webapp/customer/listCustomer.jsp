<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Customer List</title>
    <link rel="stylesheet" href="bootstrap520/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
</head>
<body>
<h2>
    <a href="/customer-servlet?action=create">Create new Customer</a>
</h2>
<c:if test="${mess != null}" >
    <h3>${mess}</h3>
</c:if>

<form action="/customer-servlet?action=search" method="post">
    <table>
        <tr>
            <td><input type="text" name="name"></td>
            <td><input type="submit" name="search" value="search"></td>
        </tr>
    </table>
</form>
<a href="/customer-servlet?action=customerAreUsing"> list of customers are using service</a>
<table id="customerTable" class="table table striped table-bordered" style="width: 100%;">
    <thead>
    <tr>
        <th>Order</th>
        <th>Name</th>
        <th>BirthDay</th>
        <th>gender</th>
        <th>id Card</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Address</th>
        <th>Type Customer</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customers}" var="c" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${c.name}</td>
            <td>${c.birthDay}</td>
            <c:if test="${c.gender == false}">
                <td>Nữ</td>
            </c:if>
            <c:if test="${c.gender == true}">
                <td>Nam</td>
            </c:if>
            <td>${c.idCard}</td>
            <td>${c.phone}</td>
            <td>${c.email}</td>
            <td>${c.address}</td>
            <td>
                <c:forEach items="${customerTypes}" var="ct" varStatus="loop">
                    <c:if test="${c.idCustomerType == ct.id}">
                        <option value="${ct.getId()}">${ct.getName()}</option>
                    </c:if>
                </c:forEach>
            </td>
            <td>
                <a href="/customer-servlet?action=edit&id=${c.id}">
                    <i class="fa-solid fa-pen-to-square"></i>
                </a>
                <a href="/customer-servlet?action=delete&id=${c.id}">
                    <i class="fa-solid fa-trash" style="color: #000000;"> </i>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="main.jsp">
    <i class="fa-solid fa-arrow-left">
        Back
    </i>
</a>
</body>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>
</script>
<script>
    $(document).ready(function () {
        $('#customerTable').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });

</script>
</html>
