<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sfn" uri="http://www.shangtech.net/tags/functions"%>

<div class="product-list">
	<c:forEach items="${pagination.items}" var="item" varStatus="i">
	<div id="1991434" gtype="3" g_type="3" class="product-item ${i.index%4 == 3 ? 'product-item-right' : ''} ${i.index%4 == 0 ? 'product-item-left' : ''}">
        <div class="list-good buy">
            <div class="good-pic">
                <div class="pic-img">
                    <a href="${ctx}/detail/${item.code}" target="_blank">
                    	<img src="${item.image}" class="lazy good-pic" alt="${item.name}" style="display: inline;">
                    	<span class="new-icon">新品</span>
                    </a>
                </div>
            </div>
            <h3 class="good-title">[包邮]<a href="${ctx}/detail/${item.code}" target="_blank">${item.name}</a><span class="sold">新品上架<em></em></span> </h3>
            <div class="good-price"> <span class="price-current"><em>￥</em>${item.sellPrice}</span> <span class="des-other"> <strong></strong> <span class="price-old"><em>￥</em>${item.marketPrice}</span> <span class="discount">(<em>1.0</em>折)</span> </span>
                <div class="btn buy j-buy"><a target="_blank" href="${ctx}/detail/${item.code}"><em class="j-icon"></em><span>特卖</span> </a></div>
            </div>
			<a class="y-like my-like" data-gid="1991434" data-gtype="3" lkid="1991434" lks="1" gtype="3" title="加入收藏">
				<i class="like-ico"><span class="heart_left"></span><span class="heart_right"></span></i>
			</a>
		</div>
    </div>
    </c:forEach>
</div>
<c:if test="${pagination.totalPage gt 1}">
<div class="page">
	<em></em>
	<div>
	<c:if test="${pagination.pageNo eq 1}">
		<span class="pg-prev">上一页</span>
	</c:if>
	<c:if test="${pagination.pageNo gt 1}">
		<a class="pg-prev" href="?page=${pagination.pageNo-1}">上一页</a>
	</c:if>
	
	<%-- 第1-2页 --%>
	<c:forEach begin="1" end="2" var="i">
		<c:if test="${i eq pagination.pageNo}">
		<span>${i}</span>
		</c:if>
		<c:if test="${not (i eq pagination.pageNo)}">
		<a href="?page=${i}">${i}</a>
		</c:if>
	</c:forEach>
	
	<%--第3页 --%>
	<c:if test="${pagination.totalPage gt 2}">
	<c:choose>
		<c:when test="${pagination.pageNo eq 3}">
		<span>3</span>
		</c:when>
		<c:when test="${pagination.pageNo gt 6}">
		<i>...</i>
		</c:when>
		<c:otherwise>
		<a href="?page=3">3</a>
		</c:otherwise>
	</c:choose>
	</c:if>
	
	<%--中间5页 --%>
	<c:forEach begin="${sfn:max(pagination.pageNo-2, 4)}" end="${sfn:min(pagination.pageNo+2, pagination.totalPage)}" var="i">
		<c:if test="${i eq pagination.pageNo}">
		<span>${i}</span>
		</c:if>
		<c:if test="${not (i eq pagination.pageNo)}">
		<a href="?page=${i}">${i}</a>
		</c:if>
	</c:forEach>
	
	<%--最后一页 --%>
	<c:if test="${pagination.totalPage gt pagination.pageNo+2}">
	<c:choose>
		<c:when test="${pagination.pageNo+4 lt pagination.totalPage}">
		<i>...</i>
		</c:when>
		<c:otherwise>
		<a href="?page=${pagination.pageNo+3}">${pagination.pageNo+3}</a>
		</c:otherwise>
	</c:choose>
		<c:if test="${pagination.pageNo+3 lt pagination.totalPage}">
		<a href="?page=${pagination.totalPage}">${pagination.totalPage}</a>
		</c:if>
	</c:if>
	
	<c:if test="${pagination.pageNo lt pagination.totalPage}">
		<a class="pg-next" href="?page=${pagination.pageNo+1}">下一页</a>
	</c:if>
	<c:if test="${pagination.pageNo eq pagination.totalPage}">
		<span class="pg-next">下一页</span>
	</c:if>
	</div>
</div>
</c:if>