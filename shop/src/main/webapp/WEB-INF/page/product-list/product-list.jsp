<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="category-top-brands">

</div>
<div class="product-list">
	<c:forEach items="${pagination.items}" var="item">
	<div id="1991434" gtype="3" g_type="3" class="product-item">
        <div class="list-good buy">
            <div class="good-pic">
                <div class="pic-img">
                    <a href="http://shop.juanpi.com/deal/1991434" target="_blank">
                    	<img src="${item.image}" class="lazy good-pic" alt="七匹狼V领速干短袖T恤" style="display: inline;">
                    	<span class="new-icon">新品</span>
                    </a>
                </div>
            </div>
            <h3 class="good-title">[包邮]<a href="http://shop.juanpi.com/deal/1991434" target="_blank">${item.name}</a><span class="sold">新品上架<em></em></span> </h3>
            <div class="good-price"> <span class="price-current"><em>￥</em>29</span> <span class="des-other"> <strong></strong> <span class="price-old"><em>￥</em>299</span> <span class="discount">(<em>1.0</em>折)</span> </span>
                <div class="btn buy j-buy"><a target="_blank" href="http://shop.juanpi.com/deal/1991434"><em class="j-icon"></em><span>特卖</span> </a></div>
            </div>
			<a class="y-like my-like" data-gid="1991434" data-gtype="3" lkid="1991434" lks="1" gtype="3" title="加入收藏">
				<i class="like-ico"><span class="heart_left"></span><span class="heart_right"></span></i>
			</a>
		</div>
    </div>
    </c:forEach>
</div>