<%@page import="java.io.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*;"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL C标签</title>
</head>
<body>
	<c:set var="bookName" value="Java EE" scope="request"/>
	<c:out value="${bookName }" />
	<br/>
	c:out标签 value,default,escapeXml(是否转换字符串，例如将'>'转成'&gt;')
	属性不存在:<c:out value="${ref }" default="没有内容"/><br/>
	属性不存在:<c:out value="${ref }">没有内容</c:out>
	<br/>
	<c:set var="bookPrice">79.0元</c:set>
	<c:out value="${bookPrice }">0.0元</c:out>
	
	<jsp:useBean id="loginUser" class="org.ysh.domain.LoginUser" scope="page"/>
	<br/>c:set表达式中var,scope属性是不支持EL表达式的<br/>
	<c:set value="LiXiuLei" target="${loginUser }" property="username"/>
	<c:out value="${loginUser.username }"/>
	<br/>
	c:remove标签有两个属性var,scope
	<br/>
	删除loginUser:<c:remove var="loginUser"/><c:out value="${loginUser.username }" />
	<br/>删除bookName:<c:remove var="bookName"/><c:out value="${bookName }" />
	<br/>c:catch标签 属性var保存发生异常的信息(支持scriptless,不支持JSP声明语句)
	<c:catch var="errorMsg">
		<%= 100/0 %>
	</c:catch>
	<br/><c:out value="${errorMsg }"/>
	<br/>c:if判断标签 属性test(判断的表达式),var(表达式的结果),scope(结果保存的范围)
	<c:if test="${empty loginUser }" var="isNullUser" scope="page">
		<br/>loginUser为空 --> ${isNullUser }
	</c:if>
	<br/>c:choose、c:when、c:otherwise
	<c:set var="bookName">Java Core</c:set>
	<c:choose>
		<c:when test="${not empty bookName }">
			<c:choose>
			<c:when test="${bookName eq 'Java EE' }">
				<br/>书名:&lt;&lt;Java EE&gt;&gt;
			</c:when>
			<c:otherwise>
				<br/>书名:&lt;&lt;${bookName }&gt;&gt;
			</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<br/>当前页面中没有图书
		</c:otherwise>
	</c:choose>
	<br/>c:forEach标签 var="每一个对象的属性名称" items="集合" varStatus="存放当前对象的成员信息" start="开始的位置" end="结束位置"
	 step="增长的步长"
	<br/>
	<%
		List<String> books = new ArrayList<String>();
		books.add("Java SE");
		books.add("Java Core");
		books.add("Java EE");
		books.add("EJB");
		books.add("Spring");
		pageContext.setAttribute("books",books);
	%>
	<c:forEach var="book" items="${books }" varStatus="index">
		<br/>${index.index }、${book }(${index.count }、${index.first }、${index.last })
	</c:forEach>
	<hr/>
	<%
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("Java SE", 103);
		map.put("Java Core",98);
		pageContext.setAttribute("bookPrice",map);
	%>
	<c:forEach var="member" items="${bookPrice }">
		<br/>${member.key } --> ${member.value }
	</c:forEach>
	<br/>c:forTokens items="输出的字符串" delims="字符串分隔符" var="存放每一个字符串变量"
	varStatus="存放当前对象的相关信息" begin end step
	<%
		String strArr = "Spring,Hibernate,Mybatis,Struts2";
		pageContext.setAttribute("strArr",strArr);
	%>
	<c:forTokens var="framework" items="${strArr }" delims="," varStatus="status">
		<br/>${status.index }、${framework }(${status.count }、${status.first }、${status.last })
	</c:forTokens>
	<br/>c:import标签 url="包含地址的url" context="上下文路径(如果要访问同一个web容器下的其他资源，必须以/开头)" var="保存内容的属性名称" scope charEncoding="字符编码"
	varReader="以Reader方式进行读取"<br/>
	c:param name="" value="" <br/>
	<c:import url="http://localhost:8083/mldn" charEncoding="UTF-8"></c:import>
	<c:import url="/jstl/cparam.jsp" context="/mldn">
		<c:param name="username" value="root"/>
		<c:param name="passwd" value="yshin1992"/>
	</c:import>
	<hr/>
	<c:import var="include"  url="/jstl/cparam.jsp" context="/mldn">
		<c:param name="username" value="root"/>
		<c:param name="passwd" value="yshin1992"/>
	</c:import>
	${include }
	<hr/>
	<c:import varReader="reader"  url="/jstl/cparam.jsp" context="/mldn">
		<c:set value="${reader }" var="stringReader" />
		<%
		StringReader reader = (StringReader)pageContext.getAttribute("stringReader");
		if(null != reader)
		{
			char[] chars = new char[1024];
			int len=0;
			while((len=reader.read(chars)) != -1){
				out.print(new String(chars,0,len));
			}
		}
		%>
	</c:import>
	<hr/>
	c:url 直接产生一个URL地址 value="操作的url" context="上下文路径" var="保存的属性名称" scope
	<br/>
	<c:url var="newpage" value="/jstl/cparam.jsp" context="/mldn">
		<c:param name="username">root</c:param>
		<c:param name="passwd">123456</c:param>
	</c:url>
	<a href="${newpage }" >跳转到新页面</a>
	
	<hr/>
	c:redirect标签 相当于response.sendRedirect(url)客户端跳转,url="跳转的地址" context="上下文路径"
	<br/>
	<c:redirect url="/jstl/cparam.jsp" context="/mldn">
		<c:param name="username">root</c:param>
		<c:param name="passwd">123456</c:param>
	</c:redirect>
</body>
</html>