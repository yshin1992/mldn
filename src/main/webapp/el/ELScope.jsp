<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL表达式的访问范围</title>
</head>
<body>
	<%
		pageContext.setAttribute("info","pageContext Scope");
		request.setAttribute("info", "request Scope");
		session.setAttribute("info", "session Scope");
		application.setAttribute("info", "ServletContext Scope");
	%>
	page范围:${pageScope.info }<br/>
	request范围:${requestScope.info }<br/>
	session范围:${sessionScope.info }<br/>
	application范围:${applicationScope.info }<br/>
	默认范围:${info }<br/>
	当前sessionId:${pageContext.session.id }
</body>
</html>