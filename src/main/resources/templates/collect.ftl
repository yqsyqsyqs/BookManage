<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
			<#if blist2??>
				<#list blist2 as book>
					<div style="text-align: center;
		border: 1px solid #cccccc">
						<div>书名:${(book.bookName)!''}   作者:${(book.author)!''} <img width="50px" height="50px"src="down?bookId=${(book.bookId)!''}" /> 
					</div>
				</#list>
			</#if>
</body>
</html>