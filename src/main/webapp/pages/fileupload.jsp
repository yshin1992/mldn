<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FileUpload组件</title>
<style type="text/css">
	label{
		display: inline-block;
		margin-bottom:10px;
		width:85px;
	}
</style>
<script type="text/javascript" src="js/image-preview.js"></script>
</head>
<body>
	<form action="commonUpload.do" method="post" enctype="multipart/form-data">
		<label>用户名</label><input type="text" name="username" /><br/>
		<label>头像</label><input type="file" name="pic" onchange="PreviewImage(this,'userPic','showPicDiv')"><br/>
		<label>头像预览</label><div id="showPicDiv"><img style="width:160px; height:170px;border:solid 1px #d2e2e2;" id="userPic"/></div>
		<br/>
		<input type="submit" value="提交"/>
	</form>
</body>
</html>