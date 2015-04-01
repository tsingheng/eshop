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
					if(response.errors.length > 0){
						validator.showErrors(response.errors);
						return;
					}
					if(!response.success){
						alert(response.messaeg);
						return;
					}
					
				}
			});
		}
	});
	
	$province = $('#province'), $city = $('#city'), district = $('#district');
	$province.append(findChildrenArea('1'));
	$province.change(function(){
		$city.find('option:gt(0)').remove();
		$district.find('option:gt(0)').remove();
		var province = $province.find('option:selected').val();
		if(province){
			$city.append(findChildrenArea(province));
		}
	});
	$city.change(function(){
		$district.find('option:gt(0)').remove();
		var city = $city.find('option:selected').val();
		if(city){
			$district.append(findChildrenArea(city));
		}
	});
});

function findChildrenArea(parent){
	var children = [];
	for(var a in area){
		if(area[a][1] == parent){
			children.push('<option value="');
			children.push(a);
			children.push('">');
			children.push(area[a][0]);
			children.push('</option>');
		}
	}
	return children.join('');
}