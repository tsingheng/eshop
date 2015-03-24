<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="row">
	<div class="col-md-6">
		
	</div>
	
	<div class="col-md-6">
		<form class="form-horizontal" method="POST" id="register-form" action="${ctx}/login" onsubmit="return false;">
			<div class="form-group">
				<label for="email" class="col-sm-2 control-label">邮箱/手机号码</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="username" name="username">
				</div>
			</div>

			<div class="form-group">
				<label for="password" class="col-sm-2 control-label">账户密码</label>
				<div class="col-sm-6">
				<input type="password" class="form-control" id="password" name="pass.password">
				</div>
			</div>

			<div class="form-group">
				<label for="verify" class="col-sm-2 control-label">验证码</label>
				<div class="col-sm-6">
				<div class="input-group">
					<input type="text" class="form-control" id="verify" name="verify">
					<span class="input-group-addon verify"></span>
				</div>
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-8 col-sm-offset-2">
					<button class="btn btn-default" id="login-submit">登录</button>
				</div>
			</div>
		</form>
	</div>
</div>
<script type="text/javascript" src="${ctx}/assets/jquery-validation-1.13.1/jquery.validate.js"></script>
<script type="text/javascript" src="${ctx}/assets/js/login.js"></script>