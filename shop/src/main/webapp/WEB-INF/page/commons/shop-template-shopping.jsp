<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="zh-cn">
	<head>
		<jsp:include page="css-and-scripts.jsp"/>
	</head>
	<body>
		<jsp:include page="header-toolbar.jsp"/>
		<t:insertAttribute name="nav"/>
		<div id="main">
			<t:insertAttribute name="content"/>
		</div>
	</body>
</html>