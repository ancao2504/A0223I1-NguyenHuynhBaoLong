<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Customer List</title>
    <link rel="stylesheet" href="bootstrap520/css/bootstrap.min.css" />
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css" />
</head>
<body>
<h2>
    <a href="/customer-servlet?action=create">Create new Customer</a>
</h2>

<form action="/customer-servlet?action=search" method="post">
    <table>
        <tr>
            <td><input type="text" name="name"></td>
            <td><input type="submit" name="search" value="search"></td>
        </tr>
    </table>
</form>

<a href="customer-servlet?action=customerAreUsing"> list of customers are using service</a>
<table id="customerTable" class="table table striped table-bordered" style="width: 100%;">
    <thead>
    <tr>
<%--            private int id;
    private int idCustomerType;
    private String name;
    private Date birthDay;
    private boolean gender;
    private String idCard;
    private String phone;
    private String email;
    private String address;
    private int idService;
    private int idTypeService;
    private int idAttachService;--%>
        <th>Order</th>
        <th>Name</th>
        <th>BirthDay</th>
        <th>gender</th>
        <th>id Card</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Address</th>
        <th>Type Customer</th>
        <th>Name type service</th>
        <th>Name service</th>
        <th>Name type attach service</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${detailCustomers}" var="d" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${d.name}</td>
            <td>${d.birthDay}</td>
            <c:if test="${d.gender == false}">
                <td>Nữ</td>
            </c:if>
            <c:if test="${d.gender == true}">
                <td>Nam</td>
            </c:if>
            <td>${d.idCard}</td>
            <td>${d.phone}</td>
            <td>${d.email}</td>
            <td>${d.address}</td>
            <td>
                <c:forEach items="${customerTypes}" var="ct" varStatus="loop">
                    <c:if test="${d.idCustomerType == ct.id}">
                        <option value="${ct.getId()}">${ct.getName()}</option>
                    </c:if>
                </c:forEach>
            </td>
            <td>
                <c:forEach items="${ServiceType}" var="st" varStatus="loop">
                    <c:if test="${d.idCustomerType == st.id}">
                        <option value="${st.getId()}">${st.getName()}</option>
                    </c:if>
                </c:forEach>
            </td>
            <td>
                <c:forEach items="${services}" var="s" varStatus="loop">
                    <c:if test="${d.idService == s.id}">
                        <option value="${s.getId()}">${s.getName()}</option>
                    </c:if>
                </c:forEach>
            </td>
            <td>
                <c:forEach items="${attachServices}" var="a" varStatus="loop">
                    <c:if test="${d.idTypeService == a.id}">
                        <option value="${a.getId()}">${a.getName()}</option>
                    </c:if>
                </c:forEach>
            </td>
            <td>
                <a href="/customer-servlet?action=edit&id=${c.id}">edit</a>
                <a href="/customer-servlet?action=delete&id=${c.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="main.jsp">Back to main screen</a>
</body>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>
</script>
<script>
    $(document).ready(function() {
        $('#customerTable').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        } );
    } );
</script>
</html>
