<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 12-Oct-21
  Time: 10:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Product</h1>
<p>
    <a href="/products?action=create">Create new product</a><br/>
    <a href="/products?action=search">Search product</a>
</p>
<table border="1">
    <tr>
        <td>Name</td>
        <td>Price</td>
        <td>Description</td>
        <td>Producer</td>
        <td>View</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach var="product" items="${productList}">
        <tr>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.description}</td>
            <td>${product.producer}</td>
            <td><a href="/products?action=view&id=${product.getId()}">View</a></td>
            <td><a href="/products?action=edit&id=${product.getId()}">Edit</a></td>
            <td><a href="/products?action=delete&id=${product.getId()}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
