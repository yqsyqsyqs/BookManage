<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
			<h3 style="text-align: center;
		">老书</h3><h4 style="text-align: center;">(相当于回收站)</h4>
			<#if blist3??>
				<#list blist3 as book>
					<div style="text-align: center;
		border: 1px solid #cccccc">
						<div>书名:${(book.bookName)!''}   作者:${(book.author)!''} 发布时间 ${(book.putDate)!''}<img width="50px" height="50px"src="down?bookId=${(book.bookId)!''}" /> 
						<button style="margin-left:20px ;" class="btn btn-default" onclick="huanyuan(${(book.bookId)!''})" >还原</button>
					</div>
				</#list>
			</#if>
			
				<h3 style="text-align: center;">主题</h3>
			<#if tlist??>
				<#list tlist as theme>
					<div style="text-align: center;
		border: 1px solid #cccccc">
						<div>主题字体名:${(theme.fontfamily)!''}  
					</div>
				</#list>
			</#if>
			<h3>您现在正在应用的主题名是</h3>
			<#if Session.fontfamily??>
			 <h1 style="color:red;">${(Session.fontfamily)!''}</h1> 
			<#else>
				没有应用去更改主题那里应用吧
			</#if>
			
			<script src="js/jquery-1.12.4.js"></script>
			<script type="text/javascript">
			function huanyuan(bookid){
				$.ajax({
					type:"post",
					data:{bookid:bookid},
					url:"booklist",
					success:function(){
						alert("ok")
						window.location.reload()
					}
				})
			}
			</script>
</body>
</html>