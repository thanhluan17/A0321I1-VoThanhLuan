<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 11-Oct-21
  Time: 07:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product details</title>
</head>
<body>
<h1>Product details</h1>
<p>
    <a href="/products">Back to product list</a>
</p>
<table>
    <tr>
        <td>Id:</td>
        <td>${product.id}</td>
    </tr>
    <tr>
        <td>Name:</td>
        <td>${product.name}</td>
    </tr>
    <tr>
        <td>Price:</td>
        <td>${product.price}</td>
    </tr>
    <tr>
        <td>Description:</td>
        <td>${product.description}</td>
    </tr>
    <tr>
        <td>Producer:</td>
        <td>${product.producer}</td>
    </tr>
</table>
</body>
</html>
