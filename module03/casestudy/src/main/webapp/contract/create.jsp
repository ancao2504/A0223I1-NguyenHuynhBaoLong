
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/contract-servlet?action=create">
    <fieldset>
        <%--        //int id, Date startContract, Date endContract, double depositContract, double totalMoney,
        //                    int idEmployee, int idCustomer, int idService--%>
        <legend>Contract information</legend>
        <table >

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
                <td>id employee:</td>
                <td><input type="text" name="idEmployee"></td>
            </tr>
            <tr>
                <td>id customer:</td>
                <td><input type="text" name="idCustomer"></td>
            </tr>
            <tr>
                <td>id service:</td>
                <td><input type="text" name="idService"></td>
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
