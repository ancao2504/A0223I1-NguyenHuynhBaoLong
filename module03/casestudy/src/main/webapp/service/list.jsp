<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>
    <a href="/service-servlet?action=create">Create new Service</a>
</h2>
<table border="1px">
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
            <td>${s.idRentType}</td>
            <td>${s.idTypeService}</td>
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
