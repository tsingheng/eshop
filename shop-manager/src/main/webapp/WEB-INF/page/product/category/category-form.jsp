<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form class="form-horizontal" id="cate-form" method="post">
	<input type="hidden" name="id" value="${category.id}">
	<c:if test="${not empty parent}">
	<div class="form-group">
		<label for="parentId" class="col-sm-3 control-label">上级分类</label>
		<div class="col-sm-9">
			<a href="javascript" class="btn btn-default">${parent.name}</a>
			<input type="hidden" id="parentId" name="parentId" value="${parent.id}">
		</div>
	</div>
	</c:if>
	<div class="form-group">
		<label for="name" class="col-sm-3 control-label">分类名称</label>
		<div class="col-sm-9">
			<input type="text" name="name" class="form-control" id="name" placeholder="分类名称" autocomplete="off" value="${category.name}">
		</div>
	</div>
	<div class="form-group">
		<label for="code" class="col-sm-3 control-label">分类编码</label>
		<div class="col-sm-9">
			<input type="text" name="code" class="form-control" id="code" placeholder="分类编码" autocomplete="off" value="${category.code}">
		</div>
	</div>
</form>
<div class="pull-right">
	<button class="btn btn-primary submit">确 定</button>
	<button class="btn btn-default btn-cancel" style="margin-left:20px;">取 消</button>
</div>