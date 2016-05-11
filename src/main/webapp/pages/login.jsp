<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<style>
	label{
		display: inline-block;
		width:85px;
		font-weight: bold;
		margin-bottom:10px;
	}
</style>
</head>
<body>
	<form action="login.do" method="post">
		<label>用户名</label><input type="text" name="username" />
		<br/>
		<label>密码</label><input type="password" name="passwd" />
		<br/>
		<label>密保问题</label>
		<br/>我喜欢的水果:<input type="checkbox" name="fruits" value="香蕉"/>香蕉 &nbsp;
		<input type="checkbox" name="fruits" value="苹果"/>苹果 &nbsp;
		<input type="checkbox" name="fruits" value="梨"/>梨 &nbsp;
		<br/>
		<input type="button" value="提交" onclick="formSubmit();"/>
	</form>
</body>
<script>
	function formSubmit(){
		//表单校验
		
		//略
		document.forms[0].submit();
	}
</script>
</html>