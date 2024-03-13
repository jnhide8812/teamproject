<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script>
const swiper = new Swiper(".slider_wrap", {
    effect : 'fade', // 페이드 효과 사용
    loop: true,
    navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
    },
    pagination: {
        el: ".swiper-pagination",
    },
});
</script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css" />
<!--<link rel="stylesheet" href="css/mainpage.css">  -->
</head>
<body>
<jsp:include page="main.jsp"/>
<jsp:include page="footer.jsp"/>

<div id="content">
	<section class="shop1">
		<div class="swiper slider_wrap">
			<div class="inner">
				<div class="swiper-slide s01"></div>
				<div class="swiper-slide s02"></div>
				<div class="swiper-slide s03"></div>
				<div class="swiper-slide s04"></div>
				<div class="swiper-slide s05"></div>
				<div class="swiper-slide s06"></div>
				<div class="swiper-slide s07"></div>
				<div class="swiper-slide s08"></div>
			</div>
			<div class="swiper-button-next"></div>
        	<div class="swiper-button-prev"></div>
        	<div class="swiper-pagination"></div>
		</div>	
	</section>
	<section class="shop2">
		<div class="inner">
			<div class="tit_wrap">
				<h3 class="main_tit">
					지금 가장 많이 담는 특가
					<img src="icon/r_errow.png" class="errow">
				</h3>
				<p class="con_txt">
					컬리 추천 특가템 최대 50%
				</p>
			</div>
		<c:forEach var="product" items="${product }" end="12" >
			<ul class="shop2_list">
				<li>
					<a href="productDetail.do">
						<div class="img_wrap">
							<img src="img/${product.pictureurl}">
						</div>
						<a href="cartInsert.do?pcode=${product.pcode }&cartcnt=1" class="cart_btn">
							<img src="icon/sh_cart" class="s_cart">
							담기
						</a>
						<h4	class="p_tit">
							${product.pname}
						</h4>
						<p class="price">
							<span class="discount">50%</span>
							 ${product.price}
						</p>
					</a>
				</li>
		</c:forEach>
				<li>
					<a href="#">
						<div class="img_wrap">
							<img src="img/apple.jpg">
						</div>
						<a href="#" class="cart_btn">
							<img src="icon/sh_cart" class="s_cart">
							담기
						</a>
						<h4	class="p_tit">
							상품명
						</h4>
						<p class="price">
							<span class="discount">50%</span>
							상품 가격
						</p>
					</a>
				</li>
				<li>
					<a href="#">
						<div class="img_wrap">
							<img src="img/apple.jpg">
						</div>
						<a href="#" class="cart_btn">
							<img src="icon/sh_cart" class="s_cart">
							담기
						</a>
						<h4	class="p_tit">
							상품명
						</h4>
						<p class="price">
							<span class="discount">50%</span>
							상품 가격
						</p>
					</a>
				</li>
				<li>
					<a href="#">
						<div class="img_wrap">
							<img src="img/apple.jpg">
						</div>
						<a href="#" class="cart_btn">
							<img src="icon/sh_cart" class="s_cart">
							담기
						</a>
						<h4	class="p_tit">
							상품명
						</h4>
						<p class="price">
							<span class="discount">50%</span>
							상품 가격
						</p>
					</a>
				</li>
			</ul>
		</div>
	</section>
	<section class="shop3">
		<div class="inner">
			<div class="tit_wrap">
				<h5 class="main_tit">
					라포슈포제 마스크팩 6천원대!
				</h5>
				<p class="con_txt">
					선착순 600개 한정! 38% 할인 + 10%쿠폰 
				</p>
			</div>
		</div>
	</section>
	<section class="shop4">
		<div class="inner">
			<div class="tit_wrap">
				<h6 class="main_tit">
					매일 오전 11시<br>
					OPEN!
				</h6>
				<p class="con_txt">
					24시간 한정 일일특가
				</p>
			</div>
		</div>
		<ul class="shop4_lists">
			<li>
				<a href="#">
					<div class="img_wrap">
						<img src="img/apple.jpg">
					</div>
					
					<a href="#" class="cart_btn">
						<img src="icon/sh_cart" class="s_cart">
							담기
					</a>
					
					<h4	class="p_tit">
						상품명
					</h4>
					<p class="price">
						<span class="discount">50%</span>
						상품 가격
					</p>
				</a>
			</li>
			<li>
				<a href="#">
					<div class="img_wrap">
						<img src="img/apple.jpg">
					</div>
					
					<a href="#" class="cart_btn">
						<img src="icon/sh_cart" class="s_cart">
							담기
					</a>
					
					<h4	class="p_tit">
						상품명
					</h4>
					<p class="price">
						<span class="discount">50%</span>
						상품 가격
					</p>
				</a>
			</li>
			<li>
				<a href="#">
					<div class="img_wrap">
						<img src="img/apple.jpg">
					</div>
					
					<a href="#" class="cart_btn">
						<img src="icon/sh_cart" class="s_cart">
							담기
					</a>
					
					<h4	class="p_tit">
						상품명
					</h4>
					<p class="price">
						<span class="discount">50%</span>
						상품 가격
					</p>
				</a>
			</li>
		</ul>
	</section>
</div>
<script src="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.js"></script>
<script src="js/script.js"></script>
</body>
</html>