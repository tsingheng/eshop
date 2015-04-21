$(document).ready(function(){
	App.init();
});

var App = {
	init: function(){
		this.initSidebar();
		this.initTools();
		this.initCaptcha();
		this.initShoppingCart();
		this.loadShoppingCart();
		this.initCategory();
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
		$('body').on('click', '.bag-tool .del', function(){
			$(this).closest('li').find('.tips_alert').show();
		});
		$('body').on('click', '.tips_alert .btn02', function(){
			$(this).closest('.tips_alert').hide();
		});
		$('body').on('click', '.tips_alert .btn01', function(){
			var li = $(this).closest('li');
			$.ajax({
				url: ctx + '/remove-shopping-item',
				type: 'POST',
				dataType: 'json',
				data: {
					code: $(this).data('code')
				},
				success: function(response){
					if(!response.success){
						return
					}
					App.loadShoppingCart();
				}
			});
		});
	},
	loadShoppingCart: function(){
		$.ajax({
			url: ctx + '/load-shopping-cart',
			type: 'POST',
			dataType: 'json',
			success: function(cart){
				if(cart.quantity == 0){
					$('.cart-nav .cart-count').html('empty');
				}else{
					$('.cart-nav .cart-count').html(cart.quantity);
					$('.bag-tool').removeClass('bag-tool-empty').html('');
					var cartUl = $('<ul class="clear"></ul>');
					var lis = [];
					lis.push('<ul class="clear">');
					for(var i in cart.shoppingCartItemList){
						var item = cart.shoppingCartItemList[i];
						lis.push('<li class="' + (i == cart.shoppingCartItemList.length-1 ? 'last' : '') + '" id="cart-' + item.code + '">');
						lis.push('	<a class="pic fl">');
						lis.push('		<img class="lazy" src="' + item.sku.image.replace('_1', '') + '" style="display: inline;">');
						lis.push('	</a>');
						lis.push('	<div class="detail">');
						lis.push('		<p class="title">');
						lis.push('			<a target="_blank" href="' + ctx + '/detail/' + item.sku.code + '">' + item.sku.name + '</a>');
						lis.push('			<span class="fr"><em>￥</em>' + item.sku.sellPrice + '×' + item.quantity + '</span>');
						lis.push('		</p>');
						lis.push('		<p class="normal">尺码：' + item.size + '<a href="javascript:;" class="del fr">删除</a></p>');
						lis.push('		<p class="normal">颜色：' + item.color + '</p>');
						lis.push('	</div>');
						lis.push('	<div class="tips_alert" style="display:none;">');
						lis.push('		<div class="mask_bg"></div>');
						lis.push('		<div class="btn_all">');
						lis.push('			<a class="btn btn01" data-code="' + item.code + '" href="javascript:;">删除</a>');
						lis.push('			<a class="btn btn02" href="javascript:;">保留</a>');
						lis.push('		</div>');
						lis.push('	</div>');
						lis.push('</li>');
					}
					lis.push('</ul>');
					lis.push('<div class="amount"><a class="fr btn" target="_blank" href="' + ctx + '/shopping-cart">去购物袋结算</a></div>');
					$('.bag-tool').html(lis.join(''));
				}
			}
		});
	},
	initCategory: function(){
		$('.category-list .has-children').hover(function(){
			
		});
	}
}