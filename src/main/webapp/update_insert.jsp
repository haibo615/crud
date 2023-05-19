<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2023/5/16
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%--
update:传入所有数据，后台根据id找到数据进行修改
insert：传入所有数据，后台直接插入
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UpdateAndInsert</title>
    <script src="js/vue.js"></script>
</head>
<body>
<div id="app">
    <form :action="actions" method="post">
        书籍id：<input type="text" name="bookid"><br>
        书名：<input type="text" name="title"><br>
        作者：<input type="text" name="author"><br>
        出版社：<input type="text" name="publisher"><br>
        价格：<input type="text" name="price"><br>
        <button @click="insert">插入</button>
        <button @click="update">修改</button>
        <button type="reset">重置</button>
    </form>
</div>
</body>
<script>
    Vue.config.productionTip = false;

    const vm = new Vue({
        el:'#app',
        data:{
            actions:""
        },
        methods:{
            insert(){
                this.actions="${pageContext.request.contextPath}/insert"
            },
            update(){
                this.actions="${pageContext.request.contextPath}/update"
            }
        }
    })
</script>
</html>
