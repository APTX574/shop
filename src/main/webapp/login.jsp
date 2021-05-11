<%--
  Created by IntelliJ IDEA.
  User: aptx
  Date: 2021/5/9
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style type="text/css">
    h1 {
        text-align: center;
    }
    td{
        width: 100px;
    }
    table{
        align-content: center;
    }
    table {
        margin: auto;
    }
</style>






<head>
    <title>login</title>
</head>


<body>
<h1>用户登录</h1>
<br/>
<br/>
<form action="http://localhost:8080/shop/login" method="get">
    <table>
        <tbody>
        <tr>
            <td>用户名：</td>
            <td><label>
                <input type="text" name="name" value="">
            </label></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><label>
                <input type="password" name="password" value="">
            </label></td>
        </tr>
        <tr><td><a href="resister.jsp">用户注册</a></td>
        <td><button type="submit">登录</button></td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>
