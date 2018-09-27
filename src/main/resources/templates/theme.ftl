<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		<#if tlist??>
			<#list tlist as theme>
				<div style="border: 1px solid #cccccc;text-align: center;
    font-size: 40px;">
					主题:${theme.fontfamily}   <button class="btn btn-default " onclick="apply(${theme.themeId})">应用</button>
				</div>
				
			</#list>
		</#if>
		<script src="js/jquery-1.12.4.js"></script>
		<script type="text/javascript">
			function apply(themeid){
				$.ajax({
					type:"post",
					data:{themeid:themeid},
					url:"apply",
					success:function(){
						alert("应用成功")
						window.location.reload()
					}
				})
			}
		</script>
	</body>
</html>
