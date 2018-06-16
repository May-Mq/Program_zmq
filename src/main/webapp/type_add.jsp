<%--
  Created by IntelliJ IDEA.
  User: ITObase101
  Date: 2018/6/15
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品类别</title>
</head>
<body>
    <center>
        <center><h2>添加商品类别</h2></center>

    <form action="/type_value/typeAdd" method="post">
        商品类别:<input type="text" name="typename"/><br>
        <input type="submit" value="类别添加">
    </form>
    </center>
</body>
</html>
