<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<a href="${ctx}/${item.code}/list" class="list-group-item ${(currentCategory.id eq item.id) ? 'active' : ''} ${((not empty item.children)  and (not (currentCategory.parentId eq item.id))) ? 'has-children' : ''}">
				${item.name}
				<c:if test="${(not empty item.children) and (not (currentCategory.parentId eq item.id))}">
				<span class="pull-right glyphicon glyphicon-chevron-right"></span>
				</c:if>
			</a>
			<c:if test="${not empty item.children}">
			<div class="category-children ${currentCategory.parentId eq item.id ? 'expand' : ''} float">
			<c:forEach items="${item.children}" var="child">
				<a href="${ctx}/${item.code}/${child.code}/list" class="list-group-item ${currentCategory.id eq child.id ? 'active' : ''}">${child.name}</a>
			</c:forEach>
			</div>
			</c:if>
			</c:forEach>
		</div>
	</div>
	<div class="col-md-9 col-sm-9">
		<jsp:include page="/WEB-INF/page/product-list/product-list-page.jsp"/>
	</div>
</div>
</div>
</div>