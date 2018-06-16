<%--
  Created by IntelliJ IDEA.
  User: ITObase101
  Date: 2018/6/15
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>商品类别管理</title>
</head>
<body>
<center>
    <h2>商品类别</h2>
    <table width="30%" border=1>
        <tbody>
        <tr>
            <td>编号</td>
            <td>类别</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${type}" var="data">
            <tr>
                <td>${data.typeid}</td>
                <td>${data.typename}</td>
                <td><a href="/type_value/typeUpdate/${data.typename}">修改</a>
                    <a href="/type_value/typeDelete/${data.typeid}">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</center>
</body>
</html>
