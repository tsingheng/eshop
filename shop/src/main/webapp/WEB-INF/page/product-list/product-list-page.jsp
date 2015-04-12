<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sfn" uri="http://www.shangtech.net/tags/functions"%>

<div class="row">
	<c:forEach items="${pagination.items}" var="item">
	<div class="col-md-3 col-sm-4 col-xs-12 product-wrapper">
		<div class="thumbnail product-item">
			<a href="${ctx}/product/${item.code}"><img src="${item.image}" alt="${item.name}"/></a>
			<div class="caption-details">
				<a href="${ctx}/product/${item.code}" title="${item.name}">${fn:substring(item.name, 0, 45)}</a>
				<span class="price">$200</span>
			</div>
		</div>
	</div>
    </c:forEach>
<c:if test="${pagination.totalPage gt 1}">
<ul class="pagination pull-right">
	<c:if test="${pagination.pageNo eq 1}">
		<li class="disabled"><a href="javascript:;">上一页</a></li>
	</c:if>
	<c:if test="${pagination.pageNo gt 1}">
		<li><a href="?page=${pagination.pageNo-1}">上一页</a></li>
	</c:if>
	<%-- 第1-2页 --%>
	<c:forEach begin="1" end="2" var="i">
		<c:if test="${i eq pagination.pageNo}">
		<li class="active"><a href="javascript:;">${i}</a></li>
		</c:if>
		<c:if test="${not (i eq pagination.pageNo)}">
		<li><a href="?page=${i}">${i}</a></li>
		</c:if>
	</c:forEach>
	
	<%--第3页 --%>
	<c:if test="${pagination.totalPage gt 2}">
	<c:choose>
		<c:when test="${pagination.pageNo eq 3}">
		<li class="active"><a href="javascript:;">3</a></li>
		</c:when>
		<c:when test="${pagination.pageNo gt 6}">
		<li><span>...</span></li>
		</c:when>
		<c:otherwise>
		<li><a href="?page=3">3</a></li>
		</c:otherwise>
	</c:choose>
	</c:if>
	
	<%--中间5页 --%>
	<c:forEach begin="${sfn:max(pagination.pageNo-2, 4)}" end="${sfn:min(pagination.pageNo+2, pagination.totalPage)}" var="i">
		<c:if test="${i eq pagination.pageNo}">
			<li class="active"><a href="javascript:;">${i}</span></li>
		</c:if>
		<c:if test="${not (i eq pagination.pageNo)}">
			<li><a href="?page=${i}">${i}</a></li>
		</c:if>
	</c:forEach>
	
	<%--最后一页 --%>
	<c:if test="${pagination.totalPage gt pagination.pageNo+2}">
	<c:choose>
		<c:when test="${pagination.pageNo+4 lt pagination.totalPage}">
		<li><span>...</span></li>
		</c:when>
		<c:otherwise>
		<li><a href="?page=${pagination.pageNo+3}">${pagination.pageNo+3}</a></li>
		</c:otherwise>
	</c:choose>
		<c:if test="${pagination.pageNo+3 lt pagination.totalPage}">
		<li><a href="?page=${pagination.totalPage}">${pagination.totalPage}</a></li>
		</c:if>
	</c:if>
	
	<c:if test="${pagination.pageNo lt pagination.totalPage}">
		<li><a href="?page=${pagination.pageNo+1}">下一页</a></li>
	</c:if>
	<c:if test="${pagination.pageNo eq pagination.totalPage}">
		<li class="disabled"><a href="javascript:;">下一页</span></li>
	</c:if>
	</div>
</div>
</c:if>
</div>