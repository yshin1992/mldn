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
<label>用户名</label>${param.username }
<label>密码</label>${param.passwd }
<label>密保结果</label>${paramValues.fruits }
</body> 
</html>