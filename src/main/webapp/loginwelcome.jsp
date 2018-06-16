<%--
  Created by IntelliJ IDEA.
  User: ITObase101
  Date: 2018/6/14
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎登陆本系统</title>
</head>
<body>
    <%
		String username = (String)session.getAttribute("username");
	%>
    <h1><center>欢迎<%= username %>使用本系统</center></h1>

</body>
</html>