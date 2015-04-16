$(document).ready(function(){
	$('#shipping-list .shipping-item').click(function(){
		var $this = $(this);
		if($this.hasClass('active')){
			return;
		}
		$this.siblings('.active').removeClass('active');
		$this.addClass('active');
		var shippingId = $this.data('id');
		$.ajax({
			url: ctx + '/shipping/freight-template',
			data: {
				shippingId: shippingId
			},
			success: function(templates){
				var html = [];
				for(var i in templates){
					var template = templates[i];
					html.push('<tr>');
					html.push('	<th>' + template.areaName + '</th>');
					html.push('	<td>');
					html.push('		<form class="form-inline">');
					html.push('			<input type="hidden" name="areaId" value="' + template.areaId + '"/>');
					html.push('			<input type="hidden" name="shippingId" value="' + shippingId + '"/>');
					html.push('			<div class="form-group">');
					html.push('				<label for="firstWeight">首重</label>');
					html.push('				<input type="text" name="firstWeight" class="form-control" old="' + (template.firstWeight || '') + '" value="' + (template.firstWeight || '') + '"/>');
					html.push('			</div>');
					html.push('			<div class="form-group">');
					html.push('				<label for="firstPrice">首重价格</label>');
					html.push('				<input type="text" name="firstPrice" class="form-control" old="' + (template.firstPrice || '') + '" value="' + (template.firstPrice || '') + '"/>');
					html.push('			</div>');
					html.push('			<div class="form-group">');
					html.push('				<label for="additionalUnit">续重单位</label>');
					html.push('				<input type="text" name="additionalUnit" class="form-control" old="' + (template.additionalUnit || '') + '" value="' + (template.additionalUnit || '') + '"/>');
					html.push('			</div>');
					html.push('			<div class="form-group">');
					html.push('				<label for="additionalPrice">续重价格</label>');
					html.push('				<input type="text" name="additionalPrice" class="form-control" old="' + (template.additionalPrice || '') + '" value="' + (template.additionalPrice || '') + '"/>');
					html.push('			</div>');
					html.push('			<a href="javascript:;" class="btn btn-default submit hidden">保存</button>');
					html.push('		</form>');
					html.push('	</td>');
					html.push('</tr>');
				}
				$('#freight-template-wrapper').html(html.join(''));
			}
		});
	});
	
	$('#freight-template-wrapper').on('blur', 'input', function(){
		var $this = $(this);
		var old = $this.attr('old');
		var val = $this.val();
		if(old == val){
			return;
		}
		$this.attr('old', val);
		$this.closest('form').find('.submit').removeClass('hidden');
	});
	$('#freight-template-wrapper').on('click', '.submit', function(){
		var $this = $(this);
		$(this).closest('form').ajaxSubmit({
			url: ctx + '/shipping/save-freight',
			type: 'POST',
			success: function(response){
				$this.addClass('hidden');
			}
		});
	});
});