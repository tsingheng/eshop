$(document).ready(function(){
	$('#register-form').validate({
		rules: {
			'email': {
				required: true,
				maxlength: 30
			},
			'mobile': {
				required: true,
				minlength: 11,
				maxlength: 11,
				digits: true
			},
			'gender': 'required',
			'pass.password': {
				required: true,
				minlength: 8,
				maxlength: 16
			},
			'pass.passconfirm': {
				required: true,
				equalTo: '#password'
			},
			'captcha': {
				required: true
			}
		},
		messages: {
			'email': {
				required: '请填写邮箱',
				maxlength: '邮箱不能超过30个字符'
			},
			'mobile': {
				required: '请填写手机号码',
				minlength: '手机号码格式不正确',
				maxlength: '手机号码格式不正确',
				digits: '手机号码格式不正确'
			},
			'gender': '请选择性别',
			'pass.password': {
				required: '请输入账户密码',
				minlength: '密码由8-16位字符组成',
				maxlength: '密码由8-16位字符组成'
			},
			'pass.passconfirm': {
				required: '请再次输入账户密码',
				minlength: '密码由8-16位字符组成',
				maxlength: '密码由8-16位字符组成',
				equalTo: '两次密码输入不一致'
			},
			'captcha': {
				required: '请输入验证码'
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
			var validator = this;
			$(form).ajaxSubmit({
				success: function(result){
					if(result.errors){
						validator.showErrors(result.errors);
						return;
					}
					if(result.success){
						document.location.href = '';
					}
				}
			});
		}
	});
});