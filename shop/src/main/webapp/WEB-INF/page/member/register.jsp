<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="math" uri="http://www.shangtech.net/tags/math"%>
<div class="heads" style="background: url(/shop/assets/img/img02.jpg) center center;">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2><span>//</span> Single Item</h2>
			</div>
		</div>
	</div>
</div>

<div class="page-content">
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				
			</div>
			
			<div class="col-md-6">
				<form class="form-horizontal" method="POST" id="register-form" action="${ctx}/register" onsubmit="return false;">
					<div class="form-group">
						<label for="email" class="col-sm-2 control-label">邮箱</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="email" name="email">
						</div>
					</div>
					
					<div class="form-group">
						<label for="mobile" class="col-sm-2 control-label">手机号码</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="mobile" name="mobile">
						</div>
					</div>
		
					<div class="form-group">
						<label for="gender" class="col-sm-2 control-label">性别</label>
						<div class="col-sm-6">
							<label class="control-label col-sm-5">
								<input type="radio" name="gender" value="MEN">
								男
							</label>
							<label class="control-label col-sm-5">
								<input type="radio" name="gender" value="MEN">
								女
							</label>
						</div>
					</div>
		
					<div class="form-group">
						<label for="password" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-6">
						<input type="password" class="form-control" id="password" name="pass.password">
						</div>
					</div>
		
					<div class="form-group">
						<label for="passconfirm" class="col-sm-2 control-label">确认密码</label>
						<div class="col-sm-6">
						<input type="password" class="form-control" id="passconfirm" name="pass.passconfirm">
						</div>
					</div>
		
					<div class="form-group">
						<label for="verify" class="col-sm-2 control-label">验证码</label>
						<div class="col-sm-6">
						<div class="input-group">
							<input type="text" class="form-control" id="captcha" name="captcha">
							<span class="input-group-addon captcha" data-url="${ctx}/captcha" style="background-image:url('${ctx}/captcha?${math:random()}')"></span>
						</div>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-3 col-sm-offset-2">
							<button class="btn btn-default" id="register-submit">提交注册</button>
						</div>
						<div class="col-sm-4">
							<a href="${ctx}/login" class="btn btn-default">已有账号</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="${ctx}/assets/jquery-validation-1.13.1/jquery.validate.js"></script>
<script type="text/javascript" src="${ctx}/assets/js/register.js"></script>