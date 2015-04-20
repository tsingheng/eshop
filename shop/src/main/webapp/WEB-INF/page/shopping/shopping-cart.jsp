<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="heads" style="background: url(${ctx}/assets/img/img02.jpg) center center;">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2><span>//</span> Single Item</h2>
			</div>
		</div>
	</div>
</div>
<div class="page-content">
	<div class="container">
		<div class="row">
			<div class="col-md-3 col-sm-3">
				<div class="list-group category-list">
					<c:forEach items="${topCategoryList}" var="item">
					<c:if test="${currentCategory.parentId eq item.id}">
						<div class="category-wrapper expand">
							<a href="${ctx}/${item.code}/list" class="list-group-item">
								${item.name}
								<c:if test="${(not empty item.children) and (not (currentCategory.parentId eq item.id))}">
								<span class="pull-right glyphicon glyphicon-chevron-right"></span>
								</c:if>
							</a>
							<div class="category-children">
							<c:forEach items="${item.children}" var="child">
								<a href="${ctx}/${item.code}/${child.code}/list" class="list-group-item ${currentCategory.id eq child.id ? 'active' : ''}">${child.name}</a>
							</c:forEach>
							</div>
						</div>
					</c:if>
					<c:if test="${not (currentCategory.parentId eq item.id)}">
						<div class="category-wrapper hide-children">
							<a href="${ctx}/${item.code}/list" class="list-group-item ${(currentCategory.id eq item.id) ? 'active' : ''} ${(not empty item.children) ? 'has-children' : ''}">
								${item.name}
								<c:if test="${not empty item.children}">
								<span class="pull-right glyphicon glyphicon-chevron-right"></span>
								</c:if>
							</a>
							<c:if test="${not empty item.children}">
							<div class="category-children">
							<c:forEach items="${item.children}" var="child">
								<a href="${ctx}/${item.code}/${child.code}/list" class="list-group-item">${child.name}</a>
							</c:forEach>
							</div>
							</c:if>
						</div>
					</c:if>
					</c:forEach>
				</div>
			</div>
			<div class="col-md-9 col-sm-3">
				<div class="panel panel-default panel-cart">
					<div class="panel-heading">
						Cart
						<a href="${ctx}/shop/list" class="continue">continue shopping</a>
					</div>
					<div class="panel-body">
						<c:if test="${shoppingCart.quantity le 0}">
						While we’re flattered that you’d just give us your money for nothing, you should probably add a few items to your cart to make it worth your while.
						</c:if>
						<c:if test="${shoppingCart.quantity le 0}">
						
						</c:if>
					</div>
					<div class="panel-footer">
						Total $${shoppingCart.actualAmount}
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="${ctx}/assets/js/shopping-cart.js"></script>