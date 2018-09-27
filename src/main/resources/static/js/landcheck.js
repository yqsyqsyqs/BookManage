function numclear(){
			$("#number").text("");
			$("#number").removeClass("glyphicon glyphicon-ok");
		}
function pclear(){
	$("#pw").text("");
	$("#pw").removeClass("glyphicon glyphicon-ok");
}
function checknumber2(){
	var $number=$("#numberinput").val();
	var size=$number.length;
	if(size===0){
		numclear()
		$("#number").text("输入不能为空")
	}else{
		$.ajax({
			type:"get",
			url:"landcheck",
			data:{number:$number},
			success:function(result){
				if(result=="没有这个用户"){
					numclear();
					$("#number").text(result);
				}if(result=="ok"){
					$("#number").text("");
					$("#number").addClass("glyphicon glyphicon-ok");
				}
			}
		})
	}
	
}
function checkpw2(){
	var $pw=$("#pwinput").val();
	var size=$pw.length;
	if(size===0){
		pclear()
		$("#pw").text("输入不能为空")
	}
}
