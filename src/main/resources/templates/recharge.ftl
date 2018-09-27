<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		<style type="text/css">
			.ii{
			width: 30%;height: 40px;
    border-radius: 5px;    margin-bottom: 5%;}
		</style>
		<div style="text-align: center;">
			<div>
				<input class="ii" placeholder="输入学号或者姓名" id="chargename">
			</div>
			<div>
				<input class="ii" placeholder="输入充值金额" id="chargemoney">
			</div>
			<div>
				<button style="height: 40px;
    border-radius: 5px; width: 10%;"  onclick="charge()">充值</button>
			</div>
			
			
		</div>
<script src="js/jquery-1.12.4.js"></script>
		<script type="text/javascript">
			function charge(){
				var $chargename=$("#chargename").val()
				var $chargemoney=$("#chargemoney").val()
				$.ajax({
					type:"post",
					data:{chargename:$chargename,
						chargemoney:$chargemoney
					},
					url:"charge",
					success:function(result){
						if(result=="错误"){
							alert(result)
							window.location.reload()
						}if(result=="提交成功"){
							alert(result)
							window.location.reload()
						}
					}
				})
			}
		</script>
	</body>
</html>