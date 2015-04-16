<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<ol class="breadcrumb">
	<li><a href="javascript:;">Home</a></li>
	<li><a href="javascript:;">运费管理</a></li>
	<li class="active">运费模板</li>
</ol>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-4">
			<div class="list-group" id="shipping-list">
			<c:forEach items="${shippingList}" var="item">
				<a class="list-group-item shipping-item" href="javascript:;" data-id="${item.id}">${item.name}</a>
			</c:forEach>
			</div>
		</div>
		<div class="col-md-8">
			<div class="panel panel-default">
				<div class="panel-heading">
				<div class="caption">运费模板</div>
				</div>
				<div class="panel-body">
					<table id="freight-template-wrapper">
							<%-- 
							<tr>
								<th>China</th>
								<td>
									<form class="form-inline">
										<div class="form-group">
											<label for="firstWeight">首重</label>
											<input type="text" name="firstWeight" class="form-control"/>
										</div>
										<div class="form-group">
											<label for="firstPrice">首重价格</label>
											<input type="text" name="firstPrice" class="form-control"/>
										</div>
										<div class="form-group">
											<label for="additionalUnit">续重单位</label>
											<input type="text" name="additionalUnit" class="form-control"/>
										</div>
										<div class="form-group">
											<label for="additionalPrice">续重价格</label>
											<input type="text" name="additionalPrice" class="form-control"/>
										</div>
										<a href="javascript:;" class="btn btn-default submit">保存</button>
									</form>
								</td>
							</tr>
							--%>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="${ctx}/assets/js/sales/freight.js"></script>