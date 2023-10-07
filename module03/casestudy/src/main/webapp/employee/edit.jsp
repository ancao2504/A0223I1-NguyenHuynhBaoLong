<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/employee-servlet?action=edit">
    <fieldset>
<%--           //                int id, int idCard, String name, Date birthDay, double salary, String phone, String email,
//                    String address, int idPosition, int idEducationDegree, int idDivision, String userName) {--%>
        <legend>Employee information</legend>
        <table>
            <tr>
                <td><input type="hidden" name="id" value="${employee.getId()}"></td>
            </tr>
            <tr>
                <td>idCard :</td>
                <td><input type="text" name="idCard" value="${employee.getIdCard()}"></td>
            </tr>
            <tr>
                <td>name:</td>
                <td><input type="text" name="name" value="${employee.getName()}"></td>
            </tr>
            <tr>
                <td>birthDay:</td>
                <td><input type="text" name="birthDay" value="${employee.getBirthDay()}"></td>
            </tr>
            <tr>
                <td>salary:</td>
                <td><input type="text" name="salary" value="${employee.getSalary()}"></td>
            </tr>
            <tr>
                <td>phone:</td>
                <td><input type="text" name="phone" value="${employee.getPhone()}"></td>
            <tr>
                <td>email:</td>
                <td><input type="text" name="email" value="${employee.getEmail()}"></td>
            </tr>
            <tr>
                <td>address:</td>
                <td><input type="text" name="address" value="${employee.getAddress()}"></td>
            </tr>
            <tr>
                <td>Name position:</td>
                <td>
                    <select name="idPosition" >
                        <c:forEach items="${positions}" var="p" varStatus="loop">
                            <c:if test="${employee.getIdPosition() == p.id}">
                                <option value="${p.getId()}" selected>${p.getName()}</option>
                            </c:if>
                            <c:if test="${employee.getIdPosition() != p.id}">
                                <option value="${p.getId()}" >${p.getName()}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>

            </tr>
            <tr>
                <td>EducationDegree:</td>
                <td>
                    <select name="idEducationDegree" >
                        <c:forEach items="${educationDegrees}" var="e" varStatus="loop">
                            <c:if test="${employee.getIdEducationDegree() == e.id}">
                                <option value="${e.getId()}" selected>${e.getName()}</option>
                            </c:if>
                            <c:if test="${employee.getIdEducationDegree() != e.id}">
                                <option value="${e.getId()}" >${e.getName()}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>

            </tr>
            <tr>
                <td>Division:</td>
                <td>
                    <select name="idDivision" >
                        <c:forEach items="${divisions}" var="d" varStatus="loop">
                            <c:if test="${employee.getIdDivision() == d.id}">
                                <option value="${d.getId()}" selected>${d.getName()}</option>
                            </c:if>
                            <c:if test="${employee.getIdDivision() != e.id}">
                                <option value="${d.getId()}" >${d.getName()}</option>
                            </c:if>
                        </c:forEach>
                    </select>

            </tr>
            <tr>
                <td>userName:</td>
                <td><input type="text" name="userName" value="${employee.getUserName()}"></td>
            </tr>
            <tr>

                <td colspan="2">
                    <input type="submit" name="edit" value="update">
                </td>
            </tr>
        </table>
    </fieldset>
</form>
<a href="/employee-servlet">Back the list</a>
</body>
</html>
