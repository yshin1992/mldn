<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL XML解析标签</title>
</head>
<body>
	x:parse标签进行XML解析的操作，doc="XML文件内容" var="保存名称" scope varDom="DOM解析后的XML对象" 
	scopeDom="varDom范围" systemId="文件的URI"
	<hr/>
	x:out标签 输出XML文件的内容 select="XPath路径" escapeXml="true | false"<br/>
	<c:import url="/jstl/books.xml" context="/mldn" var="books"/>
	<x:parse doc="${books }" var="bookContent" scope="page" />
		书名:<x:forEach select="$bookContent/Books/Book" var="book">
				<x:out  select="$book/name"/>(<x:out select="$book/name/@id"/>) |
			</x:forEach>
	<hr/>
	x:set标签 x:set select="XPath路径" var scope<br/>
	<x:set var="bookName" select="$bookContent/Books/Book/name"/>
	<x:forEach select="$bookName" var="name">
		<x:out select="$name" /> | 
	</x:forEach>
	<hr/>
	x:if 标签 select="XPath路径" var="存放判断结果" scope<br/>
	<x:forEach select="$bookContent/Books/Book" var="book">
		<x:if select="$book/name/@price<'100'">
			<x:out  select="$book/name"/>(<x:out select="$book/name/@id"/>) 
		</x:if>
	</x:forEach>
	<hr/>
	x:choose x:when x:otherwise 多条件选择<br/>
	<x:forEach select="$bookContent/Books/Book" var="book">
		<x:choose>
		<x:when select="$book/name/@price<'100'">
			<x:out  select="$book/name"/>(<x:out select="$book/name/@id"/>) 
		</x:when>
		<x:otherwise>
			&nbsp;<x:out  select="$book/name"/>(<x:out select="$book/name/@price"/>) 
		</x:otherwise>
		</x:choose>
	</x:forEach>
</body>
</html>