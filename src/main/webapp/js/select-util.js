function setFunc(){
	var id = [1,2,3];
	var value = ["北京","上海","南京"];
	var select = document.getElementById("area");
	select.length = 1;
	select.options[0].selected = true;
	for(var i=0;i<id.length;i++){
		var option = document.createElement("option");
		option.setAttribute("value",id[i]);
		option.appendChild(document.createTextNode(value[i]));
		select.appendChild(option);
	}
}