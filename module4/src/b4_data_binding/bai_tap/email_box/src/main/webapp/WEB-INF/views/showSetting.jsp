<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 2021-11-19
  Time: 07:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Setting</title>
</head>
<body>
<form:form action="/change" method="post" modelAttribute="config">
    <form:label path="language">Languages: ${config.language}</form:label><br/>
    <form:hidden path="language" value="${config.language}"/><br/>
    <form:label path="pageSize">Page size: ${config.pageSize}</form:label><br/>
    <form:hidden path="pageSize" value="${config.pageSize}"/><br/>
    <form:label path="spamFilter">Spam filter: ${config.spamFilter}</form:label><br/>
    <form:hidden path="spamFilter" value="${config.spamFilter}"/><br/>
    <form:label path="signature">Signature: ${config.signature}</form:label><br/>
    <form:hidden path="signature" value="${config.signature}"/><br/>
    <input type="submit" value="Change">
</form:form>
</body>
</html>
