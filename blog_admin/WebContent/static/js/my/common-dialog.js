//require bootstrap3-dialog-master
function bootstrap_alert(message, title) {
	title = title || '提示';
	BootstrapDialog.show({
		closable : false,
		title : title,
		message : message,
		buttons : [ {
			id : 'btn-ok',
			icon : 'glyphicon glyphicon-check',
			label : '确定',
			cssClass : 'btn-primary',
			autospin : false,
			action : function(dialogRef) {
				dialogRef.close();
			}
		} ]
	});
}

function bootstrap_callback(message, callback, title) {
	title = title || '提示';
	BootstrapDialog.show({
		closable : false,
		title : title,
		message : message,
		buttons : [ {
			id : 'btn-ok',
			icon : 'glyphicon glyphicon-check',
			label : '确定',
			cssClass : 'btn-primary',
			autospin : false,
			action : function(dialogRef) {
				callback();
			}
		} ]
	});
}

var alert = function(mes){
	bootstrap_alert(mes);
} 
var callBackDialog = function(message,callback,title){
	bootstrap_callback(message, callback, title)
}