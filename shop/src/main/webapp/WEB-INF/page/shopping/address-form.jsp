<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form id="address-form" action="${ctx}/save-address" method="post" class="form-horizontal">
	<div class="form-group">
		<label class="col-sm-2 control-label">Fisrt Name</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" name="firstName">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">Last Name</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" name="lastName">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">Company</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" name="company">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">Address</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" name="address">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">City</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" name="city">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">Country</label>
		<div class="col-sm-6">
			<select name="country" class="form-control">
				<option>country</option>
				<c:forEach items="${areaList}" var="item">
				<option value="${item.id}">${item.name}</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">Postal code</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" name="postcode">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">Mobile</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" name="mobile">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-6 col-sm-offset-2">
			<button class="btn btn-default">Save</button>
		</div>
	</div>
</form>