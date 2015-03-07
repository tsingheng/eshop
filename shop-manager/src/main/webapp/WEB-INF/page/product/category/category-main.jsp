<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/commons/tags.jsp" %>
<ol class="breadcrumb">
	<li><a href="javascript:;">Home</a></li>
	<li><a href="javascript:;">商品管理</a></li>
	<li class="active">商品分类管理</li>
</ol>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-3">
			<div class="panel panel-default panel-tree">
				<div class="panel-heading">
					<div class="caption">分类树</div>
				</div>
				<div class="panel-body">
					<ul id="category-tree" data-options="">
						
					</ul>
				</div>
			</div>
		</div>
		<div class="col-md-9">
			<div class="panel panel-default">
				<div class="panel-heading">
				<div class="caption">商品列表</div>
				</div>
				<div class="panel-body nopadding">
					<table id="product-table"></table>
				</div>
			</div>
		</div>
	</div>
</div>
<div id="cate-win" class="easyui-window" data-options="modal:true,closed:true,title:'编辑分类',width:450"></div>
<script type="text/javascript" src="${ctx}/assets/js/product/category.js"></script>