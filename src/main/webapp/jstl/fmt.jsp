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
	<hr/>
	<fmt:requestEncoding value="UTF-8"/>
	<hr/>
	fmt:bundle 标记指定的软件包中，所有的&lt;fmt:message&gt;标签之间发生的边界&lt;fmt:bundle&gt;&lt;/fmt:bundle&gt;标记.<br/>
	basename:指定是要加载的资源包的基本名称,prefix=每个键名预先准备值的&lt;fmt:message&gt;子标记<br/>
	<fmt:bundle basename="message_en_US">
		<fmt:message key="error.tip"/><br/><fmt:message key="error.color"/><br/>
	</fmt:bundle>
	<fmt:bundle basename="message_zh_CN" prefix="error.">
		<fmt:message key="tip"/><br/><fmt:message key="color"/><br/>
	</fmt:bundle>
	<hr/>
	fmt:message key="资源文件指定的key" bundle="资源文件名称" var="存储内容的属性名称<br/>
	fmt:param value="设置占位符内容<br/>
	fmt:setBundle basename="资源文件名称" var="存储内容的属性名称 scope
	<hr/>
	<fmt:setBundle basename="message" var="enUs"/>
	<fmt:message bundle="${enUs }" key="hello">
		<fmt:param value="Jane"/>
	</fmt:message>
	
	<hr/>
	fmt:formatNumber标签 value="数字" type="number|currency|percent" pattern="格式化格式" currencyCode="货币的ISO代码"
	<br/>groupingUsed="true|false是否在数字中加," maxIntegerDidits="整数位显示的最大长度" minIntegerDigits <br/>
	maxFractionDigits="小数位最大显示长度" minFractionDigits var scope<br/>
	<fmt:formatNumber type="currency">134.52</fmt:formatNumber>
	&nbsp;<fmt:formatNumber type="currency" groupingUsed="true">1234.52</fmt:formatNumber>
	&nbsp;<fmt:formatNumber maxIntegerDigits="4" minFractionDigits="2">21000</fmt:formatNumber>
	&nbsp;<fmt:formatNumber maxFractionDigits="2" currencySymbol="$" type="currency">1113.44333</fmt:formatNumber>
	&nbsp;<fmt:formatNumber pattern="#,###,###.###">132.09</fmt:formatNumber>
	<hr/>
	fmt:parseNumber标签 value格式化好的数字 type="number|currency|percent" pattern var scope integerOnly
	<br/>parseLocale="区域编码"
	<br/>反格式化数字:<fmt:parseNumber pattern="##.##E0" value="222.13E2" type="number"></fmt:parseNumber>
	&nbsp;<fmt:parseNumber value="13,231.00" integerOnly="true"/>
	<hr/>
	fmt:formatDate格式化日期标签 value="要格式化的日期时间" type="指定格式化的形式，如日期 、时间、日期时间"
	<br/>pattern dateStyle=设置日期的显示格式(参见java.text.DateFormat常量) timeStyle="设置时间的显示格式" timeZone="设置时区" var scope
	<% pageContext.setAttribute("now",new java.util.Date()); %>
	日期格式化 ：<fmt:formatDate value="${now }" type="both" dateStyle="short" timeStyle="full"/> 
	&nbsp;<fmt:formatDate value="${now }" type="both" pattern="yyyy年MM月dd日 HH时mm分ss秒"/>
	<hr/>
	fmt:parseDate反日期格式化 将一个日期对象变换为字符 value="date" type="time|date|both" dateStyle="default|full|long|medium|short"
	<br/>timeStyle timeZone var scope
	<br/>
	<fmt:parseDate pattern="yyyy-MM-dd HH:mm:ss">2016-05-17 10:39:30</fmt:parseDate>
	<hr/>
	fmt:setTimeZone设置时区 value="设置的时区,默认GMT|CCT|HST" var scope
	<br/>
	<fmt:setTimeZone value="CCT"/>
	<fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/>
</body>
</html>