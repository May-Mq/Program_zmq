<%--
  Created by IntelliJ IDEA.
  User: ITObase101
  Date: 2018/6/15
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>类别修改</title>
</head>
<body>
<center>
    <form action="/type_value/save" method="post">
        编号:<input type="text" name="typeid" value="${typeEntity.typeid}" readonly/><br>
        商品类型:<input type="text" name="typename" value="${typeEntity.typename}"/><br>
        <input type="submit" value="类型修改">
    </form>
</center>
</body>
</html>
