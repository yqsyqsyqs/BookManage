<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>图书管理系统登录界面</title>
		<script src="js/jquery-1.12.4.js"></script>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.js" ></script>
	<style>
	body{
		background-image: url("../img/r4.jpg");
		font-family: ${(Session.fontfamily)!''};
	}
		 h1{
			text-align: center;
		}
		.tab-content .tab-pane{
		}
		.tab-content  #second  div input{
			height: 40px;
    		width: 50%;
			margin-left: 20%;
		}
		.tab-content  #home  div input{
			height: 40px;
    		width: 50%;
		}
		
		
		.tab-content .tab-pane div label{
			margin-left: 20%;
		}
		.tab-content .tab-pane div button{
			height: 30px;
			width: 220px;
			
		}
	</style>
	</head>
	<body>
		<#if books??>
				<#list books as book>
					<div>
						${book.bookName}
					</div>
				</#list>
			</#if>
<!--<div style="position: absolute;width: 100%;" id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="500">
	<!-- 轮播（Carousel）指标 -->
	<!-- 轮播（Carousel）项目 -->
	<!--<div class="carousel-inner">
		<div class="item active">
			<img src="../img/r3.jpg" alt="First slide">
		</div>
		<div class="item">
			<img src="../img/r2.jpg" alt="Second slide">
		</div>
		<div class="item">
			<img src="../img/r1.jpg" alt="Third slide">
		</div>
	</div>
	<!-- 轮播（Carousel）导航 -->
	<!--<a class="carousel-control left" href="#myCarousel" 
	   data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
	<a class="carousel-control right" href="#myCarousel" 
	   data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
</div> -->

			<h1 style="color: blue;">
				欢迎进入图书馆 看下你的图书吧 
			</h1>
<div style="float: right; width: 450px; margin-right:10%; margin-top:6%;border: 1px solid #cccccc;;" >
			<ul class="breadcrumb " style="margin-bottom:0px ;">
			<li class="active" ><a class="btn " href="#home" data-toggle="tab">登陆</a></li>   
			<li ><a class="btn" href="#second" data-toggle="tab">注册</a></li>
			<li ><a class="btn" href="#Third" data-toggle="tab">帮助中心</a></li>
			</ul>
			<div class="tab-content" style="background: wheat;padding-top: 10%;">
				<div class="tab-pane active" id="home">
				<form action="login" method="post" >
					<div >
							<label style="margin-right:20px ;"><span class="glyphicon glyphicon-user"></span></label>
							<input placeholder="学号/姓名"/ id="numberinput" oninput="checknumber2()" name="userName" value="${(userName)!''}"><span style="color:red"  id="number"></span>
					</div>
					
					<div style="padding-top: 7%;padding-bottom: 3%;">
						<label style="margin-right:20px ;"><span class="glyphicon glyphicon-asterisk"></span></label>
					<input placeholder="请输入密码" oninput="checkpw2()" type="password"  id="pwinput"  name="password"/><span style="color:red"  id="pw"></span>
					</div>
					
					<div style="    padding-top: 3%;padding-left: 30%;">
						<input  type="radio"   style="width: 20px;height: 20px;" name="ismanage" value="1"/> <span style="margin-right: 10%;">学生</span> 
						<input  type="radio" style="width: 20px;height: 20px;" name="ismanage" value="0"/>管理员
					</div>
					
					<button class="btn btn-warning" style="
						margin-top: 20px !important;    width: 90px !important;height: 32px !important;border-radius: 0px;
						color: white; margin-bottom: 20px !important; margin-left: 35% !important;">登陆</button>
						<div style="color:red;text-align: center;">${(error)!''}</div>
					</form>
				</div>
				
				
				<div class="tab-pane " id="second">
					<form action="reg" method="post" enctype="multipart/form-data" onsubmit="return recheck()">
					<div>
						<input name="userName"  id="un1"  oninput="checkname()"   placeholder="请输入姓名"/> <span style="color:red"  id="userName"></span>
					</div>
					
					<div style="margin-top: 5%;">
					<input  name="userNumber" id="un2" oninput="checknumber()" placeholder="请输入学号"/> <span style="color:red" id="userNumber"></span>
					</div>
					<div style="margin-top:  5%;">
					<input name="userTel" oninput="checktel()" placeholder="请输入电话"/><span style="color:red" id="userTel"></span>
					</div>
					<div style="margin-top:  5%;">
					<input name="password" id="up" oninput="checkpw()" placeholder="请输入密码" type="password"/><span  style="color:red" id="password"></span>
					</div>
					 <div style="margin-top:  5%;     margin-left: 30%; ">
					<input name="file" type="file" /> 
					</div> 
					<button class="btn btn-warning" style="
						margin-top: 20px !important;    width: 90px !important;height: 32px !important;border-radius: 0px;
						color: white; margin-bottom: 20px !important;margin-left: 35% !important; "
						
						>注册</button>
					</form>
				</div>
				<div class="tab-pane " id="Third" style="text-align: center;">
				我们收集了一些您可能遇到的问题，希望可以帮您解决：
				<br />
				1、手机号已经注销无法认证
				<br />
				2、害怕隐私被泄露
				<br />
				3、账户号被盗用
				<br />
				4、不想被中介骚扰
				<br />
				5、邮箱被别人冒用了
				<br />
				6、手机号被别人冒用了
				<br />
				7、被误判为中介、商家
				</div>
			</div>
			</div>
			<script type="text/javascript" src="js/regcheck.js"></script>
			<script type="text/javascript" src="js/landcheck.js"></script>
	</body>
</html>
