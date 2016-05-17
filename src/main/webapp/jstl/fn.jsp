<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL 函数标签库</title>
</head>
<body>
	<% pageContext.setAttribute("str","hello,MLDN!"); %>
	${fn:contains(str,"MLDN") },${fn:containsIgnoreCase(str,"mldn") },${fn:startsWith(str,"he") },${fn:endsWith(str,"mldn") },${fn:toUpperCase(str) },
	${fn:toLowerCase(str) },${fn:replace(str,"o","x") },${fn:indexOf(str,"o")},${fn:substring(str,1,5) }
	<% pageContext.setAttribute("str","hello,<<MLDN>>!"); %>
	${fn:escapeXml(str) }|
	${fn:substringBefore(str,",") }|${fn:substringAfter(str,",") }|${fn:split(str,",")[0] }
</body>  
</html>