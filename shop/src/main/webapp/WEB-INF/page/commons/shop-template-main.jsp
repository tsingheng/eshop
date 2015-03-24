<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/commons/tags.jsp" %>
<!DOCTYPE html>
<html lang="zh-cn">
	<head>
		<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="${ctx}/assets/css/shop.css">
		<link rel="stylesheet" href="${ctx}/assets/jqzoom/css/jquery.jqzoom.css">
		<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.min.js"></script>
		<script type="text/javascript" src="${ctx}/assets/js/jquery.form.js"></script>
		<script type="text/javascript" src="${ctx}/assets/js/shop.js"></script>
		<script>
			var ctx = '${ctx}';
		</script>
	</head>
	<body>
		<div id="header">
			<div class="header-nav">
				<ul class="header-nav-tools">
					<li>
						<a href="${ctx}/login">登录</a>
						<span>|</span>
						<a href="${ctx}/register">注册</a>
					</li>
				</ul>
			</div>
		</div>
		<div id="nav">
			<t:insertAttribute name="nav"/>
		</div>
		<div id="main">
			<t:insertAttribute name="content"/>
		</div>
	</body>
</html>