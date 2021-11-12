<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 2021-11-12
  Time: 06:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/save" method="post">
    <input type="checkbox" name="condiment" id="lettuce" value="lettuce">
    <label for="lettuce">Lettuce</label>
    <input type="checkbox" name="condiment" id="tomato" value="tomato">
    <label for="tomato">Tomato</label>
    <input type="checkbox" name="condiment" id="mustard" value="mustard">
    <label for="mustard">Mustard</label>
    <input type="checkbox" name="condiment" id="sprouts" value="sprouts">
    <label for="sprouts">Sprouts</label><br>
    <input type="submit" value="Save">
</form>
<p>${condiment}</p>
</body>
</html>
