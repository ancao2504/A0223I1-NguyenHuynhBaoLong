<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/service-servlet?action=create">
    <fieldset>
        <legend>Service information</legend>
        <table>
            <tr>
<%--                 String name = request.getParameter("name");
             int area = Integer.parseInt(request.getParameter("area"));
             double fee = Double.parseDouble(request.getParameter("fee"));
             int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
             int idRentType= Integer.parseInt(request.getParameter("idRentType"));
             int idTypeService = Integer.parseInt(request.getParameter("idTypeService"));
             String standardRoom = request.getParameter("standardRoom");
            String description = request.getParameter("description");
             double areaPool = Double.parseDouble(request.getParameter("areaPool"));
             int floor = Integer.parseInt(request.getParameter("floor"));--%>
                <td>name:</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>areaService:</td>
                <td><input type="number" name="area"></td>
            </tr>
            <tr>
                <td>costService:</td>
                <td><input type="text" name="fee"></td>
            </tr>
            <tr>
                <td>maxPeople:</td>
                <td><input type="text" name="maxPeople"></td>
            </tr>
            <tr>
                <td>idRentType:</td>
                <td><input type="text" name="idRentType"></td>
            </tr>
            <tr>
                <td>idTypeService:</td>
                <td><input type="text" name="idTypeService"></td>
            </tr>
            <tr>
                <td>standardRoom:</td>
                <td><input type="text" name="standardRoom"></td>
            </tr>
            <tr>
                <td>description:</td>
                <td><input type="text" name="description"></td>
            </tr>
            <tr>
                <td>areaPool:</td>
                <td><input type="text" name="areaPool"></td>
            </tr>
                <tr>
                    <td>floor:</td>
                    <td><input type="text" name="floor"></td>
                </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" name="create" value="create">
                </td>
            </tr>
        </table>
    </fieldset>
</form>
<a href="/service-servlet">Back the list</a>
</body>
</html>
