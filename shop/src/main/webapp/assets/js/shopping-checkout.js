$(document).ready(function(){
	initAddressFormValidate();

	$('.address-list').on('click', '.edit-address', function(){
		var $this = $(this);
		if($this.closest('.address-item').next().hasClass('address-form-wrapper')){
			return;
		}
		$.ajax({
			url: ctx + '/load-address-for-shopping',
			data: {
				memberAddressId: $this.siblings('[name="memberAddressId"]').val()
			},
			success: function(form){
				$('<li class="list-group-item address-form-wrapper"></li>').append(form).insertAfter($this.closest('.address-item')).slideDown();
				initAddressFormValidate();
			}
		});
	});
	$('.address-list').on('click', '.add', function(e){
		e.stopPropagation();
		$('.address-form-wrapper').show();
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
	$('.address-list').on('click', '.cancel-edit', function(){
		$('.address-form-wrapper').slideUp(function(){
			$('.address-form-wrapper').remove();
		});
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
	$('.address-form-wrapper').remove();
	onSelectAddress(address);
}
function onSelectAddress(address){
	$('#selected-address').html(address.province + ' ' + address.city + ' ' + address.district + ' ' + address.street + '<br/>' + address.contact + ' ' + address.mobile);
}
function buildAddressHtml(address){
	var html = [];
	html.push('<input type="radio" name="memberAddressId" value="' + address.id + '" checked="checked"/>');
	html.push('<span class="member-address">' + address.firstName + ' ' + address.lastName + ' ' + address.country + ' ' + address.city + '</span>');
	html.push('<a href="javascript:;" class="edit-address">Edit</a>');
	return html.join('');
}

function initAddressFormValidate(){
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
			areaId: {
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
			areaId: {
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
}