<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/commons/tags.jsp" %>
<div class="modal-header">
	<button class="close" type="button" data-dismiss="modal" aria-hidden="true"></button>
	<c:if test="${not empty label}">
	<h3>标签编辑</h3>
	</c:if>
	<c:if test="${empty label}">
	<h3>新建标签</h3>
	</c:if>
</div>
<div class="modal-body">
	<form id="label-form" action="${ctx}/label/save" class="form-horizontal">
		<div class="control-group">
			<label class="control-label">标签名称<span class="required">*</span></label>
			<div class="controls">
				<input type="text" name="labelName" value="${label.labelName}"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">标签编码<span class="required">*</span></label>
			<div class="controls">
				<input type="text" name="labelCode" value="${label.labelCode}"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">标签权重<span class="required">*</span></label>
			<div class="controls">
				<input type="text" name="priority" value="${label.priority}"/>
			</div>
		</div>
	</form>
</div>
<div class="modal-footer">
	<button type="button" data-dismiss="modal" class="btn">取消</button>
	<button type="button" class="btn blue submit">保存</button>
</div>