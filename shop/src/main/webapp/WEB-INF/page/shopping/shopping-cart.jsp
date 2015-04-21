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
						<c:if test="${shoppingCart.quantity gt 0}">
						<table class="cart-table">
							<colgroup>
								<col width="100"/>
								<col/>
								<col width="100"/>
								<col width="130"/>
								<col width="100"/>
								<col width="100"/>
							</colgroup>
							<thead>
								<tr>
									<th colspan="2">产品</th>
									<th>单价</th>
									<th>数量</th>
									<th>小计</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${shoppingCart.shoppingCartItemList}" var="item">
								<tr>
									<td><a href="${ctx}/product/${item.sku.code}" target="_blank"><img src="${item.sku.image}" style="width:80px;"/></a></td>
									<td><a href="${ctx}/product/${item.sku.code}" target="_blank">${item.sku.name}</a></td>
									<td class="center">${item.price}</td>
									<td class="center">
										<div class="input-group quantity-input-group">
											<span class="input-group-btn">
												<a class="btn btn-default disabled num-reduce" href="javascript:;"><span class="glyphicon glyphicon-minus"></span></a>
											</span>
											<input type="text" class="form-control" id="quantity" name="quantity" value="${item.quantity}">
											<span class="input-group-btn">
												<a class="btn btn-default num-add" href="javascript:;"><span class="glyphicon glyphicon-plus"></span></a>
											</span>
										</div>
									</td>
									<td class="center">${item.price*item.quantity}</td>
									<td class="center"><a class="btn btn-danger btn-sm" href="javascript:;">Remove</a></td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
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