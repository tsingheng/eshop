$(document).ready(function(){
	App.init();
});

var App = {
	init: function(){
		this.initSidebar();
		this.initTools();
		this.initCaptcha();
		this.initShoppingCart();
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
	},
	initCaptcha: function(){
		$('body').on('click', '.captcha', function(){
			var url = $(this).data('url');
			$(this).css('background-image', 'url("' + url + '?' + new Date().getTime() + '")');
		});
	},
	initShoppingCart: function(){
		$('.bag-show, .logined-show').hover(function(){
			$(this).addClass('hover');
		}, function(){
			$(this).removeClass('hover');
		});
	}
}