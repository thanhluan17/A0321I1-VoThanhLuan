<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 03-Oct-21
  Time: 11:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Discount</title>
    <style>
        input{
            margin: 5px;
        }
    </style>
</head>
<body>
<h2>Product discount calculate</h2>
<form action="/display-discount" method="post">
    <label for="productName">Tên sản phẩm</label>
    <input type="text" name="productName" id="productName"/><br/>
    <label for="productPrice">Giá sản phẩm</label>
    <input type="number" name="productPrice" id="productPrice"/><br/>
    <label for="percent">Tỉ lệ chiết khấu</label>
    <input type="number" name="percent" id="percent"/><br/>
    <input type="submit" value="Calculate discount"/>
</form>
</body>
</html>
