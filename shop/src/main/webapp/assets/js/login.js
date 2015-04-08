$(document).ready(function(){
	$('#login-form').validate({
		rules: {
			'username': {
				required: true
			},
			'password': {
				required: true
			},
			'captcha': {
				required: true
			}
		},
		messages: {
			'username': {
				required: '请输入用户名'
			},
			'password': {
				required: '请输入密码'
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
			var validator = $('#login-form').validate();
			$(form).ajaxSubmit({
				success: function(result){
					if(result.errors){
						validator.showErrors(result.errors);
						return;
					}
					if(result.success){
						document.location.href = ctx;
					}
				}
			});
		}
	});
});