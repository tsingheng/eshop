$(document).ready(function(){
	
	$('.img-slider-list li').hover(function(){
		var $this = $(this);
		if($this.hasClass('active')){
			return;
		}
		$this.parent().find('.active').removeClass('active');
		$this.addClass('active');
		var imgSrc = $this.data('src');
		$('.jqzoom').attr('href', imgSrc.replace('_#size#', ''));
		$('.jqzoom').html('<img id="jq-zoom" src="' + imgSrc.replace('#size#', '1') + '"/>');
		$('.jqzoom').data('jqzoom', '').jqzoom({zoomType:"standard",title:false,lens:false,alwaysOn:false,zoomWidth:400,zoomHeight:400});
	});
	$('.img-slider-list li:first').trigger('mouseover');
	if($('.img-slider-list li').length == 0){
		$('.jqzoom').jqzoom({zoomType:"standard",title:false,lens:false,alwaysOn:false,zoomWidth:400,zoomHeight:400});
	}
	
	$('#product-details img[data-src]').each(function(){
		$(this).attr('src', $(this).data('src'));
	});
	
	var sliding = false;
	var slideUnit = $('.img-slider-list ul li:first').width() + 7;
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
		marginLeft -= slideUnit;
		$ul.animate({marginLeft: marginLeft + 'px'}, function(){
			sliding = false;
		});
		if(-marginLeft >= ($ul.children().length-5)*slideUnit){
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
		marginLeft += slideUnit;
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
		if($this.hasClass('disabled')){
			return;
		}
		var num = parseInt($('#quantity').val()) + 1;
		if(avaliable > -1 && num >= avaliable){
			$this.addClass('disabled');
			num = avaliable;
		}
		$('#quantity').val(num);
		if(num > 1){
			$('.num-reduce').removeClass('disabled');
		}
	});
	$('.num-reduce').click(function(){
		var $this = $(this);
		if($this.hasClass('disabled')){
			return;
		}
		var num = parseInt($('#quantity').val()) - 1;
		if(num <= 1){
			$this.addClass('disabled');
			num = 1;
		}
		$('#quantity').val(num);
		if(avaliable > -1 && num < avaliable){
			$('.num-add').removeClass('disabled');
		}
	});
	
	$('#cart-form').validate({
		rules: {
			'quantity': {
				required: true
			}
		},
		messages: {
			'quantity': {
				required: '请选择购买数量'
			}
		},
		errorClass: 'has-error',
		errorPlacement: function(error, $ele){
			$('#error-wrapper').html(error.html()).show();
		},
		highlight: function(element, errorClass, validClass){
			$(element).parent().addClass(errorClass);
		},
		unhighlight: function(element, errorClass, validClass){
			$(element).parent().removeClass(errorClass);
		},
		submitHandler: function(form){
			$(form).ajaxSubmit({
				url: ctx + '/add-to-shopping-cart',
				success: function(response){
					if(response.errors){
						$('#cart-form').validate().showErrors(response.errors);
						return;
					}
					setTimeout(function(){
						App.loadShoppingCart();
					}, 0);
				}
			});
		}
	});
	
	$('body').on('click', '.alert_close', function(){
		$('.alert_fullbg').hide();
		$('#shopping_alert').hide();
	});
	
});