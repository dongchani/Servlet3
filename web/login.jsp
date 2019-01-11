<%--
  Created by IntelliJ IDEA.
  User: doch
  Date: 2019/1/7
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/j_security_check" method="post">
    <input type="text" name="j_username"/></br>
    <input type="password" name="j_password"/></br>
    <input type="submit" value="认证"/>
</form>
</body>
</html>
