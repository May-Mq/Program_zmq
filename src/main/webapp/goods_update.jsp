<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品修改</title>
</head>
<body>
<center>
	<form action="/goods/goodssave" >
		编号:<input type="text" name="goodsid" value="${goodsEntity.goodsid}" readonly/><br>
    	商品名称:<input type="text" name="goodsname" value="${goodsEntity.goodsname}"/><br>
    	价格:<input type="text" name="goodsprice" value="${goodsEntity.goodsprice}"/><br>
    	商品类型：<input type="text" name="goodstype" value="${goodsEntity.goodstype}"/><br>
		<%--<select name="goodstype" value="${goodsEntity.goodstype}">--%>
				  	<%--<c:forEach items="${listType}" var="data">  --%>
    					<%--<option >${data}</option>--%>
    				<%--</c:forEach>--%>
				  <%--</select>--%>
    	库存数量:<input type="text" name="goodsnum" value="${goodsEntity.goodsnum}"/><br>
    	<input type="submit" value="商品修改">
	</form>
</center>
</body>
</html>