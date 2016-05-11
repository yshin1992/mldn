<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Smartupload上传</title>
<style>
label{
	width:85px;
	margin-bottom:10px;
	display: inline-block;
}
</style>
</head>
<body>
<form action="upload.do" method="post" enctype="multipart/form-data">
	<label>用户名</label><input type="text" name="username" /><br/>
	请选择文件:<input type="file" name="pic"/>
	<br/>
	<input type="submit" value="上传"/>	
</form>
</body>
</html>