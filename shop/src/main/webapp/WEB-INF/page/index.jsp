<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="home">
	<div id="home-slider" class="carousel slide carousel-fade"
		data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#home-slider" data-slide-to="0" class=""></li>
			<li data-target="#home-slider" data-slide-to="1" class="active"></li>
			<li data-target="#home-slider" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="item"
				style="background: url(${ctx}/assets/img/img01.jpg);">
				<div class="container">
					<div class="row">
						<div class="col-md-12">
							<div class="carousel-content">
								<h2 class="animated fadeInUpBig text-center text-black">Hello</h2>
								<p class="animated rollIn text-black text-center">
									<span class="text900">Welcome to Dodolan Manuk</span> an
									awesome catalog theme, <br> built with <i
										class="fa fa-heart-o"></i> in <span class="text900">Ngayogyokarto
										hadiningrat.</span><br> <br> <a href="#"
										class="btn btn-purple btn-lg">Get Started</a>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="item active"
				style="background: url(${ctx}/assets/img/img02.jpg);">
				<div class="container">
					<div class="row">
						<div class="col-md-12">
							<div class="carousel-content">
								<h3 class="animated fadeInLeftBig text-left">.Built</h3>
								<p class="animated fadeInDownBig text-left">
									Your own online shop using this catalog theme.<br> Simple
									and easy cutomize just $12.
								</p>
								<a class="btn btn-purple btn-lg animated fadeInRight" href="#">Learn
									more »</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<a class="left carousel-control" href="#home-slider" data-slide="prev">
			<i class="fa fa-angle-left"></i>
		</a> <a class="right carousel-control" href="#home-slider"
			data-slide="next"> <i class="fa fa-angle-right"></i>
		</a>
		<div class="pattern"></div>
	</div>

</div>
<div id="featured">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="heading-title">
					<h2>Top Product</h2>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-sm-4">
				<div class="featured-container">
					<div class="featured-photos">
						<i class="fa fa-gift"></i>
					</div>
					<h3>Top Products</h3>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
						Phasellus quis lectus metus, at posuere neque.</p>
					<p>
						<a
							href="http://templateninja.net/themes/dodolanmanuk/v1.1/purple/single.html"
							class="btn btn-purple">Read more »</a>
					</p>
				</div>
			</div>
			<div class="col-md-4 col-sm-4">
				<div class="featured-container">
					<div class="featured-photos">
						<i class="fa fa-heart-o"></i>
					</div>
					<h3>Top Product</h3>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
						Phasellus quis lectus metus, at posuere neque.</p>
					<p>
						<a
							href="http://templateninja.net/themes/dodolanmanuk/v1.1/purple/single.html"
							class="btn btn-purple">Read more »</a>
					</p>
				</div>
			</div>
			<div class="col-md-4 col-sm-4">
				<div class="featured-container">
					<div class="featured-photos">
						<i class="fa fa-flag"></i>
					</div>
					<h3>Top Product</h3>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
						Phasellus quis lectus metus, at posuere neque.</p>
					<p>
						<a
							href="http://templateninja.net/themes/dodolanmanuk/v1.1/purple/single.html"
							class="btn btn-purple">Read more »</a>
					</p>
				</div>
			</div>
		</div>
	</div>
</div>
<div id="catalogue">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="heading-title">
					<h2>Hot Products</h2>
				</div>
			</div>
		</div>
		<div class="row">
			<c:forEach begin="1" end="12">
			<div class="col-md-3 col-sm-4 col-xs-12">
				<div class="thumbnail product-item">
					<a href=""><img src="http://i00.i.aliimg.com/photo/v0/60150501702_1/New_Trend_Fantasitic_Design_Geyser_rda_1.jpg_220x220.jpg"/></a>
					<div class="caption-details">
						<a href=""><h3>Border Canary</h3></a>
						<span class="price">$200</span>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>
	</div>
</div>