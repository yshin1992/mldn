<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="pe" uri="http://www.ysh.org/hello.tld" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>使用自定义标签输出</title>
</head>
<body>
	<pe:hello/>
	<%
		Date date = new Date();
		pageContext.setAttribute("now",date);
	%>
	<br/>输出日期:<pe:date formatDate="${now }" pattern="yyyy-MM-dd HH:mm:ss"/>
	<pe:attr attributeName="now" scope="page">
		<br/>page范围内有属性:<pe:date formatDate="${now }" pattern="yyyy-MM-dd"/>
	</pe:attr>
	<pe:attr attributeName="now" scope="request">
		<br/>request范围内有属性:<pe:date formatDate="${now }" pattern="yyyy-MM-dd"/>
	</pe:attr>
	
	<%
		List<String> strList = new ArrayList<String>();
		strList.add("Java EE");
		strList.add("JSP 编程");
		strList.add("Java Core");
		pageContext.setAttribute("bookList",strList);
	%>
	<pe:listIter list="${bookList }" id="bookName">
			<br/>${bookName }
	</pe:listIter>
	<hr/>
	<pe:bodyListIter list="${bookList }" id="bookName2">
		<br/><%=bookName2 %>
	</pe:bodyListIter>
</body>
</html>