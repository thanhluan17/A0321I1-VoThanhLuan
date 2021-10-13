<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 11-Oct-21
  Time: 08:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleting product</title>
</head>
<body>
<h1>Delete customer</h1>
<p>
    <a href="/products">Back to product list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Product information</legend>
        <table>
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
            <tr>
                <td><input type="submit" value="Delete product"></td>
                <td><a href="/products">Back to product list</a></td>
            </tr>
        </table>
    </fieldset>
</body>
</html>
