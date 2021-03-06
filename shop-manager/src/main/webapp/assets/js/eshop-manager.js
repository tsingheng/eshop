$(document).ready(function(){
	App.init();
});

var App = {
	init: function(){
		this.initSidebar();
		this.initTools();
	},
	initSidebar: function(){
		$('#sidebar').on('click', '.submenu a', function(){
			var self = $(this), node = self.parent();
			//展开或者关闭下级菜单
			if(node.hasClass('open')){
				self.next().slideUp(function(){
					node.removeClass('open');
				});
			}else{
				self.next().slideDown(function(){
					node.addClass('open');
				});
			}
		});
	},
	initTools: function(){
		$('body').on('click', '.easyui-window .btn-cancel', function(){
			$(this).closest('.easyui-window').window('close');
		});
	}
}