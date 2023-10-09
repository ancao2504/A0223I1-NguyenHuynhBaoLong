<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Service List</title>
    <link rel="stylesheet" href="bootstrap520/css/bootstrap.min.css" />
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css" />
</head>
<body>
<h2>
    <a href="/service-servlet?action=create">Create new Service</a>
</h2>
<table id="customerTable" class="table table striped table-bordered" style="width: 100%;">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Area</th>
        <th>Fee</th>
        <th>Max People</th>
        <th>ID Rental Type</th>
        <th>ID Type Service</th>
        <th>Standard Room</th>
        <th>Description</th>
        <th>Pool Area</th>
        <th>Floor</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${services}" var="s" varStatus="loop">
        <tr>
<%--      private String name;
    private int areaService;
    private double costService;
    private int maxPeople;
    private int idRentType;
    private int idTypeService;
    private String standardRoom;
    private String description;
    private double areaPool;
    private int floor;      --%>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.areaService}</td>
           <td>${s.costService}</td>
            <td>${s.maxPeople}</td>
            <td>
                <c:forEach items="${rentTypes}" var="r">
                    <c:if test="${s.idRentType == r.id}" >
                        <option value="${r.id}">${r.name}</option>
                    </c:if>
                </c:forEach>
            </td>
            <td>
                <c:forEach items="${serviceTypes}" var="st">
                    <c:if test="${s.idTypeService == st.id}" >
                        <option value="${st.id}">${st.name}</option>
                    </c:if>
                </c:forEach>
            </td>
            <td>${s.standardRoom}</td>
            <td>${s.description}</td>
            <td>${s.areaPool}</td>
            <td>${s.floor}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="index.jsp">Back to main screen</a>
</body>
</html>
