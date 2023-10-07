<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
    <form method="post" action="/employee-servlet?action=create">
    <fieldset>
        <legend>Employee information</legend>
        <table>
            <%--                employee = new Employee(id, idCard, name, date, salary, phone, email, address, idPosition,
                                    idEducationDegree, idDivision, userName);--%>
<%--            String idCard = (request.getParameter("idCard"));
        String name = request.getParameter("name");
        String birthDay = request.getParameter("birthDay");
        Date date = Date.valueOf(birthDay);
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int idPosition = Integer.parseInt(request.getParameter("idPosition"));
        int idEducationDegree = Integer.parseInt(request.getParameter("idEducationDegree"));
        int idDivision = Integer.parseInt(request.getParameter("idDivision"));
        String userName = request.getParameter("userName");--%>
            <tr>
                <td>id card:</td>
                <td><input type="text" name="idCard"></td>
            </tr>
            <tr>
                <td>name:</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>birthday:</td>
                <td><input type="text" name="birthDay"></td>
            </tr>
            <tr>
                <td>salary:</td>
                <td><input type="text" name="salary"></td>
            </tr>
            <tr>
                <td>phone:</td>
                <td><input type="text" name="phone"></td>
            </tr>
            <tr>
                <td>email:</td>
                <td><input type="text" name="email"></td>
            </tr>
            <tr>
                <td>address:</td>
                <td><input type="text" name="address"></td>
            </tr>
            <tr>
                <td>idPosition:</td>
                <td>
                    <select name="idPosition" >
                        <c:forEach items="${positions}" var="p" varStatus="loop" >
                            <option  value="${p.getId()}">${p.getName()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>idEducationDegree:</td>
                <td>
                    <select name="idEducationDegree" >
                        <c:forEach items="${educationDegrees}" var="e" varStatus="loop" >
                            <option  value="${e.getId()}">${e.getName()}</option>
                        </c:forEach>
                    </select>

                </td>
            </tr>
            <tr>
                <td>idDivision:</td>
                <td>
                    <select name="idDivision" >
                        <c:forEach items="${divisions}" var="d" varStatus="loop" >
                            <option  value="${d.getId()}">${d.getName()}</option>
                        </c:forEach>
                    </select>

            </tr>
            <tr>
                <td>userName:</td>
                <td><input type="text" name="userName"></td>
            </tr>
            <tr>

                <td colspan="2">
                    <input type="submit" name="create" value="create">
                </td>
            </tr>
        </table>
    </fieldset>
</form>
<a href="/employee-servlet">Back the list</a>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous">
</script>
<script>

</script>
</html>
