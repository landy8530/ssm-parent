<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/my.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/user.js"></script>
<link href="${pageContext.request.contextPath }/js/themes/default/easyui.css" rel="stylesheet" type="text/css" >
<link href="${pageContext.request.contextPath }/js/themes/icon.css" rel="stylesheet" type="text/css" >
</head>
<body>
<table id="userTables" class="easyui-datagrid"  data-options="
			method: 'post',
			url : '${pageContext.request.contextPath }/user/listUsers',
			pagination : true,
			pageSize : 3,
			pageList : [3, 4, 5, 6, 7],
			pageNumber : 1,
			title : '用户列表',
			rownumbers : true,
			toolbar : '#userTools'
		">
	<thead>
		<tr>
			<th data-options="field: 'ck', checkbox: true"></th>
			<th data-options="field: 'id'">序号</th>
			<th data-options="field: 'name'">姓名</th>
			<th data-options="field: 'password'">密码</th>
		</tr>
	</thead>
</table>

<div id="userTools" style="text-align: right; padding-right : 15px">

	<a class="easyui-linkbutton" href="#" onclick="openAddUserWindow();"
		data-options="iconCls : 'icon-add'">新增</a>
	<a class="easyui-linkbutton" href="#" onclick="openModifyUserWindow();"
		data-options="iconCls : 'icon-edit'">修改</a>
	<a class="easyui-linkbutton" href="#" onclick="removeUsers();"
		data-options="iconCls : 'icon-remove'">删除</a>

</div>
</body>
</html>