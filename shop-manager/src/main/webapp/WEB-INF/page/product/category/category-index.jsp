<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/commons/tags.jsp" %>
<link rel="stylesheet" href="${ctx}/javascript/zTree_v3/css/zTreeStyle/zTreeStyle.css"/>
<div id="content-header"></div>
<div id="breadcrumb">
	<a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
	<a href="#" class="current">Dashboard</a>
</div>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span4">
			<div class="widget-box">
				<div class="widget-title">
					<span class="icon">
						<i class="icon-align-justify"></i>									
					</span>
					<h5>分类树</h5>
				</div>
				<div class="widget-content">
					<ul id="category-tree" class="ztree">
						
					</ul>
				</div>
			</div>
		</div>
		<div class="span8">
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
<script type="text/javascript" src="${ctx}/javascript/jquery.form.js"></script>
<script type="text/javascript" src="${ctx}/javascript/zTree_v3/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="${ctx}/javascript/product/category.js"></script>