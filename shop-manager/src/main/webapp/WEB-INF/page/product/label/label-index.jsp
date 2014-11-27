<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/commons/tags.jsp" %>
<link rel="stylesheet" href="${ctx}/javascript/zTree_v3/css/zTreeStyle/zTreeStyle.css"/>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span5">
			<div class="portlet box blue relative" id="label-list-wrapper">
				<div class="portlet-title">
					<div class="caption">商品标签管理</div>
					<div class="actions" id="label-actions">
						<a href="javascript:;" class="btn add">
							<i class="icon-plus"></i>
							添加标签
						</a>
						<a href="javascript:;" class="btn edit">
							<i class="icon-plus"></i>
							编辑标签
						</a>
						<a href="javascript:;" class="btn remove">
							<i class="icon-plus"></i>
							删除所选
						</a>
						<a href="javascript:;" class="btn manage">
							<i class="icon-plus"></i>
							管理商品
						</a>
					</div>
				</div>
				<div class="portlet-body">
					<div class="dataTables_wrapper">
						<table id="label-list" url="${ctx}/label/list" class="table table-bordered table-hover">
							<colgroup>
								<col width="40"/>
								<col data-index="labelName"/>
								<col data-index="labelCode"/>
							</colgroup>
							<thead>
								<tr>
									<th><input type="checkbox"/></th>
									<th>标签名称</th>
									<th>标签编码</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="center"><input type="checkbox"/></td>
									<td>标签名称</td>
									<td>标签编码</td>
								</tr>
							</tbody>
						</table>
						<div class="row-fluid" id="label-list-pager">
							<div class="span6">
								<div class="dataTables_info page-info" id="sample_1_info"></div>
							</div>
							<div class="span6">
								<div class="dataTables_paginate paging_bootstrap pagination">
									<ul>
										<li class="disabled"><a href="#" class="first"><i class="icon-step-backward"></i></a></li>
										<li class="active"><a href="#" class="prev"><i class="icon-chevron-left"></i></a></li>
										<li class="disabled"><a href="javascript:;" class="no-border-right">去第</a></li>
										<li><input type="text" class="page-no"/></li>
										<li class="disabled"><a href="javascript:;">页</a></li>
										<li><a class="next" href="#"><i class="icon-chevron-right"></i></a></li>
										<li><a href="#" class="last"><i class="icon-step-forward"></i></a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="span7">
			<div class="portlet box blue">
				<div class="portlet-title">
					<div class="caption">标签商品管理</div>
					<div class="actions">
						<a href="javascript:;" class="btn">
							<i class="icon-plus"></i>
							添加商品
						</a>
						<a href="javascript:;" class="btn">
							<i class="icon-plus"></i>
							删除所选
						</a>
					</div>
				</div>
				<div class="portlet-body">
					<div class="dataTables_wrapper">
						<table id="label-list" class="table table-bordered">
							<colgroup>
								<col width="40"/>
								<col width="80"/>
								<col data-index="labelName"/>
								<col data-index="labelCode"/>
							</colgroup>
							<thead>
								<tr>
									<th><input type="checkbox"/></th><th>序号</th><th>标签名称</th><th>标签编码</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="center"><input type="checkbox"/></td>
									<td>序号</td>
									<td>标签名称</td>
									<td>标签编码</td>
								</tr>
							</tbody>
						</table>
						<div class="row-fluid" id="label-list-pager">
							<div class="span6">
								<div class="dataTables_info page-info" id="sample_1_info">Showing 1 to 5 of 25 entries</div>
							</div>
							<div class="span6">
								<div class="dataTables_paginate paging_bootstrap pagination">
									<ul>
										<li class="prev disabled"><a href="#"><i class="icon-step-backward"></i></a></li>
										<li class="active"><a href="#"><i class="icon-chevron-left"></i></a></li>
										<li class="disabled"><a href="javascript:;" class="no-border-right">去第</a></li>
										<li><input type="text"/></li>
										<li class="disabled"><a href="javascript:;">页</a></li>
										<li><a href="#"><i class="icon-chevron-right"></i></a></li>
										<li class="next"><a href="#"><i class="icon-step-forward"></i></a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
            	</div>
        	</div>
		</div>
	</div>
</div>
<div id="label-modal" class="modal hide fade"></div>
<script type="text/javascript" src="${ctx}/javascript/jquery.form.js"></script>
<script type="text/javascript" src="${ctx}/javascript/product/label.js"></script>