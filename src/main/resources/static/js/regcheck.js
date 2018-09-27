function nameclear(){
			$("#userName").text("");
			$("#userName").removeClass("glyphicon glyphicon-ok");
		}
function numberclear(){
	$("#userNumber").text("");
	$("#userNumber").removeClass("glyphicon glyphicon-ok");
}
function telclear(){
	$("#userTel").text("");
	$("#userTel").removeClass("glyphicon glyphicon-ok");
}
function pwclear(){
	$("#password").text("");
	$("#password").removeClass("glyphicon glyphicon-ok");
}
		function checkname(){
			var $username=$("#un1").val();
			var size=$username.length;
			//首先验证是否为空
			if(size==0||size==""){
				nameclear();
				$("#userName").text("输入不能为空");
			}if(size>=12){
				nameclear();
				$("#userName").text("字数不能大于12个");
			}if(size>0&&size<12){
				$.ajax({
					type:"get",
					url:"check",
					data:{username:$username},
					success:function(result){
						console.log(result);
						if(result=="该名字已经存在"){
							nameclear();
							$("#userName").text(result);
						}
						if(result=="ok"){
							$("#userName").text("");
							$("#userName").addClass("glyphicon glyphicon-ok");
						}
						
					}
				})
			}
			
		}
		
		function checknumber(){
			var $usernumber=$("#un2").val();
			var size=$usernumber.length;
			//首先验证是否为空
			if(size==0||size==""){
				numberclear();
				$("#userNumber").text("输入不能为空");
			}if(size>=12){
				numberclear();
				$("#userNumber").text("学号不能大于12个");
			}if(size>0&&size<6){
				numberclear();
				$("#userNumber").text("学号不能小于6个");
			}if(size>6&&size<12){
				$.ajax({
					type:"get",
					url:"check",
					data:{usernumber:$usernumber},
					success:function(result){
						console.log(result);
						if(result=="该学号已经存在"){
							numberclear();
							$("#userNumber").text(result);
						}if(result=="请以144081开头"){
							numberclear();
							$("#userNumber").text(result);
						}if(result=="ok"){
							$("#userNumber").text("");
							$("#userNumber").addClass("glyphicon glyphicon-ok");
						}
						
					}
				})
			}
			
		}
		
		function checktel(){
			var $usertel=$("input[name=userTel]").val();
			var size=$usertel.length;
			//首先验证是否为空
			if(size==0||size==""){
				telclear();
				$("#userTel").text("输入不能为空");
			}if(size!=0&&size!=11){
				telclear();
				$("#userTel").text("电话号码是11位");
			}if(size==11){
				//电话格式
				var regTel = /^0?1[3|4|5|8][0-9]\d{8}$/;
				if(regTel.test($usertel)){
					$("#userTel").text("");
					$("#userTel").addClass("glyphicon glyphicon-ok");
				}else{
						telclear();
						$("#userTel").text("电话号码格式不对");
				}
			
		}
		}
		
		function checkpw(){
			var $password=$("#up").val();
			var size=$password.length;
			//首先验证是否为空
			if(size==0||size==""){
				pwclear();
				$("#password").text("输入不能为空");
			}if(size>0&&size<6){
				pwclear();
				$("#password").text("密码至少要6位");
			}if(size>15){
				pwclear();
				$("#password").text("密码不能超过15位");
			}if(size>6&&size<15){
					$("#password").text("");
					$("#password").addClass("glyphicon glyphicon-ok");
			}
		}
		
		function recheck(){
			checkname();checknumber();checktel();checkpw();
			if($("#userName").hasClass("glyphicon glyphicon-ok")&&$("#userNumber").hasClass("glyphicon glyphicon-ok")
					&&$("#userTel").hasClass("glyphicon glyphicon-ok")&&$("#password").hasClass("glyphicon glyphicon-ok")){
				//所有检查都显示勾就检验通过
				alert("ok 注册通过 你可以登录了")
				return true;
			}else{
				return false;
			}
			
		}
		