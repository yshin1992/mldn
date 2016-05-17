<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajax方法获取所有的故障码</title>
<script type="text/javascript" src="../js/ajax.js"></script>
<script type="text/javascript">
function getText(){
	document.getElementById("faultInfo").innerHTML = "故障正在加载中 ...";
	var xhr = getXMLHttpRequest();
	xhr.open("POST","/mldn/restful/fault/list");
	xhr.onreadystatechange=function(){
		if(xhr.readyState == 4){
			if(xhr.status == 200){
				document.getElementById("faultInfo").innerHTML="";
				var jsonData = xhr.responseText;
				var arr = eval(jsonData.substring(jsonData.indexOf(":")+1,jsonData.length-1));
				var table = document.createElement("table");
				table.setAttribute("border",1);
				var titleRow = table.insertRow();
				var td1 = titleRow.insertCell();
				td1.innerHTML="ID";
				var td2 = titleRow.insertCell();
				td2.innerHTML="车辆ID";
				var td3 = titleRow.insertCell();
				td3.innerHTML="故障码";
				var td4 = titleRow.insertCell();
				td4.innerHTML="开始时间";
				var td5 = titleRow.insertCell();
				td5.innerHTML="结束时间";
				
				for(var i=0;i<arr.length;i++){
					var titleRow = table.insertRow();
					var td1 = titleRow.insertCell();
					td1.innerHTML=arr[i].id;
					var td2 = titleRow.insertCell();
					td2.innerHTML=arr[i].machineryId;
					var td3 = titleRow.insertCell();
					td3.innerHTML=arr[i].faultCode;
					var td4 = titleRow.insertCell();
					td4.innerHTML=arr[i].beginTime;
					var td5 = titleRow.insertCell();
					td5.innerHTML=arr[i].endTime==undefined?"":arr[i].endTime;
				}
				
				document.getElementById("faultInfo").appendChild(table);
			}
		}
	};
	xhr.send(null);
}
</script>
</head>
<body>
	<input type="button" value="加载故障信息" onclick="getText()"/>
	<div id="faultInfo">
		
	</div>
</body>
</html>