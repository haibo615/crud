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
    <title>Register</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/register">
    姓名：<input type="text" name="name">
    密码：<input type="password" name="pswd">
    <button>注册</button>
</form>
</body>
</html>
