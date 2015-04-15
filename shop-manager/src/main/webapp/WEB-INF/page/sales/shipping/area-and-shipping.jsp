<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<ol class="breadcrumb">
	<li><a href="javascript:;">Home</a></li>
	<li><a href="javascript:;">运费管理</a></li>
	<li class="active">地区和物流方式管理</li>
</ol>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-6">
			<div class="panel panel-default panel-tree">
				<div class="panel-heading">
					<div class="caption">国家地区</div>
				</div>
				<div class="panel-body">
					<div class="list-group">
						<c:forEach items="${areaList}" var="item">
						<a href="javascript:;" class="list-group-item">${item.name}</a>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div class="panel panel-default">
				<div class="panel-heading">
				<div class="caption">物流</div>
				</div>
				<div class="panel-body nopadding">
					<div class="list-group">
						<c:forEach items="${shippingList}" var="item">
						<a href="javascript:;" class="list-group-item">${item.name}</a>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>