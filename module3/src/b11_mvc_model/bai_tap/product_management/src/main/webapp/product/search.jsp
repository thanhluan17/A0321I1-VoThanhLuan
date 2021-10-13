<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 13-Oct-21
  Time: 02:19 PM
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
    <a href="/products">Back to customer list</a>
</p>
<form method="post">
    <label>Name product</label>
    <input type="text" name="searchStr"/><br/>
    <input type="submit" value="Tìm kiếm">
</form>
</body>
</html>
