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
    <title>Create customer</title>
    <link rel="stylesheet" href="/asset/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/asset/datatables/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="/asset/css/home_css.css">
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
            <hr>
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
    <div class="row bg-white p-lg-5">
        <div class="col-lg-12">
            <h3 class="text-center">Add new customer</h3>
            <form action="/customer?action=create" method="post">
                <div class="form-group">
                    <label for="cusType">Customer type</label>
                    <select class="form-control" id="cusType" name="type" required>
                        <c:forEach var="customerType" items="${customerTypes}">
                            <c:choose>
                                <c:when test="${customerType.id == customer.typeId}">
                                    <option selected value="${customerType.id}">${customerType.name}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${customerType.id}">${customerType.name}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label for="name">Name</label>
                    <input type="text" class="form-control" id="name" name="name" value="${customer.name}"
                           required>
                </div>

                <div class="form-group">
                    <label for="birthday">Birthday</label>
                    <input type="date" class="form-control" id="birthday" name="birthday"
                           value="${customer.birthday}" required>
                    <c:if test="${errBirthday != null}">
                        <p class="text-danger">${errBirthday}</p>
                    </c:if>
                </div>

                <div class="form-group">
                    <label for="birthday">Gender</label>
                    <select class="form-control" id="gender" name="gender" required>
                        <option ${customer.gender ? 'selected':''} value="true">Male</option>
                        <option ${customer.gender ? '':'selected'} value="false">Female</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="idCard">Card ID</label>
                    <input type="text" class="form-control" id="idCard" name="idCard" value="${customer.cardID}"
                           required minlength="9"
                           maxlength="15">
                    <c:if test="${errIdCard != null}">
                        <p class="text-danger">${errIdCard}</p>
                    </c:if>
                </div>
                <div class="form-group">
                    <label for="phone">Phone</label>
                    <input type="text" class="form-control" id="phone" name="phone" value="${customer.phone}"
                           required minlength="10">
                    <c:if test="${errPhone != null}">
                        <p class="text-danger">${errPhone}</p>
                    </c:if>
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="text" class="form-control" id="email" name="email" value="${customer.email}"
                           required>
                    <c:if test="${errEmail != null}">
                        <p class="text-danger">${errEmail}</p>
                    </c:if>
                </div>
                <div class="form-group">
                    <label for="address">Address</label>
                    <input type="text" class="form-control" id="address" name="address"
                           value="${customer.address}" required>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
