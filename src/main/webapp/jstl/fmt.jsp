<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>国际化标签库fmt</title>
</head>
<body>
	fmt:setLocale标签 设置区域 value="java.util.Locale类" variant="浏览器"<br/>
	<jsp:useBean id="now" class="java.util.Date" />
	<fmt:setLocale value="en_US"/>
	EN_US下时间表示:<fmt:formatDate value="${now }"/>
	<br/>
	<fmt:setLocale value="zh_CN"/>
	ZH_CN下时间表示:<fmt:formatDate value="${now }"/>
	<br/>fmt:requestEncoding设置字符集相当于request.setCharacterEncoding();
	<fmt:requestEncoding value="UTF-8"/>
	<br/>
	fmt:bundle 标记指定的软件包中，所有的&lt;fmt:message&gt;标签之间发生的边界&lt;fmt:bundle&gt;&lt;/fmt:bundle&gt;标记.<br/>
	basename:指定是要加载的资源包的基本名称,prefix=每个键名预先准备值的&lt;fmt:message&gt;子标记<br/>
	<fmt:bundle basename="message_en_US">
		<fmt:message key="error.tip"/><br/><fmt:message key="error.color"/><br/>
	</fmt:bundle>
	<fmt:bundle basename="message_zh_CN" prefix="error.">
		<fmt:message key="tip"/><br/><fmt:message key="color"/><br/>
	</fmt:bundle>
	
	fmt:message key="资源文件指定的key" bundle="资源文件名称" var="存储内容的属性名称<br/>
	fmt:param value="设置占位符内容<br/>
	fmt:setBundle basename="资源文件名称" var="存储内容的属性名称 scope
	<hr/>
	<fmt:setBundle basename="message" var="enUs"/>
	<fmt:message bundle="${enUs }" key="hello">
		<fmt:param value="Jane"/>
	</fmt:message>
	
</body>
</html>