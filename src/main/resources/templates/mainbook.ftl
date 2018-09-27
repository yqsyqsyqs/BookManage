<#if blist??>
				<#list blist as book>
		<div class="content">
			
					<div>书名:${(book.bookName)!''}   作者:${(book.author)!''} <img width="50px" height="50px"src="down?bookId=${(book.bookId)!''}" /> 
					<button style="margin-left:20px ;" class="btn btn-default info" id=${(book.bookId)!''} data-tab=${(book.bookId)!''}>查看</button>
					<button style="margin-left:20px ;" class="btn btn-default" onclick="collect(${(user.userId)!''},${(book.bookId)!''})" >收藏</button>
					</div>
					
					<div class="yinc neirong hidden" id=${(book.bookId)!''} data-content=${(book.bookId)!''}> 
						书名:${(book.bookName)!''} 出版社:${(book.rebulisher)!''} 作者:${(book.author)!''} 价格:${(book.price)!''} 
						库存:${(book.storenumber)!''}
						<br />出版时间${(book.putDate)!''} <input placeholder="输入借书数量" name="number">
						<button style="margin-left:20px ;" class="btn btn-default read" data-book=${(book.bookId)!''}  data-user=${(user.userId)!''}  >借阅</button>
					
					</div>
				
		</div>
		</#list>
			</#if>
			
			<script type="text/javascript">
			$(function(){
				$(" .content .info").click(function(){
				var tab=this.dataset.tab;
				var content=$(".neirong[data-content="+tab+"]");
				
				if (content.hasClass("hidden")) {
					$(this).text("收起");
					 content.removeClass("hidden");
				} else {
					$(this).text("查看");
					content.addClass("hidden");
				}
				
			})
			
			$(".read").click(function(){
				var userid=this.dataset.user;
				var bookid=this.dataset.book;
				var $number=$(this).siblings("input[name=number]").val()
				console.log("--"+bookid+"--"+userid)
				$.ajax({
				type:"post",
				url:"mainborrow",
				data:{
					userid:userid,
					bookid:bookid,
					number:$number
				},
				success:function(number){
					if(number=="ok"){
						alert("借阅成功")
						window.location.reload();
					}if(number!="ok"){
						alert("库存数量不足就"+number+"本了")
						window.location.reload();
					}
				},error:function(){
					
				}
			})
			})
			
			})
			
			function collect(userid,bookid){
				$.ajax({
					type:"post",
					url:"collect",
					data:{
						userid:userid,
						bookid:bookid
					},
					success:function(){
						alert("收藏成功")
						window,location.reload()
					},error:function(){
						
					}
					})
			}
			</script>
