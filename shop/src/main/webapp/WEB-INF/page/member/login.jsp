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
				<form class="form-horizontal" method="POST" id="login-form" action="${ctx}/login" onsubmit="return false;">
					<div class="form-group">
						<label for="email" class="col-sm-2 control-label">邮箱/手机</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="username" name="username">
						</div>
					</div>
		
					<div class="form-group">
						<label for="password" class="col-sm-2 control-label">账户密码</label>
						<div class="col-sm-6">
						<input type="password" class="form-control" id="password" name="password">
						</div>
					</div>
		
					<div class="form-group">
						<label for="verify" class="col-sm-2 control-label">验证码</label>
						<div class="col-sm-6">
						<div class="input-group">
							<input type="text" class="form-control" id="captcha" name="captcha">
							<span class="input-group-addon captcha" data-url="captcha" style="background-image:url('${ctx}/captcha?${math:random()}')"></span>
						</div>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-3 col-sm-offset-2">
							<button class="btn btn-default" id="login-submit">登录</button>
						</div>
						<div class="col-sm-4">
							<a href="${ctx}/register" class="btn btn-default">去注册</a>
						</div>
					</div>
					
					<div class="form-group oauth-group">
						<div class="col-sm-2"><a href="javascript:;" class="oauth-link"><i class="icon-qq"></i></a></div>
						<div class="col-sm-2"><a href="javascript:;" class="oauth-link"><i class="icon-weibo"></i></a></div>
						<div class="col-sm-2"><a href="javascript:;" class="oauth-link"><i class="icon-alipay"></i></a></div>
						<div class="col-sm-2"><a href="javascript:;" class="oauth-link"><i class="icon-wechat"></i></a></div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="${ctx}/assets/jquery-validation-1.13.1/jquery.validate.js"></script>
<script type="text/javascript" src="${ctx}/assets/js/login.js"></script>