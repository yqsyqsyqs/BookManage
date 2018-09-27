<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>图书管理系统</title>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<style type="text/css">
	body{
		background-image: url("../img/main.jpg");
		 font-family: ${(Session.fontfamily)!''};
	}
	.main{
		margin-top: 2% ;
		margin-left: 10% ;
		margin-right: 30%;
		border: 1px solid #cccccc;
		padding: 10px;
	}
	.nav div img{
    float: right;
    margin-top: -30px;
	}
	.content{
		margin-top: 15px;
		text-align: center;
		border: 1px solid #cccccc
	}
	.borrow{    
	width: 25%;
	position: absolute;
    right: 10px;
    top:4% ;
    border: 1px solid #cccccc;	
	}
	.return{
		margin-top: 15px;
		border: 1px solid #cccccc
	}
	.yinc{
		margin-top: 10px;
		margin-right: 20%;
		text-align: center;
	}
	.collect{
	    width: 9%;
    position: absolute;
    left: 10px;
    top: 4%;
    border: 1px solid #cccccc;
	}
	.news{
	 width: 9%;	
    position: absolute;
    left: 10px;
    top: 12%;
    border: 1px solid #cccccc;
	}
	.shownews{
	width: 9%;
	
    position: absolute;
    left: 10px;
    top: 31%;
    border: 1px solid #cccccc;
	}
	.cursor{
	cursor: pointer;
	border-radius: 10px;
	}
	</style>
	<script src="js/jquery-1.12.4.js"></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap.js" ></script>
		<script type="text/javascript">
			function shareinfo(userId,bookId){
				$.ajax({
					type:"get",
					url:"shareinfo?userId="+userId+"&bookId="+bookId+"",
						success:function(){
							$(".shareyinc").removeClass("hidden");
							window.location.reload()
						}
				})
				
			}
		</script>
	</head>
	<body>
		
		<a href="collect?userid=${(user.userId)!''}">
		<div class="collect btn btn-primary">
		<span class="glyphicon glyphicon-star"></span>
		收藏中心
		</div></a>
		<#list blist as book>
			<#if book.bookId = 12>
		 <div class="news">
			${(book.bookName)!''} <input style="width:100px" placeholder="用户" id="sharename" ><button class="share">发送</button>
		</div>
		</#if>
		 </#list>
		
		<div class="shownews">
			<#if noread gt 0>
				<span class="badge">${noread}</span>
			</#if>
			<#if noreadlist??>
				<#list noreadlist as read>
					<button onclick="shareinfo(${(read.user.userId)!''},${(read.book.bookId)!''})">查看</button>
					<div class="shareyinc hidden">
						${(read.book.bookName)!''}
					</div>
				</#list>
			</#if>
		</div>
		<div class="main">
		<div class="nav" style="
			border-bottom: 1px solid #cccccc !important;"> 
		<h4 >欢迎${(user.userName)!''}同学进入图书管理系统   用户余额:${user.money}</h4>
			<div><img style="margin-top:-40px;" width="60px" height="60px" src="down?userId=${(user.userId)!''}" class="img-responsive img-circle ">
			<a style="float: right;margin-right:20px; margin-top:-20px;   cursor: pointer;" href="logout">注销用户</a></div>
			
		</div>
		
		<input style="width:60%;margin-top: 1%; margin-bottom: 2%" placeholder="搜索图书名/出版社/作者"/ oninput="research(1)" name="research">
    	<br/>
    	<span class="label label-default cursor btn" onclick="research(2)" name="keyword1">${(keyword1)!''}</span>
    	<span class="label label-default cursor btn" onclick="research(3)" name="keyword2">${(keyword2)!''}</span>
    	<span class="label label-default cursor btn" onclick="research(4)" name="keyword3">${(keyword3)!''}</span>
    	<div id="refresh">
    	<#include "/mainbook.ftl">
		</div>
			
		<div class="return">
			<#if balist??>
				<#list balist as back>
					<div>
						  书名:${(back.book.bookName)!''}   作者:${(back.book.author)!''} 借阅日期:${(back.bcakDate)!''} 已经归还${back.bcakNumber}本
					</div>
				</#list>
			</#if>
		</div>
		
		</div>
		
		<div class="borrow">
			<#if borlist??>
			<#list borlist as borrow>
				<div>
					已经借出去  书名:${(borrow.book.bookName)!''}   作者:${(borrow.book.author)!''} 借阅日期:${(borrow.borrowDate)!''}
			借了${(borrow.borrowNumber)!''}本
			<img width="30px" height="30px" src="down?bookId=${borrow.book.bookId}" /> 
						<button style="margin-left:20px ;" class="btn btn-default back" data-back=${(borrow.borrowId)!''}   id=${(borrow.borrowId)!''}>归还</button>
							
							<div class="hidden guihuan"  data-content=${(borrow.borrowId)!''}> 
						
						<button style="margin-left:20px ;" class="btn btn-default huan"  data-bor=${(borrow.borrowId)!''} data-book2=${(borrow.book.bookId)!''}  data-user2=${(borrow.user.userId)!''}    >还</button>
					 <input placeholder="输入归还数量" name="backnumber"/>本
					</div>
				</div>
			</#list>
		</#if>
		</div>
		

<script>

		$(function(){
			$(".borrow .back").click(function(){
				var back=this.dataset.back;
				var guihuan=$(".guihuan[data-content="+back+"]");
				if (guihuan.hasClass("hidden")) {
					$(this).text("收起");
					guihuan.removeClass("hidden");
				} else {
					$(this).text("归还");
					guihuan.addClass("hidden");
				}
				
			})
		$(".share").on("click",function(){
			var $sharename= $("#sharename").val();
			$.ajax({
				type:"get",
				url:"share?userName="+$sharename+"&bookName=每天学点说话技巧 ",
				success:function(){
					alert("分享成功")
					window.location.reload()
				}
			})
		})
			
			
			
			$(".huan").click(function(){
				var userid=this.dataset.user2;
				var bookid=this.dataset.book2;
				var borrowid=this.dataset.bor;
				var $backnumber=$(this).siblings("input[name=backnumber]").val();
				console.log($backnumber)
				$.ajax({
					type:"post",
					url:"mainback",
					data:{
						borrowid:borrowid,
						userid:userid,
						bookid:bookid,
						backnumber:$backnumber
					},
					success:function(result){
						 if(result=="还清了"){
							alert(result)
						}if(result=="还没有还清o"){
							alert(result)
						}if(result>0){
							alert("你只借"+result+"本")
						}
						window.location.reload();
					},error:function(){
						
					}
				})
			})
			
		})
		
		function research(number){
			var $research;
			if(number==1){
			$research=$("input[name=research]").val();
			}if(number==2){
			$research=$("span[name=keyword1]").html();
			}if(number==3){
			$research=$("span[name=keyword2]").html();
			}if(number==4){
			$research=$("span[name=keyword3]").html();
			}
			console.log($research)
			$.ajax({
				type:"post",
				url:"find",
				data:{research:$research,
					userid:${user.userId}
				},
				success:function(dates){
					$("#refresh").html(dates);
				}
			})
		}
		</script>
	</body>
</html>
