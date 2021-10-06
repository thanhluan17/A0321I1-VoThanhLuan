<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 06-Oct-21
  Time: 08:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
    <style>
        fieldset {
            background-color: #eeeeee;
            width: 30%;
        }

        legend {
            background-color: gray;
            color: white;
            padding: 5px 10px;
        }

        input {
            margin: 5px;
        }
    </style>
</head>
<body>
<h1>Simple Calculator</h1>
<form action="/calculate" method="post">
    <fieldset>
        <legend>Calculator</legend>
        <label for="first">First operand:</label>
        <input type="text" id="first" name="first"><br><br>
        <label for="operator">Operator:</label>

        <select name="operator" id="operator">
            <option value="+">Addition</option>
            <option value="-">Subtraction</option>
            <option value="*">Multiplication</option>
            <option value="/">Division</option>
        </select><br><br>
        <label for="second">Second operand:</label>
        <input type="text" id="second" name="second"><br><br>
        <input type="submit" value="Calculate">
    </fieldset>
</form>
</body>
</html>
