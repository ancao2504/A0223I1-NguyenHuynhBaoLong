<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        body {
            padding: 0px;
            margin: 0;
            font-family: Verdana, Geneva, Tahoma, sans-serif;
        }

        table {
            position: absolute;
            left: 50%;
            top: 50%;
            transform: translate(-50%, -50%);
            border-collapse: collapse;
            min-width: 1390px;
            min-height: 400px;
            border: 1px solid #bdc3c7;
            box-shadow: 2px 2px 12px rgba(0, 0, 0, 0.2), -1px -1px 8px rgba(0, 0, 0, 0.2);
        }

        tr {
            transition: all .2s ease-in;
            cursor: pointer;
        }

        th,
        td {
            /*display: inline;*/
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        #header {
            background-color: #16a085;
            color: #fff;
        }

        h1 {
            font-weight: 600;
            text-align: center;
            background-color: #16a085;
            color: #fff;
            padding: 10px 0px;
        }

        tr:hover {
            background-color: #f5f5f5;
            transform: scale(1.02);
            box-shadow: 2px 2px 12px rgba(0, 0, 0, 0.2), -1px -1px 8px rgba(0, 0, 0, 0.2);
        }

        @media only screen and (max-width: 768px) {
            table {
                width: 90%;
            }
        }

        #table {
            position: relative;
            top: 200px;
            margin-top: 10px; /* Điều chỉnh khoảng cách giữa bảng và phân trang */
        }
    </style>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="bootstrap520/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
</head>
<body>
<form method="post" action="/ProductServlet?action=update">
    <table id="table">
        <%-- String name = request.getParameter("name");
                Double price = Double.valueOf(request.getParameter("price"));
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                int idColor = Integer.parseInt(request.getParameter("color"));
                Color color = colorService.findById(idColor);
                String description = request.getParameter("description");
                int idCategory = Integer.parseInt(request.getParameter("category"));
                Category category =categoryService.findById(idCategory);--%>
        <tr>
            <td>Name</td>
            <td>
                <input type="text" name="name">
            </td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="text" name="price"></td>
        </tr>
        <tr>
            <td>Color</td>
            <td>
                <select name="color">
                    <c:forEach items="${color}" var="c">
                        <c:if test="${c.id == product.color.id}">
                            <option value="${c.id}" selected>${c.name}</option>
                        </c:if>
                        <c:if test="${c.id != product.category.id}">
                            <option value="${c.id}" >${c.name}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Category</td>
            <td>
                <select name="category">
                    <c:forEach items="${categorie}" var="ct">
                        <c:if test="${ct.id == product.category.id}">
                            <option value="${ct.id}" selected>${ct.name}</option>
                        </c:if>
                        <c:if test="${ct.id != products.category.id}">
                            <option value="${ct.id}" >${ct.name}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>description</td>
            <td><input type="text" name="description"></td>
        </tr>
        <tr>
            <td>quantity</td>
            <td><input type="text" name="quantity">  </td>
        </tr>
        <tr>
            <td>
                <input type="submit" name="update" value="update">
            </td>
        </tr>
    </table>
    <a href="/ProductServlet">Back</a>
</form>
</body>
</html>
