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
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<div style="height:45px;"></div>
	<div id="main">
		<t:insertAttribute name="content" />
	</div>
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
