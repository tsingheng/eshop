$(document).ready(function(){
	var processing = false;
	$('body').on('click', '.J-num-act-reduce', function(){
		var $this = $(this);
		if($this.hasClass('num-reduce-disabled') || processing){
			return;
		}
		var quantity = parseInt($this.next().html());
		if(quantity <= 1){
			$this.addClass('num-reduce-disabled');
			return;
		}
		var code = $this.parent().data('code');
		var avaliable = parseInt($this.parent().data('avaliable'));
		processing = true;
		$.ajax({
			url: ctx + '/reduce-shopping-item',
			type: 'POST',
			dataType: 'json',
			data: {
				code: code,
				quantity: 1
			},
			success: function(response){
				processing = false;
				if(!response.success){
					return;
				}
				$this.next().html(quantity-1);
				if(quantity <= 2){
					$this.addClass('num-reduce-disabled');
				}
				if(quantity <= avaliable){
					$this.next().next().removeClass('num-add-disabled');
				}else{
					$this.next().next().addClass('num-add-disabled');
				}
				refreshShoppingCart(response.data);
			}
		});
	});
	$('body').on('click', '.J-num-act-add', function(){
		var $this = $(this);
		if($this.hasClass('num-add-disabled') || processing){
			return;
		}
		var quantity = parseInt($this.prev().html());
		var avaliable = parseInt($this.parent().data('avaliable'));
		if(quantity >= avaliable){
			$this.addClass('num-add-disabled');
			return;
		}
		var code = $this.parent().data('code');
		processing = true;
		$.ajax({
			url: ctx + '/add-to-shopping-cart',
			type: 'POST',
			dataType: 'json',
			data: {
				code: code,
				quantity: 1
			},
			success: function(response){
				processing = false;
				if(!response.success){
					return;
				}
				$this.prev().html(quantity+1);
				if(quantity+1 >= avaliable){
					$this.addClass('num-add-disabled');
				}
				if(quantity > 0){
					$this.prev().prev().removeClass('num-reduce-disabled');
				}else{
					$this.prev().prev().addClass('num-reduce-disabled');
				}
				refreshShoppingCart(response.data);
			}
		});
	});
	$('body').on('click', '.orders .del', function(){
		if(processing){
			return;
		}
		processing = true;
		var $this = $(this);
		var code = $this.data('code');
		$.ajax({
			url: ctx + '/remove-shopping-item',
			type: 'POST',
			dataType: 'json',
			data: {
				code: code
			},
			success: function(response){
				processing = false;
				if(!response.success){
					return;
				}
				$this.closest('tr').remove();
				refreshShoppingCart(response.data);
			}
		});
	});
	
	function refreshShoppingCart(shoppingCart){
		App.loadShoppingCart();
		if($('.tbl-main tr').length == 0){
			//购物车已清空
			$('.orders').addClass('order_empty').html('<div class="empty_img fl"></div><div class="empty_detail fr"><p class="txt">购物袋还是空荡荡哒~快去抢购宝贝吧！</p><p class="btn_all"><a href="' + ctx + '/" class="btn_normal btn_normal_01">去抢购</a></p></div>');
			return;
		}
		$('.orders-total-pay .other').html('<p class="all">共有<em>' + shoppingCart.quantity + '</em>件商品，金额<span><i>￥</i><label>' + shoppingCart.originalAmount + '</label></span></p><p class="count">总计（不含运费）<span><i>￥</i><label>' + shoppingCart.originalAmount + '</label></span></p>');
	}
});