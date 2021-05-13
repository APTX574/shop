<%--
  Created by IntelliJ IDEA.
  User: aptx
  Date: 2021/5/9
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>resister</title>
</head>
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
<script type="text/javascript" src="WEB-INF/lib/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
    $(function () {

        let password = $("#password").val();
        let password2 = $("#password2").val();
        $("password2").blur(function (){
            if (password !== password2) {
                $("#tx").text("密码不一致请确认密码");
            }
        })
    });

</script>
<body>

<h1>用户注册</h1>
<br/>
<br/>
<form action="${pageContext.request.contextPath}/resister" method="post" enctype="multipart/form-data">

    <table>
        <tbody>
        <tr>
            <td>用户名：</td>
            <td><label>
                <input type="text" name="name" id="name">
            </label></td>
        </tr><tr>
            <td>密码：</td>
            <td><label>
                <input type="password" name="password" id="password">
            </label></td>
        </tr><tr>
            <td>确认密码：</td>
            <td><label>
                <input type="password" name="password" id="password2">
            </label></td>
            <a id="tx"></a>

        </tr><tr>
            <td>性别:</td>
            <td><label>
                <input type="radio" name="sex" value="男">男
                <input type="radio" name="sex" value="女">女
            </label></td>
        </tr><tr>
            <td>头像</td>
            <td><label>
                <input type="file" name="tx">
            </label></td>
        </tr>
        <tr>
        <td><button type="submit">注册</button></td>
        </tr>


        </tbody>
    </table>
    </form>
</body>
</html>
