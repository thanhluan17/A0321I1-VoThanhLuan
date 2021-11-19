<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 2021-11-19
  Time: 06:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Setting</title>
</head>
<body>
<form:form action="/info" method="post" modelAttribute="config">
    <table>
        <tr>
            <td>
                <form:label path="language">Languages:</form:label>
            </td>
            <td>
                <form:select path="language">
                    <form:options items="${languageList}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="pageSize">Page size:</form:label>
            </td>
            <td>
                <span>Show </span>
                <form:select path="pageSize">
                    <form:options items="${pageSizeList}"/>
                </form:select>
                <span> emails per page</span>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="spamFilter">Spam filter:</form:label>
            </td>
            <td>
                <form:checkbox path="spamFilter"/>
                <span>enable spam filter</span>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="signature">Signature</form:label>
            </td>
            <td>
                <form:textarea path="signature"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="Update">
                <a href="#">Cancel</a>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
