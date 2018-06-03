function closeCurrentWindow(){
	$(".panel-tool-close").click();
}

function reloadDatagrid(datagridId){
	$("#"+datagridId).datagrid("reload");
}

function createWindow(params){
	$("<div>").css({padding:"5px"}).window({
		width : params.width?params.width:"600",
		height : params.height?params.height:"400",
		modal:true,
		title : params.title?params.title:" ",
		href : params.url,
	    onClose : function(){
	    	$(this).window("destroy");
	    },
	    onLoad : function(){
	    	if(params.onLoad){
	    		params.onLoad.call(this);
	    	}
	    }
	}).window("open");
}

function submitForm(params) {
	var form = $("#"+params.formId);
	form.form("submit", {
		'dataType':'json',
		'success' : function(data) {
			data = $.parseJSON(data);
			if(data.status == 200){
				$.messager.alert(data.title, data.msg, data.ico, function() {
					if(params.fun){
			    		params.fun.call(this);
			    	}
				});
			}else{
				$.messager.alert(data.title, data.msg, data.ico);
			}
		}
	});
}