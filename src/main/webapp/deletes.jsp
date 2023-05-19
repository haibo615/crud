<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2023/5/16
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deletes</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/delete" method="post">
    请输入要删除书籍的书籍号：<input type="text" name="bookid">
    <button>提交</button>
</form>
</body>
</html>
