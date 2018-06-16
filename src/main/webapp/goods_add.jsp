<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增商品</title>
	<style type="text/css">
		.addGoodsLook{
			position: relative;
			margin-left: 450px;
		}
		#button{
			position: relative;
			margin-left: 110px;
		}
	</style>
</head>

<body>
	<center><h2>添加商品信息</h2></center>
	<form action="/goods/goodsAdd" class="addGoodsLook">
		商品名称:<input type="text" name="goodsname"/><br>
		价格:<input type="text" name="goodsprice"/><br>
		商品类型：<input type="text" name="goodstype"/><br>
		<%--<select name="goodstype">--%>
				  	<%--<c:forEach items="${listType}" var="data">--%>
    					<%--<option >${data}</option>--%>
    				<%--</c:forEach>--%>
				  <%--</select><br>--%>
    	库存量:<input type="text" name="goodsnum"/><br>
    	<input type="submit" value="商品添加" id="button">
	</form>
</body>
</html>