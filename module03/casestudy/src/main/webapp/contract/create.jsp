<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Create Contract</title>
    <link rel="stylesheet" href="bootstrap520/css/bootstrap.min.css" />
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css" />
</head>
<body>
<form method="post" action="/contract-servlet?action=create">
    <fieldset>
        <%--        //int id, Date startContract, Date endContract, double depositContract, double totalMoney,
        //                    int idEmployee, int idCustomer, int idService--%>
        <legend>Contract information</legend>
        <table class="table table striped table-bordered" style="width: 100%;">

            <tr>
                <td>Start Contract:</td>
                <td><input type="text" name="startContract"></td>
            </tr>
            <tr>
                <td>End Contract::</td>
                <td><input type="text" name="endContract"></td>
            </tr>
            <tr>
                <td>Deposit:</td>
                <td><input type="text" name="depositContract"></td>
            </tr>
            <tr>
                <td>Total:</td>
                <td><input type="text" name="totalMoney"></td>
            </tr>
            <tr>
                <td> employee:</td>
                <td>
                    <select>
                        <c:forEach items="${employees}" var="e">
                            <option name="idEmployee"> ${e.name}</option>
                        </c:forEach>
                    </select></td>
            </tr>
            <tr>
                <td> customer:</td>
                <td>
                    <select>
                        <c:forEach items="${customers}" var="c">
                            <option name="idCustomer"> ${c.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>service:</td>
                <td>
                    <select>
                    <c:forEach items="${services}" var="s">
                        <option name="idService"> ${s.name}</option>
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
<a href="/contract-servlet">Back the list</a>
</body>
</html>
