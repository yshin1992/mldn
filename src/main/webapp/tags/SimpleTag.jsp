<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="pe" uri="http://www.ysh.org/simple.tld" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>使用自定义标签输出</title>
</head>
<body>
	<%
		Date date = new Date();
		pageContext.setAttribute("now",date);
	%>
	<br/>输出日期:<pe:simpleDate formatDate="${now }" pattern="yyyy-MM-dd HH:mm:ss"/>
	
	<%
		List<String> strList = new ArrayList<String>();
		strList.add("Java EE");
		strList.add("JSP 编程");
		strList.add("Java Core");
		pageContext.setAttribute("bookList",strList);
	%>
	<pe:simpleListIter list="${bookList }" id="bookName">
		<br/>${bookName }
	</pe:simpleListIter>
	
	<pe:dynamicAttrs bookname="javaee开发入门宝典" bookprice="190.00" booktime="2014年12月10号">
		<br/>${key } --> ${value }
	</pe:dynamicAttrs>
</body>
</html>