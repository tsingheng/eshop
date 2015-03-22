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
	});
});