$(document).ready(function(){
	$('#address-form').validate({
		rules: {
			firstName: {
				required: true
			},
			lastName: {
				required: true
			},
			state: 'required',
			city: {
				required: true
			},
			address: {
				required: true
			},
			mobile: {
				required: true
			},
			postcode: {
				required: true
			},
			countryId: {
				required: true
			},
			company: {
				required: true
			}
		},
		messages: {
			firstName: {
				required: ''
			},
			lastName: {
				required: ''
			},
			state: '请选择省份',
			city: '请选择城市',
			address: {
				required: '请填写街道地址'
			},
			mobile: {
				required: '请填写手机号码'
			},
			postcode: {
				required: '请填写邮政编码'
			},
			companyId: {
				required: ''
			},
			country: {
				required: ''
			}
		},
		errorClass: 'has-error',
		errorPlacement: function(error, ele){
			var formGroup = ele.closest('.form-group');
			if(formGroup.find('[id^=-error]').length == 0){
				formGroup.append(error.addClass('control-label'));
			}
		},
		highlight: function(element, errorClass, validClass){
			$(element).closest('.form-group').addClass(errorClass);
		},
		unhighlight: function(element, errorClass, validClass){
			$(element).closest('.form-group').removeClass(errorClass);
		},
		submitHandler: function(form){
			var validator = $('#address-form').validate();
			$(form).ajaxSubmit({
				dataType: 'json',
				success: function(response){
					if(response.errors){
						validator.showErrors(response.errors);
						return;
					}
					if(!response.success){
						alert(response.messaeg);
						return;
					}
					doUpdateAddress(response.data);
				}
			});
		}
	});
	
	$('#myAddress').on('click', '.modify', function(e){
		e.stopPropagation();
		var $address = $(this).closest('li');
		var address = buildAddressObject($address);
		$('#addrform input[type="text"]').each(function(){
			$(this).val(address[$(this).attr('name')]);
		});
		$('#addrform').show();
		$('#id').val(address.id);
		$province.find('option[value="' + address.province + '"]').attr('selected', 'selected');
		$province.trigger('change');
		$city.find('option[value="' + address.city + '"]').attr('selected', 'selected');
		$city.trigger('change');
		$district.find('option[value="' + address.district + '"]').attr('selected', 'selected');
		$district.trigger('change');
		if(address.isDefault){
			$('#J_SetDefault').attr('checked', 'checked');
		}else{
			$('#J_SetDefault').removeAttr('checked');
		}
		$('#addrform .quxiao').show();
	});
	$('#myAddress').on('click', '.add', function(e){
		e.stopPropagation();
		$('#addrform')[0].reset();
		$('#addrform').show();
		$('#addrform .quxiao').show();
	});
	$('#myAddress').on('click', 'li[id]', function(){
		var $this = $(this);
		if($this.hasClass('cur')){
			return;
		}
		var address = buildAddressObject($this);
		$.ajax({
			url: ctx + '/select-address',
			dataType: 'json',
			data: {
				addressId: address.id
			},
			success: function(response){
				if(response.success){
					$('#myAddress li.cur').removeClass('cur');
					$this.addClass('cur');
					onSelectAddress(address);
				}
			}
		});
	});
	$('#addrform').on('click', '.quxiao', function(){
		$('#addrform')[0].reset();
		$('#addrform').hide();
	});
	
	$('.go_pay').click(function(){
		var $this = $(this);
		if($this.hasClass('no')){
			return;
		}
		$this.addClass('no');
		$('#create-order').ajaxSubmit({
			success: function(response){
				if(!response.success){
					$this.removeClass('no');
				}
			}
		});
	});
});

function doUpdateAddress(address){
	var $address = $('#address-form').closest('.list-group-item').prev();
	$address.html(buildAddressHtml(address));
	onSelectAddress(address);
}
function onSelectAddress(address){
	$('#selected-address').html(address.province + ' ' + address.city + ' ' + address.district + ' ' + address.street + '<br/>' + address.contact + ' ' + address.mobile);
}
function buildAddressHtml(address){
	var html = [];
	html.push('<li data-id="' + address.id + '" id="address-' + address.id + '" class="cur">');
	html.push('	<div class="fl">');
	html.push('		<div class="slice-border">');
	html.push('			<div class="area-sumary">');
	html.push('				<span class="area-name name">' + address.contact + '</span>收');
	html.push('			</div>');
	html.push('		</div>');
	html.push('	<div class="mb5">');
	html.push('		<span class="area-address street">' + address.street + '</span> ');
	html.push('		<span class="area-postcode">' + address.postcode + '</span>');
	html.push('	</div>');
	html.push('	<div class="province" data-province="' + address.province + '" data-city="' + address.city + '" data-district="' + address.district + '">' + address.province + ' ' + address.city + ' ' + address.district + '</div>');
	html.push('		<div>');
	html.push('			<span class="area-mobile phone">' + address.mobile + '</span>');
	html.push('			<a href="javascript:void(0);" class="addr-edit modify">修改</a>');
	html.push('		</div>');
	html.push('	</div>');
	html.push('	<div class="slt-icon"></div>');
	if(address.isDefault){
		html.push('	<div class="default-add">默认地址</div>');
	}
	html.push('	<div class="slt-icon"></div>');
	html.push('</li>');
	return html.join('');
}
function buildAddressObject($address){
	var address = {};
	address['contact'] = $.trim($address.find('.name').html());
	address['street'] = $.trim($address.find('.street').html());
	address['postcode'] = $.trim($address.find('.area-postcode').html());
	address['province'] = $.trim($address.find('.province').data('province'));
	address['city'] = $.trim($address.find('.province').data('city'));
	address['district'] = $.trim($address.find('.province').data('district'));
	address['mobile'] = $.trim($address.find('.area-mobile').html());
	address['isDefault'] = $address.find('.default-add').length > 0;
	address['id'] = $address.data('id');
	return address;
}