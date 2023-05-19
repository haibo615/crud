<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2023/5/17
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login">
    用户名：<input type="text" name="name">
    密码：<input type="password" name="pswd">
    <button>登录</button>
</form>
</body>
</html>
