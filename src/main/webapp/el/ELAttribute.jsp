<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
label{
	width:85px;
	display: inline-block;
	margin-bottom:15px;
}
</style>
<title>EL内置表达式对象的调用</title>
</head>
<body>
	<form action="${pageContext.servletContext.contextPath }/el/ELLoginResult.jsp" method="post">
		<label>用户名</label><input type="text" name="username"/><br/>
		<label>密码</label><input type="password" name="passwd" /><br/>
		<label>密保问题</label>
		<br/>我喜欢的水果:<input type="checkbox" name="fruits" value="香蕉"/>香蕉 &nbsp;
		<input type="checkbox" name="fruits" value="苹果"/>苹果 &nbsp;
		<input type="checkbox" name="fruits" value="梨"/>梨 &nbsp;
		<br/>
		<input type="submit" value="提交" />
	</form>
	<br/>
	
</body> 
</html>