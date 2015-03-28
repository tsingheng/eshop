$(document).ready(function(){
	
	$('.img-slider-list li').hover(function(){
		var $this = $(this);
		if($this.hasClass('cur')){
			return;
		}
		$this.parent().find('.cur').removeClass('cur');
		$this.addClass('cur');
		var imgSrc = $this.data('img');
		$('.jqzoom').attr('href', imgSrc.replace('_#size#', ''));
		$('.jqzoom').html('<img id="jq-zoom" src="' + imgSrc.replace('#size#', '1') + '"/>');
		$('.jqzoom').data('jqzoom', '').jqzoom({zoomType:"standard",title:false,lens:false,alwaysOn:false});
	});
	$('.img-slider-list li:first').trigger('mouseover');
	
	var sliding = false;
	$('.pic-slider-down').click(function(){
		if(sliding){
			return;
		}
		var $this = $(this);
		if($this.hasClass('switchable-last')){
			return;
		}
		sliding = true;
		$this.parent().find('.switchable-first').removeClass('switchable-first');
		var $ul = $('.img-slider-list ul'), marginLeft = parseInt($ul.css('margin-left')) || 0;
		marginLeft -= 64;
		$ul.animate({marginLeft: marginLeft + 'px'}, function(){
			sliding = false;
		});
		if(-marginLeft >= ($ul.children().length-5)*64){
			$this.addClass('switchable-last');
		}
	});
	$('.pic-slider-up').click(function(){
		if(sliding){
			return;
		}
		var $this = $(this);
		if($this.hasClass('switchable-first')){
			return;
		}
		sliding = true;
		$this.parent().find('.switchable-last').removeClass('switchable-last');
		var $ul = $('.img-slider-list ul'), marginLeft = parseInt($ul.css('margin-left'));
		marginLeft += 64;
		$ul.animate({marginLeft: marginLeft + 'px'}, function(){
			sliding = false;
		});
		if(marginLeft >= 0){
			$this.addClass('switchable-first');
		}
	});
	
	var avaliable = -1;
	$('.size-list-item').click(function(){
		var $this = $(this);
		if($this.hasClass('sli-selected') || $this.hasClass('sli-disabled')){
			return;
		}
		$this.parent().find('.sli-selected').removeClass('sli-selected');
		$this.addClass('sli-selected');
		avaliable = $this.data('avaliable');
		$('#J-sizeArea-wrap').removeClass('status-notice');
	});
	$('.num-add').click(function(){
		var $this = $(this);
		if($this.hasClass('num-add-disabled')){
			return;
		}
		var num = parseInt($('.num-input').html()) + 1;
		if(avaliable > -1 && num >= avaliable){
			$this.addClass('num-add-disabled');
			num = avaliable;
		}
		$('.num-input').html(num);
		if(num > 1){
			$('.num-reduce').removeClass('num-reduce-disabled');
		}
		$('#J-num-select').removeClass('status-notice');
	});
	$('.num-reduce').click(function(){
		var $this = $(this);
		if($this.hasClass('num-reduce-disabled')){
			return;
		}
		var num = parseInt($('.num-input').html()) - 1;
		if(num <= 1){
			$this.addClass('num-reduce-disabled');
			num = 1;
		}
		$('.num-input').html(num);
		if(avaliable > -1 && num < avaliable){
			$('.num-add').removeClass('num-add-disabled');
		}
		$('#J-num-select').removeClass('status-notice');
	});
	
	$('#cart-form').validate({
		rules: {
			'code': 'required',
			'quantity': {
				required: true
			}
		},
		messages: {
			'code': '请选择尺码',
			'quantity': {
				required: '请选择购买数量'
			}
		},
		errorClass: 'status-notice',
		errorPlacement: function(error, $ele){
			$ele.next().html(error.html());
		},
		highlight: function(element, errorClass, validClass){
			$(element).parent().addClass(errorClass);
		},
		unhighlight: function(element, errorClass, validClass){
			$(element).parent().removeClass(errorClass);
		},
		submitHandler: function(form){
			return false;
		}
	});
	$('#J-cartAdd-submit').click(function(){
		var code = $('.size-list .sli-selected').data('code');
		if(!code){
			//未选择尺码
			$('#J-sizeArea-wrap').addClass('status-notice');
			return;
		}
		var quantity = parseInt($('.num-box .J-pro-num-txt').html());
		if(isNaN(quantity) || quantity < 1){
			//未填写数量
			$('#J-num-select .J-num-tips').html('请选择购买数量');
			$('#J-num-select').addClass('status-notice');
			return;
		}
		if(quantity > avaliable){
			//库存不足
			$('#J-num-select .J-num-tips').html('该尺码库存仅剩' + avaliable + '件');
			$('#J-num-select').addClass('status-notice');
			return;
		}
		$.ajax({
			url: ctx + '/add-to-shopping-cart',
			type: 'POST',
			dataType: 'json',
			data: {
				code: code,
				quantity: quantity
			},
			success: function(response){
				if(response.errors && response.errors.length > 0){
					$('#cart-form').validate().showErrors(response.errors);
					return;
				}
				setTimeout(function(){
					App.loadShoppingCart();
				}, 0);
				setTimeout(function(){
					$('.alert_fullbg').show();
					$('#shopping_alert').show();
				}, 0);
			}
		});
	});
	
	$('body').on('click', '.alert_close', function(){
		$('.alert_fullbg').hide();
		$('#shopping_alert').hide();
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
});