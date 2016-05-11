<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Application</title>
</head>
<body>
	<%
		String realPath = application.getRealPath("/");
	%>
	系统真实部署路径:<%=realPath %><br/>
	<%
		String contextPath = application.getContextPath();
	%>
	部署虚拟目录:<%=contextPath %>
</body>
</html>