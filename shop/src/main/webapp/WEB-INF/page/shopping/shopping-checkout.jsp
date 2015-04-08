<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="main pr mt20 clear">
<div class="confirm-order">
    <!-- 收货信息 -->
    <div class="order-address clear">
        <h2>
        	<span class="fl">选择收货地址</span>
        	<c:if test="${not empty loginMember}">
        	<a href="${ctx}/setting/address" target="_blank" class="manage_links fl">管理收货地址</a> 
        	</c:if>
        	<a class="manage_links write_links fl" href="javascript:void(0)" style="display:none">
        		<i class="icons icons-tips fl"></i>
        		<span class="fl">请填写收货地址</span>
        	</a>
        </h2>
        <ul class="list" id="myAddress">
        	<c:forEach items="${memberAddressList}" var="address">
        	<li id="address-${address.id}" class="${address.id eq shoppingCart.memberAddressId ? 'cur' : ''}" data-id="${address.id}">
        		<div class="fl">
        			<div class="slice-border">
        				<div class="area-sumary">
        					<span class="area-name name">${address.contact}</span>收
        				</div>
        			</div>
        			<div class="mb5">
        				<span class="area-address street">${address.street}</span> 
        				<span class="area-postcode">${address.postcode}</span>
        			</div>
        			<div class="province" data-province="${address.province}" data-city="${address.city}" data-district="${address.district}">${address.province} ${address.city} ${address.district}</div>
        			<div>
        				<span class="area-mobile phone">${address.mobile}</span>
        				<a href="javascript:void(0);" class="addr-edit modify">修改</a>
        			</div>
        		</div>
        		<div class="slt-icon"></div>
        		<c:if test="${address.isDefault}">
        		<div class="default-add">默认地址</div>
        		</c:if>
        		<div class="slt-icon"></div>
        	</li>
        	</c:forEach>
        	<c:if test="${not empty loginMember}">
        	<li>
        		<a href="javascript:;" class="add"><em class="icons icons-add"></em>新增地址</a>
        	</li>
        	</c:if>
        </ul>
        <form class="new-address" id="addrform" style="${not empty memberAddressList ? 'display: none;' : ''}" uadid="0" method="post" action="${ctx}/save-address">
            <div style="" class="panel-box">
                <div id="adr" class="adr">
                    <ul>
                        <li>
                            <label><span class="import">*</span>收货人：</label>
                            <input type="text" tabindex="1" maxlength="10" size="10" id="contact" name="contact" value="" class="text">
                            <p class="s12">请填写收货人真实姓名，只能含字母或汉字</p>
                        </li>
                        <li>
                            <label> <span class="import">*</span>所在地区：</label>
                            <select tabindex="2" id="province" name="province"><option value="">选择省份</option></select>
                            <select tabindex="3" id="city" name="city"><option value="">选择城市</option></select>
                            <select tabindex="4" id="district" name="district"><option value="">选择区域</option></select>
                        </li>
                        <li>
                            <label> <span class="import">*</span>街道地址：</label>
                            <input type="text" class="text" tabindex="5" maxlength="30" size="45" id="street" name="street" value="">
                            <p class="s12">请填写详细地址信息</p>
                        </li>
                        <li>
                            <label><span class="import">*</span>手机号码：</label>
                            <input type="text" class="text" tabindex="7" maxlength="12" size="15" id="mobile" name="mobile" value="">
                        </li>
                        <li>
                            <label>座机号码：</label>
                            <input type="text" class="text" tabindex="7" maxlength="13" size="15" id="tel" name="tel" value="">
                            <p class="s12">027-xxxxxxx</p>
                        </li>
                        <li>
                            <label>邮编：</label>
                            <input type="text" class="text" tabindex="6" maxlength="6" size="6" id="postcode" name="postcode" value="">
                        </li>
                        <li>
                            <label></label>
                            <input type="checkbox" class="set-check" name="isDefault" id="J_SetDefault" value="1">
                            <label class="set" for="J_SetDefault">设置为默认收货地址</label>
                        </li>
                        <li>
                            <label></label>
							<input id="addr_token" name="addr_token" type="hidden" value="">
                            <button tabindex="7" class="smt smt1 baocun submit" id="">保 存</button>
                            <input type="button" tabindex="8" value="取 消" class="smt smt2 quxiao" id="" style="${(empty loginMember) or (empty memberAddressList) ? 'display:none;' : ''}">
                        </li>
                    </ul>
                </div>
                <input type="hidden" name="id" id="id"/>
            </form>
        </div>
    </div>
