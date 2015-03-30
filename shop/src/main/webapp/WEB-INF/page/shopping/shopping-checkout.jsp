<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="main pr mt20 clear">
<div class="confirm-order">
    <!-- 收货信息 -->
    <div class="order-address clear">
        <h2><span class="fl">选择收货地址</span><a href="http://user.juanpi.com/setting/address" target="_blank" class="manage_links fl">管理收货地址</a> <a class="manage_links write_links fl" href="javascript:void(0)" style="display:none"><i class="icons icons-tips fl"></i><span class="fl">请填写收货地址</span></a></h2>
        <ul class="list" id="myAddress">
        <li class="cur"><input name="area" class="area-radio check" type="radio" tel="" value="46629" primary="1" provinceid="310000" cityid="310100" townid="310108" style="display:none"><div class="fl"><div class="slice-border"><div class="area-sumary"><span class="area-name name">test</span>收</div></div><div class="mb5"><span class="area-address street">test</span> <span class="area-postcode"></span></div><div class="province">上海 上海市 闸北区</div><div><span class="area-mobile phone">18559693212</span><a href="javascript:void(0);" class="addr-edit modify">修改</a></div></div><div class="slt-icon"></div><div class="default-add">默认地址</div><div class="slt-icon"></div></li><li><a href="javascript:;" class="add"><em class="icons icons-add"></em>新增地址</a></li></ul>
        <div class="new-address" id="addrform" style="display: none;" uadid="0">
            <div style="" class="panel-box">
                <div id="adr" class="adr">
                    <ul>
                        <li>
                            <label><span class="import">*</span>收货人：</label>
                            <input type="text" tabindex="1" maxlength="10" size="10" id="truename" name="name" value="" class="text">
                            <p class="s13" style="display:none;"></p>
                            <p class="s12">请填写收货人真实姓名，只能含字母或汉字</p>
                        </li>
                        <li>
                            <label> <span class="import">*</span>所在地区：</label>
                            <select tabindex="2" id="province" name="province"><option value="0">选择省份</option><option value="110000">北京</option><option value="120000">天津</option><option value="130000">河北省</option><option value="140000">山西省</option><option value="150000">内蒙古自治区</option><option value="210000">辽宁省</option><option value="220000">吉林省</option><option value="230000">黑龙江省</option><option value="310000">上海</option><option value="320000">江苏省</option><option value="330000">浙江省</option><option value="340000">安徽省</option><option value="350000">福建省</option><option value="360000">江西省</option><option value="370000">山东省</option><option value="410000">河南省</option><option value="420000">湖北省</option><option value="430000">湖南省</option><option value="440000">广东省</option><option value="450000">广西壮族自治区</option><option value="460000">海南省</option><option value="500000">重庆</option><option value="510000">四川省</option><option value="520000">贵州省</option><option value="530000">云南省</option><option value="540000">西藏自治区</option><option value="610000">陕西省</option><option value="620000">甘肃省</option><option value="630000">青海省</option><option value="640000">宁夏回族自治区</option><option value="650000">新疆维吾尔自治区</option></select>
                            <select tabindex="3" id="city" name="city"><option value="0">选择城市</option></select>
                            <select tabindex="4" id="town" name="town"><option value="0">选择区域</option></select>
                            <p class="s13" style="display:none;"></p>
                        </li>
                        <li>
                            <label> <span class="import">*</span>街道地址：</label>
                            <input type="text" class="text" tabindex="5" maxlength="30" size="45" id="addr" name="addr" value="">
                            <p class="s13" style="display:none;"></p>
                            <p class="s12">请填写详细地址信息</p>
                        </li>
                        <li>
                            <label><span class="import">*</span>手机号码：</label>
                            <input type="text" class="text" tabindex="7" maxlength="12" size="15" id="mobile" name="mobile" value="">
                            <p class="s13" style="display:none;"></p>
                        </li>
                        <li>
                            <label>座机号码：</label>
                            <input type="text" class="text" tabindex="7" maxlength="13" size="15" id="tel" name="tel" value="">
                            <p class="s13" style="display:none;"></p>
                            <p class="s12">027-xxxxxxx</p>
                        </li>
                        <li>
                            <label>邮编：</label>
                            <input type="text" class="text" tabindex="6" maxlength="6" size="6" id="postcode" name="postcode" value="">
                        </li>
                        <li>
                            <label></label>
                            <input type="checkbox" class="set-check" name="primary" id="J_SetDefault" value="1">
                            <label class="set" for="J_SetDefault">设置为默认收货地址</label>
                        </li>
                        <li>
                            <label></label>
							<input id="addr_token" name="addr_token" type="hidden" value="">
                            <input type="button" tabindex="7" value="保 存" class="smt smt1 baocun" id="">
                            <input type="button" tabindex="8" value="取 消" class="smt smt2 quxiao" id="">
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
<form accept-charset="UTF-8" name="post_order" id="post_order" action="http://user.juanpi.com/pay/create_order" method="post">
    <div class="order-payment">
    <!--选择支付方式-->
        <h2>选择支付方式</h2>
        <div class="pay-method">
            <ul>
                <li>
                    <a href="javascript:;"><label>
                        <input type="radio" value="2" name="choose_pay" checked="checked" class="check">
                        <p class="img"><img src="http://s.juancdn.com/juanpi/images/sale/Alipay.jpg"></p>
                    </label></a>
                </li>
                <li style="display:none">
                    <a href="javascript:;"><label>
                        <input type="radio" value="7" name="choose_pay" class="check">
                        <p class="img"><img src="http://s.juancdn.com/juanpi/images/sale/weixin.jpg"></p>
                    </label></a>
                </li>
            </ul>
        </div>
    </div>

    <!-- 确认商品订单信息 -->
    <div class="order-goods">
        <h2><span class="fl">确认订单信息</span><a class="go_back fr" href="http://cart.juanpi.com">&lt;&lt;返回购物袋修改</a></h2>
        <div class="orders clear">
    <div class="orders-hd">
        <ul>
            <li class="product-item"><span>商品信息</span></li>
            <li class="price-item"><span class="text">单价（元）</span></li>
            <li class="quantity-item"><span class="text">数量</span></li>
            <li class="subtotal-item"><span class="text">小计</span></li>
            <li class="actions-item"><span class="text">邮费</span></li>
        </ul>
    </div>

    <div class="orders-bd">
    <div class="table-box"><span class="name">店铺：</span><span>康费莱旗舰店</span><a title="点击这里给我发消息" target="_blank" href="http://wpa.qq.com/msgrd?v=3&amp;uin=776139707&amp;site=qq&amp;menu=yes"><img style="display: inline-block;" src="http://s.juancdn.com/user/images/shopping/qq-icon.jpg" border="0"></a></div>
    <table class="tbl-main">
        <tbody>
                <tr ispost="0">
            <td class="product-item sku-item" data-skuid="117943">
                <div class="pic"><a href="http://shop.juanpi.com/deal/1392488" target="_blank"><img src="http://s1.juancdn.com//bao/150323/4/5/51035dad2e12_400x400.jpg_60x60.jpg" class="lazy" d-src="http://s1.juancdn.com//bao/150323/4/5/51035dad2e12_400x400.jpg_60x60.jpg" style="display: inline;"></a></div>
                <div class="detail">
                <div class="title"><a href="http://shop.juanpi.com/deal/1392488" target="_blank">亚麻欧根纱显瘦连衣裙</a></div>
                <div class="other"><p>尺码：L（大码）</p><p>颜色：白色</p></div></div></td>
            <td class="price-item cell-center"><p class="old_p">276.00</p><p class="price">108.00</p></td>
            <td class="quantity-item cell-center"><p class="number">1</p></td>
            <td class="subtotal-item cell-center"><p class="count">108</p></td>
            <td class="actions-item cell-center"><p>包邮</p></td>
        </tr>
                </tbody>
        <tfoot>
        <tr>
            <td class="bgc" colspan="4">
                <div class="message"><label class="hd">留言：</label>
                <div class="inputmask"><textarea placeholder="选填：对本次交易的补充说明，最多不超过50字" autocomplete="off" class="txt" data-maxlength="50" id="u_note" name="u_note[4074024]" title="选填：对本次交易的补充说明，最多不超过50字"></textarea>
                </div></div></td>
                <td colspan="2" class="bgc">
                <p><span>共计：</span><span class="fr postage">108.00</span></p>
                </td>
            </tr>
        </tfoot>
    </table>
    </div>

    <div class="m-orders-total">
        <div class="m-orders-detail clear">
            <div class="site fl">
            <label class="fl">寄送至：</label><span class="fl">上海 上海市 闸北区 test<br>test 18559693212</span></div>
            <div class="other fr">
                <p>合计：<span class="normal"><em>￥</em>108</span>运费：<span class="postprice normal"><em>￥</em>0.00</span>现金券扣减：<span class="normal"><em>￥</em>0.00</span></p>
                <p class="txt"><span class="wait_pay"><b>待支付：</b><span class="tlwaitpay"><em>￥</em>108.00</span></span></p>
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
        <p class="affirm fl"><label><input type="checkbox" class="ck" id="ck" name="ck" checked="checked">我已阅读并同意<a href="http://www.juanpi.com/about/argree_user" target="_blank">《卷皮特卖服务协议》</a></label></p>
        <a class="go_pay fr" href="javascript:void(0)">确认并支付</a>
        <p class="fr tips">请在<em><label id="daotime">17</label>分<label id="daosec">13</label>秒</em>内完成付款，超时将自动取消订单</p>
    </div> 

</div>