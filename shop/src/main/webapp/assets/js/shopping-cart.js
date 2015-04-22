$(document).ready(function(){
	var processing = false;
	$('body').on('click', '.num-reduce', function(){
		var $this = $(this), $tr = $this.closest('tr'), $input = $tr.find('input[name="quantity"]'), min = $input.data('min');
		if($this.hasClass('disabled') || processing){
			return;
		}
		var quantity = parseInt($input.val());
		if(quantity <= min){
			$this.addClass('disabled');
			return;
		}
		var code = $tr.data('code');
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
				$input.val(quantity-1);
				if(quantity-1 <= min){
					$this.addClass('disabled');
				}
				refreshShoppingCart(response.data);
			}
		});
	});
	$('body').on('click', '.num-add', function(){
		var $this = $(this), $tr = $this.closest('tr'), $input = $tr.find('input[name="quantity"]'), min = $input.data('min');
		var $reduce = $tr.find('.num-reduce');
		if($this.hasClass('disabled') || processing){
			return;
		}
		var quantity = parseInt($input.val());
		var code = $tr.data('code');
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
				if(quantity > min){
					$reduce.removeClass('disabled');
				}
				refreshShoppingCart(response.data);
			}
		});
	});
	$('body').on('click', '.cart-table .remove', function(){
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
		if($('.cart-table tr').length == 0){
			//购物车已清空
			$('.panel-cart .panel-body').html('Cart is empty!');
			return;
		}
	}
	
	$('body').on('click', '.go_pay', function(){
		var $this = $(this);
		if($this.hasClass('no')){
			return;
		}
		$this.addClass('no');
		$('#cartConfirmForm')[0].submit();
	});
});