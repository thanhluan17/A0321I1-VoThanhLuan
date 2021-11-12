<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 2021-11-12
  Time: 02:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<h2>Simple Dictionary</h2>
<form action="/search">
    <label>English</label>
    <input type="text" name="word">
    <input type="submit" value="Translate">
    <c:if test="${vietnamese != null}">
        <h3>Tiếng Việt: ${vietnamese}</h3>
    </c:if>
</form>
</body>
</html>
