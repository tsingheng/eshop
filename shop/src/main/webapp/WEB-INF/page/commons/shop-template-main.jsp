<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/commons/tags.jsp" %>
<!DOCTYPE html>
<html lang="zh-cn">
	<head>
		<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="${ctx}/assets/css/shop.css">
		<script type="text/javascript" src="${ctx}/assets/js/jquery.min.js"></script>
		<script type="text/javascript" src="http://cdn.bootcss.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${ctx}/assets/js/jquery.form.js"></script>
		<script type="text/javascript" src="${ctx}/assets/js/shop.js"></script>
		<script>
			var ctx = '${ctx}';
		</script>
	</head>
	<body>
		<div id="header">
			
		</div>
		<div id="nav">
			<t:insertAttribute name="nav"/>
		</div>
		<div id="main">
			<t:insertAttribute name="content"/>
		</div>
	</body>
</html>