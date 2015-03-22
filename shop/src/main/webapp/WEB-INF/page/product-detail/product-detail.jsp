<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="math" uri="http://www.shangtech.net/tags/math"%>
<div class="detail-wrapper">
	<div class="detail-main">
		<div class="img-wrapper">
			<div class="big-img">
				<a href="" class="jqzoom clear" onclick="return false;">
					<img id="jq-zoom" src="${sku.image}"/>
				</a>
			</div>
			<div class="img-slider">
				<span class="pic-slider-up switchable-first">
					<em class="arrow-out">
						<em class="arrow-in"></em>
					</em>
				</span>
				<div class="img-slider-list">
					<c:set var="images" value="${fn:split(sku.images, ',')}"/>
					<ul style="width:${fn:length(images)*70}px;">
						<c:forEach items="${images}" var="image">
						<li data-img="${image}" style="background-image:url(${fn:replace(image, '#size#', '2')});"></li>
						</c:forEach>
					</ul>
				</div>
				<span class="pic-slider-down ${fn:length(images) lt 6 ? 'switchable-last' : ''}">
					<em class="arrow-out">
						<em class="arrow-in"></em>
					</em>
				</span>
			</div>
		</div>
		<div class="sku-info">
			<div class="sku-title">
				<p class="sku-brand"><a href="#">${brand.name}</a></p>
				<h2 class="sku-name">${sku.name}</h2>
			</div>
			<div class="sku-price">
				<span class="pbox-price"><i class="pbox-yen">&yen; </i><em>${sku.sellPrice}</em></span>
				<span class="pbox-off">${math:ceil(100*sku.sellPrice/sku.marketPrice)/10}折</span>
				<span class="pbox-market">&yen; <del>${sku.marketPrice}</del></span>
			</div>
			
			<div class="pi-attr-box">
				<dl class="i-freight clearfix" id="J_freight_frame">
	    			<dt class="freight-name">运费：</dt>
	    			<dd class="freight-con" id="J_freightTip_wrap">特卖会全场购物满88元即享受免邮</dd>
			    </dl>
			    
			    <c:if test="${not empty colorList}">
			    <dl class="color">
				    <dt class="color-name">颜色：</dt>
				    <dd class="color-list">
				        <ul>
				        	<c:forEach items="${colorList}" var="color">
				           	<li class="color-list-item">
				                <a id="J-colorItem-49507757" href="${ctx}/detail/${color.code}" title="${color.name}" class="${color.id eq sku.id ? 'selected' : ''}">
				                    <img class="fl" src="${color.image}" width="34" height="43" alt="${color.name}" mars_sead="m_te_goods_buy_color_check" style="display: block;">
				                   	<c:if test="${color.id eq sku.id}">
				                    <span class="i-select"></span>
				                    </c:if>
				                    <!--  
				                    <span class="cli-sold-out J-cli-sold-out hidden">售完</span>
				                    -->
				                </a>
				            </li>
				            </c:forEach>
				         </ul>
				    </dd>
				</dl>
				</c:if>
			    
			    <dl class="i-size clearfix J-sizeArea-wrap" id="J-sizeArea-wrap">
				    <dt class="size-name">尺码：</dt>
				    <dd class="i-notice-msg">请选择尺码</dd>
				    <dd class="size-list">
				    	<ul>
				    		<c:forEach items="${inventoryList}" var="inventory">
				           	<li data-max="${inventory.max}" data-avaliable="${math:max(inventory.stock-inventory.saled, 0)}" class="size-list-item J-sizeID ${inventory.saled ge inventory.stock ? 'sli-disabled' : ''} size-list-item-small" id="J-cartAdd-sizeID-${inventory.id}" data-size-name="${inventory.size}" data-hover="size-list-item-hover" data-id="${inventory.id}" mars_sead="m_te_goods_buy_size_check" style="z-index: 4;">
				                <span class="size-list-item-name">${inventory.size}</span>
				                <span class="i-select"></span>
				    		</li>
				    		</c:forEach>
				        </ul>
				    </dd>
				    <dd class="size-table size-table-tip" id="J-sideAide-btn-con">
				    	<span class="hidden" id="J-sideAide-btn" mars_sead="shop_detail_assistant_btn1" style="display: inline;">尺码助手</span>
				    </dd>
				</dl>
				
				<dl class="i-num clearfix" id="J-num-select">
				    <dt class="num-name">数量：</dt>
				    <dd class="i-notice-msg J-num-tips"></dd>
				    <dd class="num-box">
				        <span class="num-reduce num-reduce-disabled J-num-act-reduce"></span>
				        <em class="num-input J-pro-num-txt">1</em>
				        <span class="num-add J-num-act-add"></span>
				    </dd>
				    <dd class="num-msg hidden" id="J-proStock-type" style="display: none;"></dd>
				</dl>
				
				<dl class="other clearfix">
				    <dt class="other-name">编码：</dt>
				    <dd class="other-box">${sku.code}</dd>
				</dl>
				
				<div class="i-button clearfix">
				    <div id="J-button-box" class="button-box">
				        <button class="btn-cart" mars_sead="te_goods_buy_cart_btn" id="J-cartAdd-submit"></button>
				        <p class="btn-msg"><span>正在处理中...</span></p>
				    </div>
				</div>
		    </div>
		    
		    <div class="share-list">
		    	
		    </div>
		    <div class="pi-promise-box clearfix" id="J-safeguard-icon">
		        <ul class="pi-promise-list new-guest">
			        <li class="pi-promise-item item-percent"><a href="javascript:;">100%正品</a></li>
			        <li class="pi-promise-item item-7day"><a href="javascript:;">七天无理由放心退</a></li>
			        <li class="pi-promise-item item-free"><a href="javascript:;">退货返运费</a></li>
			    </ul>
		    </div>
		</div>
	</div>
</div>

<script type="text/javascript" src="${ctx}/assets/js/product-detail.js"></script>
<script type="text/javascript" src="${ctx}/assets/jqzoom/js/jquery.jqzoom-core.js"></script>