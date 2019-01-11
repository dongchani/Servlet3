<%--
  Created by IntelliJ IDEA.
  User: doch
  Date: 2018/12/25
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<form action="/uploadServlet" enctype="multipart/form-data" method="post">
  <input type="file" name="file">
  <input  type="submit" value="文件上传">
</form>
  </body>
</html>
