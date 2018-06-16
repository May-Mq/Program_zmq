<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商城后台管理系统</title>
</head>
<body>
	<%
		String username = (String)session.getAttribute("username");
		try{
			if (username != null){ 
	%>
				欢迎<%= username %>使用本系统
	<%
			}
		}
		catch(Exception e){
			out.print("请输入正确的用户名和密码登录系统");
			response.sendRedirect("login");
		}
	%>
	
	<table width="100%" height="100%" border="1" cellspacing="0">
		<tr height="100">
			<th colspan="2">
				<h1>商城后台管理系统</h1>
			</th>
		</tr>

  		<tr height="100">
  			<td width="15%">
				<a href="/type_value/type_list" target="main">商品类别管理</a>
			</td>
			<td rowspan="6">
				<iframe name="main" src="loginwelcome.jsp" frameborder="no" width="100%" height="100%"></iframe>
			</td>
  		</tr>
  		
  		<tr height="100">
    		<td>
				<a href="/type_value/toTypeAdd" target="main">商品类别添加</a>
			</td>
  		</tr>
  		
		<tr height="100">
			<td>
				<a href="/goods/goodslist" target="main">商品信息管理</a>
			</td>
		</tr>
		
		<tr height="80">
			<td>
				<a href="/goods/toGoodsAdd" target="main">商品信息添加</a>
			</td>
		</tr>
		
		<tr height="80">
		    <td width="15%">
				<a href="/outlogin" >系统退出</a>
			</td>
		</tr>
  </table>
  
</body>
</html>