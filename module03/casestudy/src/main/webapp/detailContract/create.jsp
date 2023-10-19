<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <title>Detail Contract List</title>
    <link rel="stylesheet" href="bootstrap520/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css"/>
</head>
<body>
<form method="post" action="/detailcontract-Servlet?action=create">
    <fieldset>
        <legend>detail contract information</legend>
        <table class="table table striped table-bordered" style="width: 100%;" >
<%--   int idContract = Integer.parseInt(request.getParameter("idContract"));
        int idAttachService = Integer.parseInt(request.getParameter("idAttachService"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));--%>
            <tr>
                <td>Name attach service</td>
                <td>
                    <select  name="idAttachService">
                        <c:forEach items="${attachServices}" var="a" varStatus="loop">
                            <option  value="${a.getId()}">${a.getName()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Quantity:</td>
                <td><input type="text" name="quantity"></td>
            </tr>
            <tr>
                <td>idContract:</td>
                <td>
                    <select  name="idContract">
                        <c:forEach items="${contracts}" var="c" varStatus="loop">
                            <option  value="${c.getId()}">${c.getId()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>

                <td colspan="2">
                    <input type="submit" name="create" value="create">
                </td>
            </tr>
        </table>
    </fieldset>
</form>
<a href="/detailcontract-Servlet">Back the list</a>

</body>
</html>
