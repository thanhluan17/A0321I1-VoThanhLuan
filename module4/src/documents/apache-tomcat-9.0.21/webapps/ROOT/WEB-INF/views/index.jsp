<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 2021-11-12
  Time: 07:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/calculate" method="post">
    <input type="text" name="numA">
    <input type="text" name="numB"><br><br>
    <button type="submit" name="operator" value="add">Addition (+)</button>
    <button type="submit" name="operator" value="sub">Subtraction (-)</button>
    <button type="submit" name="operator" value="mul">Multiplication (x)</button>
    <button type="submit" name="operator" value="div">Division (/)</button>
</form>
<p>${result}</p>
</body>
</html>
