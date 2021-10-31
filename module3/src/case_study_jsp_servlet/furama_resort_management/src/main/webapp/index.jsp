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
    <title>Home page</title>
    <link rel="stylesheet" href="/asset/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/asset/datatables/css/dataTables.bootstrap4.min.css">
<%--    <link rel="stylesheet" href="/asset/css/home_css.css">--%>
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
                    <form class="form-inline my-2 my-lg-0">
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Search</button>
                    </form>
                </div>
            </nav>
        </div>
    </div>
</div>
<div class="container-fluid">
    <div class="row bg-white">
        <div class="col-lg-12"></div>
    </div>
</div>
</body>
</html>
