function removeUsers() {
	var userTables = $("#userTables");

	var rows = userTables.datagrid("getSelections");
	if (rows.length != 1) {
		$.messager.alert("系统提示", "只能删除一条数据", "warning");
	} else {
		var params = "id="+rows[0].id;
		$.messager
				.confirm(
						"系统确认信息",
						"是否删除\'" + rows[0].name + "\'用户",
						function(choose) {
							if (choose) {
									$.ajax({
										'url' : '/user/deleteUser',
										'type' : 'post',
										'data' : params,
										'success' : function(data) {
											$.messager.progress("close");
											$.messager
													.alert(
															"系统提示",
															"删除成功",
															"info",
															function() {
																userTables
																		.datagrid("reload");
															});
										},
										'beforeSend' : function() {
											$.messager.progress();
										}
									});
							}
						});
	}
}

function openAddUserWindow() {
	createWindow({"title":"新增用戶", "url":"/add-user.jsp"});
}

function openModifyUserWindow(){
	var rows = $("#userTables").datagrid("getSelections");
	if(rows.length != 1){
		$.messager.alert("系统提示","只能选择一个用户修改数据","warning");
		return;
	}
	
	createWindow({"title":"修改用戶", "url":"/update-user.jsp", "onLoad":function(){
		$("#modifyUserForm").form("load", "/user/getUser4Modify?id="+rows[0].id);
	}});
}

function modifyUser(formId){
	var params = {};
	params['formId'] = formId;
	params['fun'] = function(){
		closeCurrentWindow();
		reloadDatagrid("userTables");
	};
	submitForm(params);
}

function addUser(formId){
	var params = {};
	params['formId'] = formId;
	params['fun'] = function(){
		closeCurrentWindow();
		reloadDatagrid("userTables");
	};
	submitForm(params);
}