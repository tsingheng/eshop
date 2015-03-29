<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="zh-cn">
	<head>
		<meta property="qc:admins" content="43036231470630167453066547" />
		<jsp:include page="css-and-scripts.jsp"/>
	</head>
	<body>
		<jsp:include page="header-toolbar.jsp"/>
		<div id="nav">
			<t:insertAttribute name="nav"/>
		</div>
		<div id="main">
			<t:insertAttribute name="content"/>
		</div>
	</body>
</html>
