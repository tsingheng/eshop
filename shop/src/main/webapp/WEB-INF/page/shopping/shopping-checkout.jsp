<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="checkout-section" id="address-section">
	<div class="section-header">
		<h3>Customer Information</h3>
	</div>
	<ul class="list-group address-list">
		<c:if test="${empty memberAddressList}">
		<li class="list-group-item address-item selection-item">
			<input type="radio" name="memberAddressId" value="" checked="checked"/>
			<span class="member-address">&nbsp;</span>
			<a href="javascript:;" class="edit-address">Edit</a>
		</li>
		<li class="list-group-item address-form-wrapper" style="display:block;">
			<jsp:include page="address-form.jsp"/>
		</li>
		</c:if>
		<c:if test="${not empty memberAddressList}">
		<c:forEach items="${memberAddressList}" var="item">
		<li class="list-group-item address-item selection-item">
			<input type="radio" name="memberAddressId" value="${item.id}" ${item.id eq shoppingCart.memberAddressId ? 'checked' : ''}/>
			<span class="member-address">${item.firstName} ${item.lastName} ${item.country} ${item.city}</span>
			<a href="javascript:;" class="edit-address">Edit</a>
		</li>
		</c:forEach>
		</c:if>
		<c:if test="${not empty loginMember.id}">
		<li class="list-group-item add-address">
			New Address
		</li>
		</c:if>
	</ul>
</div>

<c:if test="${not empty memberAddressList}">
<div class="checkout-section" id="freight-section">
	<div class="section-header">
		<h3>Shipping</h3>
	</div>
	<ul class="list-group shipping-list">
		<c:if test="${empty freightList}">
		<li class="list-group-item">
			There are no shipping methods available for your cart or destination. 
			<a href="javascript:;" class="list-group-item-btn">Contact us</a>
		</li>
		</c:if>
		<c:forEach items="${freightList}" var="item">
		<li class="list-group-item freight-item selection-item">
			<input type="radio" name="shippingId" id="shipping-${item.shipping.id}" value="${item.shipping.id}">
			<label class="selection-label" for="shipping-${item.shipping.id}">
				<span class="shipping-name">${item.shipping.name}</span>
				<span class="shipping-price">${item.freight}</span>
			</label>
		</li>
		</c:forEach>
	</ul>
</div>
</c:if>

<div class="checkout-section">
	<div class="section-header">
		<h3>Payment</h3>
	</div>
	<ul class="list-group payment-list">
		<li class="list-group-item payment-item selection-item">
			<input type="radio" name="payment" id="payment-1">
			<label class="selection-label" for="payment-1"><i class="payment-method paypal"></i></label>
			<ul class="payment-methods">
				<li class="payment-method visa">Visa</li>
				<li class="payment-method master">MasterCard</li>
				<li class="payment-method american-express">American Express</li>
				<li class="payment-method discover">Discover</li>
			</ul>
		</li>
	</ul>
</div>
<script type="text/javascript" src="${ctx}/assets/jquery-validation-1.13.1/jquery.validate.js"></script>
<script type="text/javascript" src="${ctx}/assets/js/area.js"></script>
<script type="text/javascript" src="${ctx}/assets/js/shopping-checkout.js"></script>