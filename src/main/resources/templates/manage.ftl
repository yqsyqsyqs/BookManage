<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

		<script>
			function changepath(path){
				$("iframe").attr("src",path);
			}
		</script>
		<style type="text/css">
			body{
				background-image: url("img/b1.jpg");
			}
			.nav{
				text-align: center;
			}
			ul{float: left;
				border: 1px solid #cccccc;
				width: 20%;
				height: 500px;
				padding: 50px;
			}
			ul li{
				border: 1px solid #cccccc;
			}
			ul li h2 a{
				text-align: center;
			}
			iframe{
				border: 1px solid #cccccc;
				width: 80%;
				height: 500px;
			}
		</style>
	</head>
	<body>
		<div class="nav"><h1>欢迎来到图书员管理后台</h1></div>
		<ul >
			<il><h2><a  href = "javascript:changepath('/booklist');" 
				style="text-decoration: none;
				cursor: pointer;">书籍信息</a></h2></il>
			<il><h2><a  href = "javascript:changepath('/newbook');" 
				style="text-decoration: none;
				cursor: pointer;">添加新书</a></h2></il>
			<il><h2><a href = "javascript:changepath('/oldbook');" 
				style="text-decoration: none;
				cursor: pointer;">老书注销</a></h2></il>
			<il><h2><a href = "javascript:changepath('/recharge');" 
				style="text-decoration: none;
				cursor: pointer;">用户充值</a></h2></il>
			<il><h2><a href = "javascript:changepath('/theme');" 
				style="text-decoration: none;
				cursor: pointer;">更改主题</a></h2></il>
		</ul>
		<iframe  frameborder="0" src="booklist" scrolling="no">
		</iframe>
		<script src="js/jquery-1.12.4.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.js" ></script>
	</body>
</html>
