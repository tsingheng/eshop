<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<div id="toolbar">
			<div class="bar-con clear">
				<div class="right-show pull-right">
					<c:if test="${empty sessionScope['login_member_key']}">
					<div class="union-login"> 
						<a href="${ctx}/login" rel="nofollow">QQ登录</a>
						<a href="${ctx}/register" rel="nofollow">微博登录</a>
					</div>
					<span class="split">|</span>
					<div class="login-show">
						<a href="${ctx}/login" rel="nofollow">登录</a>
						<a href="${ctx}/register" rel="nofollow">免费注册</a>
					</div>
					</c:if>
					<c:if test="${not empty sessionScope['login_member_key']}">
					<div class="logined-show">
						<a href="" class="normal-a">
							<img src="http://s1.juancdn.com/face/default.jpg_20x20.jpg">
							<span class="user">nickname</span>
							<em class="cur"></em>
						</a>
						<div class="normal-box login-box">
							<ul>
								<li><a href="${ctx}/favorite"><i class="icon icon-01"></i><span>我的收藏</span></a></li>
								<li><a href="${ctx}/setting"><i class="icon icon-03"></i><span>账号设置</span></a></li>
								<li><a href="${ctx}/rebate"><i class="icon icon-02"></i><span>我的返利</span></a></li>
								<li><a href="${ctx}/logout"><i class="icon icon-04"></i><span>退出</span></a></li>
							</ul>
						</div>
					</div>
					<div class="personal-show">
						<a href="${ctx}/order"><span>我的订单</span></a>
						<a href="${ctx}/beans"><span>我的积分</span></a>
						<a href="${ctx}/message"><span>我的消息</span><em class="count" style="display: none;">0</em></a>
					</div>
					</c:if>
					<span class="split">&nbsp;</span>
					<div class="bag-show">
						<a href="${ctx}/shopping-cart" target="_blank" class="bag-a">
							<span class="icon-normal icon-bag"></span>
							<span class="empty fl" id="cart-summary"></span>
						</a>
						<div class="bag-tool">
							
						</div>
					</div>
				</div>
			</div>
		</div>