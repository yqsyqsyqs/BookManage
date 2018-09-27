<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/vue.js"></script>
<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
<link rel="stylesheet" ref="easyui/themes/default/easyui.css">
<link rel="stylesheet" href="easyui/themes/icon.css" />

<script type="text/javascript">
$(function(){
	setTimeout(function(){
		$('#easyui').datagrid({
			singleSelect:true,
			collapsible:true,
			url:'datagrid',
			method:'get',
			toolbar:'',
			border:false,
			columns : [[
				{field:'bookId',title:'book编号'},
				{field:'bookName',title:'book名称'}
				]]
	});
	},1000);
})
</script>

</head>



<body>
	<div id="app">{{message}}</div>
	<script >
new Vue({
	e1:'#app',
	data:{
		message:'hello vue'
	}
})</script>
	<table id="easyui"></table>
	
	
<!-- 	<table class="easyui-datagrid" title="easyui-study" style="height: 700px;width: 200px"
	data-options="collapsible:true,url:'geteasyui',method:'get'"
	>
		<thead>
			<tr>
				<th data-options="field:'bookId',width:50px">bookid</th>
				<th data-options="field:'bookName',width:50px">bookname</th>
			</tr>
		</thead>
		
	</table> -->
</body>
</html>