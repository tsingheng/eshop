<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="checkout-section">
	<div class="section-header">
		<h3>Customer Information</h3>
	</div>
	<ul class="list-group address-list">
		<c:if test="${empty memberAddressList}">
		<li class="list-group-item address-item">
			<input type="radio" name="memberAddressId" value="" checked="checked"/>
			<span class="member-address"></span>
			<a href="javascript:;" class="edit-address">Edit</a>
		</li>
		<li class="list-group-item">
			<jsp:include page="address-form.jsp"/>
		</li>
		</c:if>
		<c:if test="${not empty memberAddressList}">
		<c:forEach items="${memberAddressList}" var="item">
		<li class="list-group-item address-item">
			<input type="radio" name="memberAddressId" value="${item.id}" ${item.id eq shoppingCart.memberAddressId ? 'checked' : ''}/>
			<span class="member-address">${item.firstName} ${item.lastName} ${item.country} ${item.city}</span>
			<a href="javascript:;" class="edit-address">Edit</a>
		</li>
		</c:forEach>
		<li class="list-group-item address-form-wrapper">
			<jsp:include page="address-form.jsp"/>
		</li>
		<li class="list-group-item add-address">
			New Address
		</li>
		</c:if>
	</ul>
</div>
<script type="text/javascript" src="${ctx}/assets/jquery-validation-1.13.1/jquery.validate.js"></script>
<script type="text/javascript" src="${ctx}/assets/js/area.js"></script>
<script type="text/javascript" src="${ctx}/assets/js/shopping-checkout.js"></script>