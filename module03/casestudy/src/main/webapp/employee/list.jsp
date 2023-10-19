<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>
    <link rel="stylesheet" href="bootstrap520/css/bootstrap.min.css" />
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css" />
</head>
<body>
<h2>
    <a href="/employee-servlet?action=create">Create new Employee</a>
</h2>
<c:if test="${mess != null}" >
    <h3>${mess}</h3>
</c:if>
<form action="/employee-servlet?action=search" method="post">
    <table>
        <tr>
            <td><input type="text" name="name"></td>
            <td><input type="submit" name="search" value="search"></td>
        </tr>
    </table>
</form>
            <table id="tableEmployee" class="table table striped table-bordered" style="width: 100%;">
                <thead>
                <tr>
                    <th>Order</th>
                    <th>id card</th>
                    <th>name</th>
                    <th>birthday</th>
                    <th> salary</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>idPosition</th>
                    <th>idEducationDegree</th>
                    <th>idDivision</th>
                    <th>userName</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${employees}" var="e" varStatus="loop">
                    <tr>
                        <td>${loop.count}</td>
                        <td>${e.idCard}</td>
                        <td>${e.name}</td>
                        <td>${e.birthDay}</td>
                        <td>${e.salary}</td>
                        <td>${e.phone}</td>
                        <td>${e.email}</td>
                        <td>${e.address}</td>
                        <td>
                               <c:forEach items="${positions}" var="p" varStatus="loop" >
                                   <c:if test="${e.getIdPosition() == p.id}">
                                       <option name="idPosition" value="${p.id}">${p.name}</option>
                                   </c:if>
                               </c:forEach>

                        </td>
                        <td>
                            <c:forEach items="${educationDegrees}" var="ed" varStatus="loop" >
                                <c:if test="${ed.id == e.getIdEducationDegree()}">
                                    <option name="idEducationDegree" value="${ed.id}">${ed.name}</option>
                                </c:if>
                            </c:forEach>
                        </td>
                        <td>
                            <c:forEach items="${divisions}" var="d" varStatus="loop" >
                                <c:if test="${d.id == e.getIdDivision()}">
                                    <option name="idDivision" value="${d.id}">${d.name}</option>
                                </c:if>
                            </c:forEach>
                        </td>
                        <td>${e.userName}</td>
                        <td>
                            <a href="/employee-servlet?action=edit&id=${e.id}">edit</a>
                            <a href="/employee-servlet?action=delete&id=${e.id}">delete</a>
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
        $('#tableEmployee').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        } );
    } );
</script>
</html>
