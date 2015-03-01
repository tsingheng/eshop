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
			<div class="widget-box">
				<div class="widget-title">
					<span class="icon">
						<i class="icon-align-justify"></i>									
					</span>
					<h5>分类编辑</h5>
				</div>
				<div class="widget-content nopadding">
					<form class="form-horizontal" method="post" action="${ctx}/category/save" name="basic_validate" id="category-form" novalidate="novalidate">
						<div class="control-group" id="parent-group">
							<label class="control-label">上级分类</label>
							<div class="controls">
								<input type="hidden" name="id" id="id"/>
								<input type="hidden" name="parentId" id="parentId"/>
								<span class="uneditable-input" id="parent-category-name">ROOT</span>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">分类名称</label>
							<div class="controls">
								<input type="text" name="categoryName"/>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">分类编码</label>
							<div class="controls">
								<input type="text" name="categoryCode"/>
							</div>
						</div>
						<div class="form-actions">
							<input class="btn btn-primary ui-wizard-content ui-formwizard-button submit" type="button" value="保存">
						</div>
                	</form>
            	</div>
        	</div>
		</div>
	</div>
</div>
<div id="cate-win" class="easyui-window" data-options="modal:true,closed:true,title:'编辑分类',width:450"></div>
<script type="text/javascript" src="${ctx}/assets/js/product/category.js"></script>