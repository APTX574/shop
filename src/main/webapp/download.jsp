<%--
  Created by IntelliJ IDEA.
  User: aptx
  Date: 2021/5/14
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>下载</title>
</head>
<body>
<form method="post" action="http://localhost:8080/shop/download">
    <label>填写文件名
        <input type="text" name="fileName">

    </label>
    <button type="submit">下载</button>
</form>



</body>
</html>
