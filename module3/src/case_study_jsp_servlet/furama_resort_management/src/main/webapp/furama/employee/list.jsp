<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 27-Oct-21
  Time: 05:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employee</title>
    <link rel="stylesheet" href="/asset/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/asset/datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<div class="container-fluid bg-light">
    <div class="row px-lg-5 pt-lg-3 pb-lg-1">
        <div class="col-lg-10">
            <img class="img-fluid" src="asset/images/furama.png"/>
        </div>
        <div class="col-lg-2">
            <p class="font-weight-bold text-info">A0321I1 - Võ Thành Luân</p>
        </div>
    </div>
    <div class="row px-lg-5">
        <div class="col-lg-12">
            <hr class="m-0">
            <nav class="navbar navbar-expand-lg navbar-light">
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/employee">Employee</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/customer">Customer</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/contract">Contract</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Service</a>
                        </li>
                    </ul>
                    <form action="/employee" class="form-inline my-2 my-lg-0">
                        <input name="action" value="search" hidden>
                        <input class="form-control mr-sm-2" name="key" type="search" placeholder="Employee name..."
                               aria-label="Search">
                        <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Search</button>
                    </form>
                </div>
            </nav>
        </div>
    </div>
</div>
<div class="container-fluid">
    <div class="row bg-white">
        <div class="col-lg-12 bg-white px-lg-5 pt-lg-3">
            <a href="/employee?action=create" class="btn btn-success mt-lg-2">Add new</a>
            <table id="employee" class="table table-bordered mt-lg-2">
                <thead class="thead-light">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Birthday</th>
                    <th scope="col">ID card</th>
                    <th scope="col">Salary</th>
                    <th scope="col">Phone</th>
                    <th scope="col">Email</th>
                    <th scope="col">Address</th>
                    <th scope="col">Position</th>
                    <th scope="col">Education</th>
                    <th scope="col">Division</th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="employee" items="${employeeList}">
                    <tr>
                        <td> ${employee.id}</td>
                        <td> ${employee.name}</td>
                        <td> ${employee.birthday}</td>
                        <td> ${employee.idCard}</td>
                        <td> ${employee.salary}</td>
                        <td> ${employee.phone}</td>
                        <td> ${employee.email}</td>
                        <td> ${employee.address}</td>
                        <td> ${employee.positionName}</td>
                        <td> ${employee.educationName}</td>
                        <td> ${employee.divisionName}</td>
                        <td>
                            <button type="button" class="btn btn-info">
                                <a href="/employee?action=update&id=${employee.id}" class="text-white">Update</a>
                            </button>
                        </td>
                        <td>
                            <button type="button" class="btn btn-danger" onclick="setValueForm('${employee.id}')"
                                    data-toggle="modal" data-target="#modalDelete">
                                Delete
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<!-- Modal confirm delete -->
<div class="modal fade" id="modalDelete" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form method="post" action="/employee?action=delete">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Delete employee</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <input name="id" id="id" hidden>
                    Are you sure about that?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-danger">Delete</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="/asset/jquery/jquery-3.5.1.min.js"></script>
<script src="/asset/bootstrap413/js/popper.min.js"></script>
<script src="/asset/datatables/js/jquery.dataTables.min.js"></script>
<script src="/asset/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="/asset/bootstrap413/js/bootstrap.min.js"></script>
<script src="/asset/bootstrap413/js/bootstrap.bundle.js"></script>
<script>
    $(document).ready(function () {
        $('#employee').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 3
        })
    })
</script>
<script>
    function setValueForm(id) {
        document.getElementById("id").value = id;
    }
</script>
</body>
</html>
