<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-cn">
	<head>
		<jsp:include page="css-and-scripts.jsp"/>
	</head>
	<body>
		<jsp:include page="common-nav.jsp"/>
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
					<div class="col-md-7 col-sm-7">
						<t:insertAttribute name="content" />
					</div>
					<div class="col-md-5 col-sm-5">
						<div class="panel panel-default order-summary">
							<div class="panel-heading">
								<h3>Order Summary</h3>
							</div>
							<div class="panel-body">
								<table class="order-items">
									<colgroup>
										<col width="80"/>
										<col/>
										<col width="50"/>
										<col width="50"/>
									</colgroup>
									<tbody>
										<c:forEach items="${shoppingCart.shoppingCartItemList}" var="item">
										<tr>
											<td><img src="${item.sku.image}" style="width:70px;"/></td>
											<td>${item.sku.name}</td>
											<td> × ${item.quantity}</td>
											<td>${item.amount}</td>
										</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<ul class="list-group">
								<li class="list-group-item">
									<table class="total-table" width="100%">
										<colgroup>
											<col/>
											<col width="50"/>
										</colgroup>
										<tbody>
											<tr>
												<td>Subtotal</td>
												<td>${shoppingCart.subtotal}</td>
											</tr>
											<tr>
												<td>Shipping</td>
												<td>${(empty shoppingCart.actualFreight) ? '-' : shoppingCart.actualFreight}</td>
											</tr>
										</tbody>
										<tfoot>
											<tr>
												<td>Total</td>
												<td>${shoppingCart.actualAmount}</td>
											</tr>
										</tfoot>
									</table>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="common-footer.jsp"/>
	</body>
</html>