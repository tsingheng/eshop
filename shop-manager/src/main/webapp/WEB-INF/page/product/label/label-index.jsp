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
		<div class="span5">
			<div class="widget-box" id="label-list-wrapper">
				<div class="widget-title">
					<span class="icon">
						<i class="icon-align-justify"></i>									
					</span>
					<h5>标签</h5>
				</div>
				<div class="widget-content">
					<table id="label-list" class="table table-bordered">
						<colgroup>
							<col width="80"/>
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
				</div>
				<div class="widget-foot">
					<div class="pager pull-right" id="label-list-page">
						<div class="input-prepend input-append">
							<a class="btn btn-small" href="javascript:;"><i class="icon-step-backward"></i></a>
							<a class="btn btn-small" href="javascript:;"><i class="icon-arrow-left"></i></a>
							<span class="add-on page-to-jump">去第</span>
							<input type="text" class="page-to-jump"/>
							<span class="add-on page-to-jump">页</span>
							<a class="btn btn-small" href="javascript:;"><i class="icon-arrow-right"></i></a>
							<a class="btn btn-small" href="javascript:;"><i class="icon-step-forward"></i></a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="span7">
			<div class="widget-box">
				<div class="widget-title">
					<span class="icon">
						<i class="icon-align-justify"></i>									
					</span>
					<h5></h5>
				</div>
				<div class="widget-content nopadding">
					
            	</div>
        	</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="${ctx}/javascript/jquery.form.js"></script>