<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form id="address-form" action="${ctx}/save-address" method="post" class="form-horizontal">
	<div class="form-group">
		<label class="col-sm-2 control-label">Fisrt Name</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" name="firstName" value="${address.firstName}">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">Last Name</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" name="lastName" value="${address.lastName}">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">Company</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" name="company" value="${address.company}">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">Address</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" name="address" value="${address.address}">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">City</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" name="city" value="${address.city}">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">Country</label>
		<div class="col-sm-6">
			<select name="areaId" class="form-control">
				<option>country</option>
				<c:forEach items="${areaList}" var="item">
				<option value="${item.id}" ${item.id eq address.areaId ? 'selected="selected"' : ''}>${item.name}</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">Postal code</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" name="postcode" value="${address.postcode}">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">Mobile</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" name="mobile" value="${address.mobile}">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-6 col-sm-offset-2">
			<button class="btn btn-default">Save</button>
			<a class="btn btn-default cancel-edit pull-right" href="javascript:;">Cancel</a>
		</div>
	</div>
</form>