<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL中运算符的使用</title>
</head>
<body>
	<%!
		int a = 10;
		int b = 3;
	%>
	<% 
		pageContext.setAttribute("a",a);
		pageContext.setAttribute("b",b);
	%>
	${a*b }<br/>${a+b }<br/>${a/b } or ${a div b }<br/>${a-b }<br/>${a mod b } or ${a % b }
</body>
</html>