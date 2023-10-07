<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="customer/caseStudy.css">
</head>
<body>
<div id="container">
    <div id="header">
        <h1>
            CASE STUDY
        </h1>
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
    </div>
    <div id="left">
        <p>item1</p>
        <p>item1</p>
        <p>item1</p>
    </div>
</div>
</body>
</html>