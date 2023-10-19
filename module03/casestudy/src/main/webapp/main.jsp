<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
        <link rel="stylesheet" href="customer/caseStudy.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
</head>
<body>
<div id="container">
    <div id="header">
        <i class="fa-regular fa-image-portrait" style="float: left;"></i>
        <div style="float:right; font-size: larger">${userName}</div>
    </div>
    <div id="side-bar">
    <span>
        <a href="/customer-servlet" name="action">Customer</a>
    </span>
        <span>
        <a href="/service-servlet" name="action">Service</a>
    </span>
    <span>
        <a href="/employee-servlet" name="action">Employee</a>
    </span>
    <span>
        <a href="/contract-servlet " name="action">Contract</a>
    </span>
        <span>
        <a href="/detailcontract-Servlet " name="action">detail contract</a>
    </span>
    </div>
    <div id="left">
        <p>item1</p>
        <p>item1</p>
        <p>item1</p>
    </div>
</div>
</body>
</html>
