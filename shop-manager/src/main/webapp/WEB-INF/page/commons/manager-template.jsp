<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/commons/tags.jsp" %>
<!DOCTYPE html>
<html lang="zh-cn">
	<head>
		<link rel="stylesheet" href="${ctx}/assets/jquery-easyui-1.4.1/themes/bootstrap/easyui.css">
		<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="${ctx}/assets/css/eshop-manager.css">
		<script src="${ctx}/assets/jquery-easyui-1.4.1/jquery.min.js"></script>
		<script src="http://cdn.bootcss.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
		<script src="${ctx}/assets/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="${ctx}/assets/js/jquery.form.js"></script>
		<script type="text/javascript" src="${ctx}/assets/js/eshop-manager.js"></script>
		<script>
			var ctx = '${ctx}';
		</script>
	</head>
	<body>
		<div id="main-head"></div>
		<div style="height:77px;"></div>
		<div id="main-body">
			<div id="main-left">
				<ul id="sidebar">
					<li>
						<a href="">
							<i class="icon icon-home"></i><span>仪表盘</span>
						</a>
					</li>
					<li class="submenu">
						<a href="javascript:;">
							<i class="icon icon-th-list"></i><span>商品管理</span>
						</a>
						<ul>
							<li><a href="${ctx}/category">分类管理</a></li>
							<li><a href="">标签管理</a></li>
							<li><a href="">商品管理</a></li>
						</ul>
					</li>
					<li class="submenu">
						<a href="javascript:;">
							<i class="icon icon-th-list"></i><span>运费管理</span>
						</a>
						<ul>
							<li><a href="${ctx}/shipping/area-and-shipping">地区和物流</a></li>
							<li><a href="">运费设置</a></li>
						</ul>
					</li>
				</ul>
			</div>
			<div id="main-container">
				<t:insertAttribute name="content"/>
			</div>
		</div>
		<div id="main-foot"></div>
	</body>
</html>