$(document).ready(function(){
	$('#addrform').validate({
		rules: {
			contact: {
				required: true
			},
			province: 'required',
			city: 'required',
			district: 'required',
			street: {
				required: true
			},
			mobile: {
				required: true
			},
			postcode: {
				required: true
			}
		},
		messages: {
			contact: {
				required: '请填写联系人姓名'
			},
			province: '请选择省份',
			city: '请选择城市',
			district: '请选择地区',
			street: {
				required: '请填写街道地址'
			},
			mobile: {
				required: '请填写手机号码'
			},
			postcode: {
				required: '请填写邮政编码'
			}
		},
		errorElement: 'p',
		errorClass: 's13',
		errorPlacement: function(error, ele){
			if(ele.is('select')){
				if(ele.parent().find('.s13').length == 0){
					ele.parent().append(error);
				}
			}else{
				if(!ele.next().hasClass('s13')){
					error.insertAfter(ele);
				}
			}
		},
		highlight: function(element, errorClass, validClass){
			$(element).next('p').hide();
		},
		submitHandler: function(form){
			var validator = $('#addrform').validate();
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
	
	$province = $('#province'), $city = $('#city'), $district = $('#district');
	$province.append(findChildrenArea('1'));
	$province.change(function(){
		$city.find('option:gt(0)').remove();
		$district.find('option:gt(0)').remove();
		var province = $province.find('option:selected').data('code');
		if(province){
			$city.append(findChildrenArea(province));
		}
	});
	$city.change(function(){
		$district.find('option:gt(0)').remove();
		var city = $city.find('option:selected').data('code');
		if(city){
			$district.append(findChildrenArea(city));
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
		$('#myAddress li.cur').removeClass('cur');
		$this.addClass('cur');
		onSelectAddress(buildAddressObject($this));
	});
	$('#addrform').on('click', '.quxiao', function(){
		$('#addrform')[0].reset();
		$('#addrform').hide();
	});
});

function findChildrenArea(parent){
	var children = [];
	for(var a in area){
		if(area[a][1] == parent){
			children.push('<option data-code="');
			children.push(a);
			children.push('" value="');
			children.push(area[a][0]);
			children.push('">');
			children.push(area[a][0]);
			children.push('</option>');
		}
	}
	return children.join('');
}
function doUpdateAddress(address){
	var $address = $(buildAddressHtml(address));
	var $old = $('#address-' + address.id);
	$('#myAddress .cur').removeClass('cur');
	if(address.isDefault){
		$('#myAddress .default-add').remove();
	}
	if($old.length > 0){
		$old.html($address.html());
		$old.addClass('cur');
	}else if($('#myAddress li').length > 0){
		$address.insertBefore($('#myAddress li:last'));
	}else{
		$('#myAddress').append($address);
	}
	$('#addrform').hide();
	$('#addrform')[0].reset();
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