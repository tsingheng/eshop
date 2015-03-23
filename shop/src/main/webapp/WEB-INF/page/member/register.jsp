<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="row">
	<div class="col-md-8">
		
	</div>
	
	<div class="col-md-3">
		<form method="POST" action="${ctx}/register">
			<div class="form-group">
				<label for="email">邮箱</label>
				<input type="text" class="form-control" id="email" name="email">
			</div>

			<div class="form-group">
				<label for="gender">性别</label>
				<input type="text" class="form-control" id="gender" name="gender">
			</div>

			<div class="form-group">
				<label for="password">密码</label>
				<input type="password" class="form-control" id="password" name="pass.password">
			</div>

			<div class="form-group">
				<label for="passconfirm">确认密码</label>
				<input type="password" class="form-control" id="passconfirm" name="pass.passconfirm">
			</div>

			<div class="form-group">
				<label for="verify">验证码</label>
				<div class="input-group">
					<input type="text" class="form-control" id="verify" name="verify">
					<span class="input-group-addon verify"></span>
				</div>
			</div>
			
			<div class="form-group">
				<div class="input-group">
					<button class="btn btn-default">提交注册</button>
				</div>
			</div>
		</form>
	</div>
</div>