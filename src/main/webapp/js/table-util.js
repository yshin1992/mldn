var Counter =(function(){
	var count = 0;
	return function(){
		return count++;
	}
}());

function addRow(){
	var table = document.getElementById("mytable");
	var tr=table.insertRow();
	var td1=tr.insertCell();
	var td2=tr.insertCell();
	var td3=tr.insertCell();
	
	td1.innerHTML="Java Core "+Counter();
	td2.innerHTML="69.5";
	td3.innerHTML="<input type='button' value='-' onclick='deleteRow(this)'/>";
}

function deleteRow(btn){
	var tr = btn.parentNode.parentNode;
	var table=document.getElementById("mytable");
	table.deleteRow(tr.rowIndex);
}