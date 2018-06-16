<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商品信息管理</title>
<head>
<body>
	<center>
		<h2>商品信息</h2>
		<table width="40%" border=1>  
		<tbody>
		<tr>  
		    <td>编号</td>  
		    <td>商品名称</td> 
		    <td>价格</td>  
		    <td>商品类别</td> 
		    <td>库存数量</td>
		    <td>操作</td>
		</tr>  
		<c:forEach items="${goods}" var="data">  
		<tr>  
		    <td>${data["goodsid"]}</td>  
		    <td>${data["goodsname"]}</td> 
		    <td>${data["goodsprice"]}</td>  
		    <td>${data["goodstype"]}</td>  
		    <td>${data["goodsnum"]}</td>   
		    <td><a href="/goods/goodsUpdate/${data.goodsid}">修改</a>
		        <a href="/goods/goodsDelete/${data.goodsid}">删除</a>
		    </td>  
		</tr>
		</c:forEach>
		</tbody>
		</table>
</center>
</body>
</html>