<%--
  Created by IntelliJ IDEA.
  User: hongeunlee
  Date: 2022/12/27
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/calc/makeResult" method="post">
<%--         action, method 속성추가 --%>
        <input type="number" name="num1">
        <input type="number" name="num2">
        <button type="submit"> SEND</button>
    </form>
</body>
</html>
