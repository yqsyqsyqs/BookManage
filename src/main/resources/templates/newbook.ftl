<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<script src="js/jquery-1.12.4.js"></script>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.js" ></script>
<script type="text/javascript" src="plugins/My97DatePicker/WdatePicker.js"></script>
	
	</head>
	<body >
		<div class="box" >
			<div class="box-header">
				<h3 style="text-align: center;">添加新书快点</h3>
			</div>
			<form action="getbook" method="post" enctype="multipart/form-data" >
				<div class="box-body">
					<div class="row">
						<div class="col-md-6 form-group">
							<span>
							<label class="control-label" >图书名</label>
							</span>
							<input class="form-control"  name="bookName"/>
						</div>
						<div class="col-md-6 form-group">
							<label class="control-label">作者</label>
							<input class="form-control" name="author"/>
						</div>
					</div>
					
					<div class="row">
						<div class="col-md-6 form-group">
							<span>
							<label class="control-label" >价格</label>
							</span>
							<input class="form-control"  name="price"/>
						</div>
						<div class="col-md-6 form-group">
							<label class="control-label">出版时间</label>
							<input type="date" class="form-control " onclick="WdatePicker()" name="putDate"/>
						</div>
					</div>
					
					<div class="row">
						<div class="col-md-6 form-group">
							<span>
							<label class="control-label" >出版社</label>
							</span>
							<input class="form-control"  name="rebulisher"/>
						</div>
						<div class="col-md-6 form-group">
							<label class="control-label">库存数</label>
							<input class="form-control" name="storenumber"/>
						</div>
					</div>
					
					<div class="row">
						<div class="col-md-6 form-group">
							<input  name="file" type="file"/> 
						</div>
					</div>
					
				<div class="box-footer">
				<input class="btn btn-primary" id="save" type="submit" value="保存"/>
				<input class="btn btn-default hidden" id="cancel" type="submit" value="取消" onclick="window.history.back();"/>
				<div><h3 style="color:red;">${(message)!''}</h3></div>
			</div>
			</div>
			</form>
		</div>
	</body>
</html>
