<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>结果页</title>
<style>
	span#seconds{
		color:blue;
	}
</style>
</head>
<body onload="onstart()">
	<%=request.getParameter("username") %><br/>
	<%
		String[] fruits = request.getParameterValues("fruits");
		if(null != fruits && fruits.length > 0)
		{
			for(String fruit : fruits)
			{
	%>
				<%=fruit %>&nbsp;
	<%
			}
		}
	%>
	<h3>Header头信息</h3>
	<%
		Enumeration params = request.getHeaderNames();
		while(params.hasMoreElements())
		{
			String param =(String) params.nextElement();
	%>
		<%=param %> --> <%=request.getHeader(param) %><br/>
	<%
		}
	%>
		<span id="seconds">5</span>秒后跳转到登录页!
	<% 
		response.setHeader("refresh", "5;URL=login.do");
	%>
</body>
<script>
	var countDown = (function(){
		var counter = 5;
		return function(){ return --counter;}
	}());
	function onstart(){
		setInterval(function(){
			document.getElementById("seconds").innerHTML = countDown();
		}, 1000);
		
	}
</script>
</html>