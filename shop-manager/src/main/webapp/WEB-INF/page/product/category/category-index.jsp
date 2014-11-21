<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/commons/tags.jsp" %>
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
					<c:if test="${not empty list}">
					<table class="table">
						<c:forEach items="${list}" var="item">
						<tr>
							<td data-id="${item.id}">${item.categoryName}</td>
						</tr>
						</c:forEach>
					</table>
					</c:if>
					<c:if test="${empty list}">
					还没有分类数据,请在右侧填写添加
					</c:if>
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
					<form class="form-horizontal" method="post" action="#" name="basic_validate" id="basic_validate" novalidate="novalidate">
						<div class="control-group">
							<label class="control-label">上级分类</label>
							<div class="controls">
								<select name="parentId">
									<option value="division1">division1</option>
									<option value="division2">division2</option>
									<option value="division3">division3</option>
									<option value="division4">division4</option>
								</select>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">分类名称</label>
							<div class="controls">
								<input type="text" name="divisionName"/>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">属性名称</label>
							<div class="controls">
								<input type="text" name="divisionName"/>
							</div>
						</div>
                	</form>
            	</div>
        	</div>
		</div>
	</div>
</div>