<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Detail Contract List</title>
    <link rel="stylesheet" href="bootstrap520/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css"/>
</head>
<body>
<h2>
    <a href="/detailcontract-Servlet?action=create">Create new detail contract</a>
</h2>

<table id="detailTable" class="table table striped table-bordered" style="width: 100%;">
    <thead>
    <tr>
        <th>Order</th>
        <th>Quantity</th>
        <th>Name attach service</th>
        <th>Contract id</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${contractDetails}" var="c" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${c.quantity}</td>

            <td>
                <c:forEach items="${attachServices}" var="a" varStatus="loop">
                    <c:if test="${c.idAttachService == a.id}">
                        <option value="${a.getId()}">${a.getName()}</option>
                    </c:if>
                </c:forEach>
            </td>
            <td>${c.idContract}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="index.jsp">Back to main screen</a>
</body>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>
</script>
<script>
    $(document).ready(function () {
        $('#detailTable').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
</html>
