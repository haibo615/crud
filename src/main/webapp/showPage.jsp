<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2023/5/16
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>showPage</title>
    <script src="js/vue.js"></script>
    <script src="js/axios.js"></script>
</head>
<body>
<div id="app">
<%--    <div id="display" style="display: none">--%>
<%--        <input type="text" :value="<%=request.getParameter("bookid")%>">--%>
<%--    </div>--%>
    查询结果：<br>
    书籍id：{{books.bookid}}<br>
    书名：{{books.title}}<br>
    作者：{{books.author}}<br>
    出版社：{{books.publisher}}<br>
    价格：{{books.price}}<br>
</div>
</body>
<script>
    Vue.config.productionTip = false;

    const vm = new Vue({
        el:'#app',
        data:{
            books:[],
            bookid:<%=request.getParameter("bookid")%>
        },
        mounted(){
            axios.post("${pageContext.request.contextPath}/query?bookid="+this.bookid).then(result=>{
                console.log(result.data);
                this.books=result.data;
                if(this.books==null){
                    window.location.href="error.jsp"
                }
            })
        }
    })
</script>
</html>
