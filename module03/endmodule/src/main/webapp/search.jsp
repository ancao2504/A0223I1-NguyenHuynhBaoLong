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

        #employeeTable {
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
<a href="/ProductServlet?action=create">Create new product</a>
<form method="post" action="/ProductServlet?action=search">
    <input type="text" name="name" placeholder="name">
    <input type="text" name="price" placeholder="price">
    <input type="submit" name="find" value="search">
</form>
<table id="employeeTable">
    <thead id="header">
    <th>Order</th>
    <th>Name</th>
    <th>Price</th>
    <th>Quantity</th>
    <th>Color</th>
    <th>Category</th>
    <th>Action</th>

    </thead>
    <tbody>
    <c:forEach items="${products}" varStatus="loop" var="r">
        <tr>
            <td>${loop.count}</td>
            <td>${r.name}</td>
            <td>${r.price}</td>
            <td>${r.quantity}</td>
            <td>${r.color.name}</td>
            <td>${r.category.name}</td>
            <td>
                <a href="/ProductServlet?action=update&id=${r.id}">
                    <button class="btn btn-outline-warning">Edit</button>
                </a>
                <button type="button" class="btn btn-outline-danger"
                        onclick="sendInf('${r.name}','${r.id}')" data-bs-toggle="modal"
                        data-bs-target="#exampleModal">
                    Remove
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="?action=delete" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Remove product</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="hidden" name="idDel" id="idDel">
                    Are you sure to remove <span id="nameDel" class="text-danger"></span> ?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-danger">Remove</button>
                </div>
            </div>
        </form>
    </div>
</div>
</div>
<a href="/ProductServlet">back</a>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
<script>
    function sendInf(name, id) {
        document.getElementById("nameDel").innerText = name;
        document.getElementById("idDel").value = id;
    }
</script>

</script>
<script>
    $(document).ready(function () {
        $('#employeeTable').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
</body>
</html>
