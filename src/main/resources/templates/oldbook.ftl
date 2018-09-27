<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		<#if blist4??>
				<#list blist4 as book>
					<div style="text-align: center;
		border: 1px solid #cccccc">
						<div>书名:${(book.bookName)!''}   作者:${(book.author)!''} 发布时间 ${(book.putDate)!''}<img width="50px" height="50px"src="down?bookId=${(book.bookId)!''}" /> 
						<button style="margin-left:20px ;" class="btn btn-default" onclick="del(${(book.bookId)!''})" >注销</button>
					</div>
				</#list>
			</#if>
			<script src="js/jquery-1.12.4.js"></script>
			<script type="text/javascript">
			function del(bookid){
				$.ajax({
					type:"post",
					data:{bookid:bookid},
					url:"oldbook",
					success:function(){
						alert("ok")
						window.location.reload()
					}
				})
			}
			</script>
	</body>
</html>
