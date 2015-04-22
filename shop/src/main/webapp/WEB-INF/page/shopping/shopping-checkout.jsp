<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="checkout-section">
	<div class="section-header">
		<h3>Customer Information</h3>
	</div>
	<ul class="list-group">
		<c:if test="${empty memberAddressList}">
			<li class="list-group-item">
				<form action="${ctx}/save-address" method="post" class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-2 control-label">Fisrt Name</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="firstName">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Last Name</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="lastName">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Company</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="company">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Address</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="address">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">City</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="city">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Country</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="country">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Postal code</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="postcode">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Mobile</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="mobile">
						</div>
					</div>
				</form>
			</li>
		</c:if>
		<c:if test="${not empty memberAddressList}">
		<c:forEach items="${memberAddressList}" var="item">
			<li class="list-group-item">
				<input type="radio" name="memberAddressId"/>
				<span class="member-address">${item.firstName} ${item.lastName} ${item.country} ${item.city}</span>
				<a class="btn btn-default" href="javascript:;"> Edit </a>
			</li>
		</c:forEach>
		</c:if>
	</ul>
</div>
<script type="text/javascript" src="${ctx}/assets/jquery-validation-1.13.1/jquery.validate.js"></script>
<script type="text/javascript" src="${ctx}/assets/js/area.js"></script>
<script type="text/javascript" src="${ctx}/assets/js/shopping-checkout.js"></script>