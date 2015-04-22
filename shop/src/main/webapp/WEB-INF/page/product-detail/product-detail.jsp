<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="math" uri="http://www.shangtech.net/tags/math"%>
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
	<div class="col-md-9 col-sm-9">
		<div class="row">
			<div class="col-md-6 col-sm-6">
				<div id="big-image">
					<a href="${sku.image}" onclick="return false;" class="jqzoom">
						<img id="jq-zoom" src="${sku.image}"/>
					</a>
				</div>
				<c:if test="${sku.imageNum gt 0}">
				<div class="image-slider">
					<span class="pic-slider-up switchable-first">
						<em class="arrow-out">
							<em class="arrow-in"></em>
						</em>
					</span>
					<div class="img-slider-list">
						<ul>
							<c:forEach begin="1" end="${sku.imageNum}" varStatus="i">
							<li data-src="http://i00.i.aliimg.com/photo/${sku.code}_${i.index}/image.jpg">
								<img src="http://i00.i.aliimg.com/photo/${sku.code}_${i.index}/image.jpg"/>
							</li>
							</c:forEach>
						</ul>
					</div>
					<span class="pic-slider-down ${sku.imageNum lt 6 ? 'switchable-last' : ''}">
						<em class="arrow-out">
							<em class="arrow-in"></em>
						</em>
					</span>
				</div>
				</c:if>
			</div>
			<div class="col-md-6 col-sm-6 sku-details">
				<h3 class="sku-name">${sku.name}</h3>
				<form action="${ctx}/add-shopping-cart" id="cart-form" method="post">
				<table class="sku-props">
					<tr>
						<th>Min.Order Quantity:</th><td>10 Piece/Pieces</td>
					</tr>
					<tr>
						<th>Supply Ability:</th><td>10000 Piece/Pieces per Day</td>
					</tr>
					<tr>
						<th>Port:</th><td>Shenzhen</td>
					</tr>
					<tr>
						<th>Min.Order Quantity:</th><td>10 Piece/Pieces</td>
					</tr>
					<tr>
						<th>Min.Order Quantity:</th><td>10 Piece/Pieces</td>
					</tr>
					<tr>
						<th>Supply Ability:</th><td>10000 Piece/Pieces per Day</td>
					</tr>
					<tr>
						<th>Port:</th><td>Shenzhen</td>
					</tr>
					<tr>
						<th>Min.Order Quantity:</th><td>10 Piece/Pieces</td>
					</tr>
					<tr>
						<th>quantity:</th>
						<td>
							<input type="hidden" name="code" id="code" value="${sku.code}"/>
							<div class="input-group quantity-input-group">
								<span class="input-group-btn">
									<a class="btn btn-default disabled num-reduce" href="javascript:;"><span class="glyphicon glyphicon-minus"></span></a>
								</span>
								<input type="text" class="form-control" id="quantity" name="quantity" value="${min}" data-min="${min}">
								<span class="input-group-btn">
									<a class="btn btn-default num-add ${skuQuantity.max eq 0 ? 'disabled' : ''}" href="javascript:;"><span class="glyphicon glyphicon-plus"></span></a>
								</span>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="nopadding">
							<div id="error-wrapper" class="alert alert-danger"></div>
						</td>
					</tr>
					<tr>
						<th>
							<a href="javascript:;" class="btn btn-default btn-contant"><span class="glyphicon glyphicon-envelope"></span> Contact supplier</a>
						</th>
						<td>
							<button class="btn btn-default btn-addcart"><span class="glyphicon glyphicon-shopping-cart"></span> Add To Cart</button>
						</td>
					</tr>
					<tr>
						<th><a href="javascript:;"><i class="glyphicon glyphicon-star"></i> Add to My Favorites</a></th>
						<td></td>
					</tr>
				</table>
				</form>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12 product-tabs" role="tabpanel">
				<ul id="product-tab" class="nav nav-tabs" role="tablist">
					<li role="presentation" class="active"><a data-toggle="tab" href="#product-details">Product Details</a></li>
					<li role="presentation"><a data-toggle="tab" href="#transaction-history">Transaction History</a></li>
					<li role="presentation"><a data-toggle="tab" href="#feedback">Feedback</a></li>
				</ul>
				<div class="tab-content">
					<div role="tabpanel" class="tab-pane active" id="product-details">
						<jsp:include page="tab-details.jsp"></jsp:include>
					</div>
					<div role="tabpanel" class="tab-pane" id="transaction-history">
						<jsp:include page="tab-history.jsp"></jsp:include>
					</div>
					<div role="tabpanel" class="tab-pane" id="feedback">feedback</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="col-md-3 col-sm-3">
		<div class="row">
			<div class="col-md-12 col-sm-12">
				<div class="panel panel-default">
					<div class="panel-heading">Relate Products</div>
					<div class="panel-body relate-products">
						<c:forEach items="${relateList}" var="item">
						<div class="relate-item">
							<a href="${ctx}/product/${item.code}">
								<img src="${item.image}"/>
							</a>
							<a href="${ctx}/product/${item.code}"><h5>${item.name}</h5></a>
						</div>
						</c:forEach>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-body">
						
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	</div>
</div>
<script type="text/javascript" src="${ctx}/assets/jquery-validation-1.13.1/jquery.validate.js"></script>
<%--
<script type="text/javascript" src="${ctx}/assets/magiczoom/magiczoom.js"></script>
--%>
<script type="text/javascript" src="${ctx}/assets/jqzoom/js/jquery.jqzoom-core.js"></script>
<script type="text/javascript" src="${ctx}/assets/js/product-detail.js"></script>