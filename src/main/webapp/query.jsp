<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2023/5/16
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Query</title>
</head>
<body>
<form action="showPage.jsp" method="post">
    请输入书号：<input type="text" name="bookid" v-model="bookid">
    <button @click="query">查询</button>
</form>
</body>
</html>
