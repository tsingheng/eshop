<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta property="qc:admins" content="43036231470630167453066547" />
<jsp:include page="css-and-scripts.jsp" />
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand visible-xs" href="#">XXXX</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav nav-left">
					<li class="active"><a href="${ctx}/">Home</a></li>
					<li><a href="${ctx}/about">About</a></li>
					<li><a href="${ctx}/list">Product</a></li>
					<li><a href="${ctx}/contact">Contact</a></li>
				</ul>
				<a href="${ctx}/" class="logo visible-lg visible-md">
					<img src="${ctx}/assets/img/logo.jpg" alt="dodolan manuk responsive catalog themes">
				</a>
				<div id="brand" class="visible-lg visible-md">&nbsp;</div>
				<ul class="nav navbar-nav nav-right">
					<li><a href="${ctx}/login">Sign in</a></li>
					<li><a href="${ctx}/register">Sign up</a></li>
					<li>
						<a href="${ctx}/shopping-cart" class="cart-nav">
							<span class="cart-icon">
								<svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="24" height="20" viewBox="0 0 32 32" enable-background="new 0 0 32 32" xml:space="preserve">
									<path class="cart-icon-fill" fill="#AAAAAA" d="M10.033,18.75L9.7,20.417H26c0.921,0,1.667,0.746,1.667,1.667c0,0.796-0.559,1.459-1.305,1.625
									  c-0.703-0.79-1.723-1.292-2.862-1.292c-1.158,0-2.196,0.519-2.9,1.333H11.4c-0.703-0.815-1.741-1.333-2.9-1.333
									  c-0.8,0-1.543,0.247-2.158,0.668c-0.286-0.379-0.403-0.86-0.309-1.328l1.569-7.848l-2.73-6.826H2.667C1.746,7.083,1,6.337,1,5.417
									  S1.746,3.75,2.667,3.75H6c0.682,0,1.294,0.415,1.548,1.048l0.914,2.286h20.871c0.553,0,1.07,0.274,1.38,0.732
									  c0.31,0.458,0.372,1.04,0.167,1.553l-3.333,8.333C27.294,18.335,26.682,18.75,26,18.75H10.033z M8.5,23.75
									  c-1.381,0-2.5,1.119-2.5,2.5c0,1.381,1.119,2.5,2.5,2.5s2.5-1.119,2.5-2.5C11,24.869,9.881,23.75,8.5,23.75z M23.5,23.75
									  c-1.381,0-2.5,1.119-2.5,2.5c0,1.381,1.119,2.5,2.5,2.5c1.381,0,2.5-1.119,2.5-2.5C26,24.869,24.881,23.75,23.5,23.75z"></path>
								</svg>
							</span>
							<span class="cart-count">${empty shoppingCart.quantity ? 0 : shoppingCart.quantity}</span>
						</a>
					</li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<div style="height:45px;"></div>
	<t:insertAttribute name="content" />
	<div id="footer">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h3>dodolan manuk</h3>
					<p>
						Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus
						quis lectus metus,<br>Lorem ipsum dolor sit amet, consectetur
						adipiscing elit.
					</p>

					<ul class="list-unstyled social-icon">
						<li>
							<a href="#" rel="tooltip" title="Facebook" class="icon-facebook">
								<span><i class="fa fa-facebook-square"></i></span>
							</a>
						</li>
						<li>
							<a href="#" rel="tooltip" title="Twitter" class="icon-twitter">
								<span><i class="fa fa-twitter"></i></span>
							</a>
						</li>
						<li>
							<a href="#" rel="tooltip" title="Linkedin" class="icon-linkedin">
								<span><i class="fa fa-linkedin"></i></span>
							</a>
						</li>
						<li>
							<a href="#" rel="tooltip" title="Instagram" class="icon-gplus">
								<span><i class="fa fa-google-plus"></i></span>
							</a>
						</li>
						<li>
							<a href="#" rel="tooltip" title="Instagram" class="icon-instagram">
								<span><i class="fa fa-instagram"></i></span>
							</a>
						</li>
					</ul>

					<div class="sitemap">
						<ul>
							<li><a href="${ctx}/">HOME</a></li>
							<li><a href="${ctx}/about">ABOUT</a></li>
							<li><a href="${ctx}/">PROFILE</a></li>
							<li><a href="${ctx}/contact">CONTACT</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="copyright">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<small>Copyright © 2013 Dodolan Manuk All Right Reserved.
						Made With <i class="fa fa-heart-o"></i> by Afriq
					</small>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
