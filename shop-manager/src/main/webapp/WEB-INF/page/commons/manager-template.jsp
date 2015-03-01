<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/commons/tags.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.2/css/bootstrap.min.css">
		
		<script src="http://cdn.bootcss.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div id="main-head"></div>
		<div id="main-body">
			<div id="main-left"></div>
			<div id="main-container">
				<t:insertAttribute name="content"/>
			</div>
		</div>
		<div id="main-foot"></div>
	</body>
</html>