<form accept-charset="UTF-8" name="post_order" id="post_order" action="http://user.juanpi.com/pay/create_order" method="post">
    <div class="order-payment">
    <!--选择支付方式-->
        <h2>选择支付方式</h2>
        <div class="pay-method">
            <ul>
                <li>
                    <a href="javascript:;">
                    	<label>
	                        <input type="radio" value="2" name="choose_pay" checked="checked" class="check">
	                        <p class="img"><img src="http://s.juancdn.com/juanpi/images/sale/Alipay.jpg"></p>
                    	</label>
                    </a>
                </li>
                <li style="display:none">
                    <a href="javascript:;">
                    	<label>
	                        <input type="radio" value="7" name="choose_pay" class="check">
	                        <p class="img"><img src="http://s.juancdn.com/juanpi/images/sale/weixin.jpg"></p>
                    	</label>
                    </a>
                </li>
            </ul>
        </div>
    </div>

    <!-- 确认商品订单信息 -->
    <div class="order-goods">
        <h2><span class="fl">确认订单信息</span><a class="go_back fr" href="${ctx}/shopping-cart">&lt;&lt;返回购物袋修改</a></h2>
        <div class="orders clear">
    		<div class="orders-hd">
		        <ul>
		            <li class="name-item" style="width:44% !important;"><span>商品信息</span></li>
		            <li class="price-item" style="width:18% !important;"><span class="text">单价（元）</span></li>
		            <li class="quantity-item" style="width:18% !important;"><span class="text">数量</span></li>
		            <li class="subtotal-item" style="width:20% !important;"><span class="text">小计</span></li>
		            <%--<li class="actions-item"><span class="text">邮费</span></li>--%>
		        </ul>
		    </div>

    		<div class="orders-bd">
    			<%--
    			<div class="table-box">
    				<span class="name">店铺：</span>
    				<span>康费莱旗舰店</span>
    				<a title="点击这里给我发消息" target="_blank" href="http://wpa.qq.com/msgrd?v=3&amp;uin=776139707&amp;site=qq&amp;menu=yes">
    					<img style="display: inline-block;" src="http://s.juancdn.com/user/images/shopping/qq-icon.jpg" border="0">
    				</a>
    			</div>
    			--%>
			    <table class="tbl-main">
			        <tbody>
			        	<c:forEach items="${shoppingCart.shoppingCartItemList}" var="item">
			            <tr ispost="0">
				            <td class="name-item sku-item" data-skuid="117943">
				                <div class="pic">
				                	<a href="${ctx}/detail/${item.sku.code}" target="_blank">
				                		<img src="${fn:replace(item.sku.image, '_1', '')}" class="lazy" style="display: inline;">
				                	</a>
				                </div>
				                <div class="detail">
				                	<div class="title"><a href="${ctx}/detail/${item.sku.code}" target="_blank">${item.sku.name}</a></div>
				                	<div class="other"><p>尺码：${item.size}</p><p>颜色：${item.sku.color}</p></div>
				                </div>
				            </td>
				            <td class="price-item cell-center"><p class="old_p">${item.sku.marketPrice}</p><p class="price">${item.sku.sellPrice}</p></td>
				            <td class="quantity-item cell-center"><p class="number">${item.quantity}</p></td>
				            <td class="subtotal-item cell-center"><p class="count">${item.sku.sellPrice*item.quantity}</p></td>
				            <%--<td class="actions-item cell-center"><p>包邮</p></td>--%>
			        	</tr>
			        	</c:forEach>
			        </tbody>
			        <tfoot>
			        	<tr>
			            	<td class="bgc" colspan="3">
				                <div class="message"><label class="hd">留言：</label>
				                <div class="inputmask"><textarea placeholder="选填：对本次交易的补充说明，最多不超过50字" autocomplete="off" class="txt" data-maxlength="50" id="u_note" name="u_note[4074024]" title="选填：对本次交易的补充说明，最多不超过50字"></textarea>
				                </div></div>
				            </td>
			                <td colspan="2" class="bgc">
			                	<p><span>共计：</span><span class="fr postage">${shoppingCart.actualAmount}</span></p>
			                </td>
			            </tr>
			        </tfoot>
			    </table>
			</div>

    <div class="m-orders-total">
        <div class="m-orders-detail clear">
            <div class="site fl">
            <label class="fl">寄送至：</label><span class="fl" id="selected-address">${memberAddress.province} ${memberAddress.city} ${memberAddress.district} ${memberAddress.street}<br>${memberAddress.contact} ${memberAddress.mobile}</span></div>
            <div class="other fr">
                <p>
                	合计：<span class="normal"><em>￥</em>${shoppingCart.originalAmount}</span>
                	运费：<span class="postprice normal"><em>￥</em>${shoppingCart.actualFreight}</span>
                	<%--现金券扣减：<span class="normal"><em>￥</em>0.00</span>--%>
                </p>
                <p class="txt"><span class="wait_pay"><b>待支付：</b><span class="tlwaitpay"><em>￥</em>${shoppingCart.actualAmount+shoppingCart.actualFreight}</span></span></p>
            </div>
        </div>
    </div>
    
        </div>
    </div>

    <input id="token" name="token" type="hidden" value="3e45f4b4227e86e3fd73b77239dcbdf5">
    <!--邮费-->
    <input id="postage" name="postage" type="hidden" value="">
    <!--购买方式-->
    <input id="pay_type" name="pay_type" type="hidden" value="2">
    <!--总价-->     
    <input id="cprice" name="cprice" type="hidden" value="108">
    <input id="pay_amount" name="pay_amount" type="hidden" value="">
    <!--用户收获地址-->
    <input id="address_id" name="address_id" type="hidden" value="46629">
    <!--现金券激活码-->
    <input id="coupon_code" name="coupon_code" type="hidden" value="">
</form>
<input id="coupon_amount" name="coupon_amount" type="hidden" value="0">
</div>
    <div class="orders-total-pay">
        <p class="affirm fl"><label><input type="checkbox" class="ck" id="ck" name="ck" checked="checked">我已阅读并同意<a href="javascript:;" target="_blank">《xxxx服务协议》</a></label></p>
        <a class="go_pay fr" href="javascript:void(0)">确认并支付</a>
        <%--<p class="fr tips">请在<em><label id="daotime">17</label>分<label id="daosec">13</label>秒</em>内完成付款，超时将自动取消订单</p>--%>
    </div> 

</div>
<script type="text/javascript" src="${ctx}/assets/jquery-validation-1.13.1/jquery.validate.js"></script>
<script type="text/javascript" src="${ctx}/assets/js/area.js"></script>
<script type="text/javascript" src="${ctx}/assets/js/shopping-checkout.js"></script>