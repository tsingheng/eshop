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
<div class="main pr mt20 clear">
	<c:if test="${shoppingCart.quantity le 0}">
	<div class="orders order_empty">
		<div class="empty_img fl"></div>
		<div class="empty_detail fr">
		    <p class="txt">购物袋还是空荡荡哒~快去抢购宝贝吧！</p>
		    <p class="btn_all"><a href="${ctx}/" class="btn_normal btn_normal_01">去抢购</a></p>
		</div>
	</div>
	</c:if>
	<c:if test="${shoppingCart.quantity gt 0}">
		<div class="orders">
        	<div class="orders-hd">
        		<ul>
            		<li class="name-item"><span>商品信息</span></li>
            		<li class="price-item"><span class="text">单价（元）</span></li>
            		<li class="quantity-item"><span class="text">数量</span></li>
            		<li class="subtotal-item"><span class="text">小计（元）</span></li>
            		<li class="actions-item"><span class="text">操作</span></li>
        		</ul>
   	 		</div>
    
            <div class="orders-bd">
	            <%-- 
	            <div class="table-box">
	                <span class="name">店铺：</span><span></span>
	                <a href="" target="_blank" title="">
	                <img border="0" src="http://s.juancdn.com/juanpi/images/shopping/qq-icon.jpg" style="display: inline-block;"></a>
	            </div>
	            --%>
            	<table class="tbl-main">
                	<tbody>
                		<c:forEach items="${shoppingCart.shoppingCartItemList}" var="item">
                		<tr data-code="${item.code}">
                        	<td class="name-item sku-item">
	                            <div class="pic">
	                                <a target="_blank" href="${ctx}/detail/${item.sku.code}"><img src="${fn:replace(item.sku.image, '_1', '')}" style="display: inline;"></a>
	                            </div>
	                            <div class="detail">
	                                <div class="title">
	                                    <a target="_blank" href="${ctx}/detail/${item.sku.code}">${item.sku.name}</a>
	                                </div>
	                                <div class="other">
		                                <p>颜色分类：${item.sku.color}</p>                                
		                                <p>尺码：${item.size}</p>                                
	                               	</div>
	                            </div>
                        	</td>
	                        <td class="price-item cell-center">
	                            <p class="old_p"><del>${item.sku.marketPrice}</del></p>
	                            <p class="price"><label>${item.sku.sellPrice}</label></p>
	                        </td>
	                        <td class="quantity-item cell-center">
	                            <div class="normal">
	                                <dd class="num-box" data-code="${item.code}" data-avaliable="${item.avaliable}">
								        <span class="num-reduce ${item.quantity le 1 ? 'num-reduce-disabled' : ''} J-num-act-reduce"></span>
								        <em class="num-input J-pro-num-txt">${item.quantity}</em>
								        <span class="num-add J-num-act-add ${item.quantity ge item.avaliable ? 'num-add-disabled' : ''}"></span>
								    </dd>
	                                <p class="tips" style="display: none;"></p>
	                            </div>
	                        </td>
	                        <td class="subtotal-item cell-center">
	                            <p class="count"><label>${item.sku.sellPrice*item.quantity}</label></p>
	                        </td>
	                        <td class="actions-item cell-center">
	                            <p><a href="javascript:;" class="del" data-code="${item.code}">删除</a></p>
	                    	</td>
                		</tr>
                		</c:forEach>
            		</tbody>
            	</table>
        	</div>
        
    		<div class="m-orders-total">
        		<%-- 
        		<div class="orders-total-bd">
            		<div class="orders-trigger fl">
                		<a href="javascript:;" class="orders-trigger-btn">
                			<span class="txt">使用现金券</span>
                			<span class="arrow"></span>
                		</a>
            		</div>
        		</div>
        
		        <!-- 使用优惠券 -->
		        <div style="display:none;" class="cv-box">
				    <div class="activate clear">
				        <span>现金券激活码:</span>
				        <input type="text" id="activate-code" name="activate-code" value="">
				        <div class="activate-button">激活</div>
				        <div class="cv-rule"><a target="_blank" href="http://www.juanpi.com/help/10107y">现金券使用规则</a></div>
				    </div>
				    <div class="cash-voucher">
				        <div class="cv-list">
				            <div class="hdttl" style="display: none;">
				                <div class="rdslt">&nbsp;</div>
				                <div class="cv-value">金额(元)</div>
				                <div class="cv-type">类型</div>
				                <div class="cv-adv">使用条件</div>
				                <div class="cv-time">有效时间</div>
				                <div class="cv-status">状态</div>
				            </div>
				            <ul class="coupon_ul" style="display: none;"></ul>
				            <div style="display: block;" class="no-cv"><span>你当前没有可使用现金券</span></div>
				        </div>
				    </div>
				</div>
		        <!-- 使用优惠券 /-->
		        --%>
		        <div class="orders-pay-fixed clear">
		            <div class="orders-total-pay">
		                <a href="${ctx}/" class="go_shopping fl">&lt;&lt;继续购物</a>
		                <form id="cartConfirmForm" method="post" action="${ctx}/shopping-checkout">
		                
		                </form>
		                <a href="javascript:;" class="go_pay fr">去结算</a>
		                <div class="other fr">
		                <p class="all">共有<em>${shoppingCart.quantity}</em>件商品，金额<span><i>￥</i><label>${shoppingCart.actualAmount}</label></span></p>
		                <p class="count">总计（不含运费）<span><i>￥</i><label>${shoppingCart.actualAmount}</label></span></p></div>
		            </div>
		        </div>
    		</div>
    	</div>
	</c:if>
</div>
<script type="text/javascript" src="${ctx}/assets/js/shopping-cart.js"></script>