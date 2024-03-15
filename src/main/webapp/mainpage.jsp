<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<link rel="stylesheet" href="css/mainpage.css">
</head>
<body>
<jsp:include page="main.jsp"/>
<jsp:include page="footer.jsp"/>

<div id="content">
	<section class="shop2">
		<div class="inner">
			<div class="tit_wrap">
				<h3 class="main_tit">
					지금 가장 많이 담는 특가!
				</h3>
				<p class="con_txt">
					컬리 추천 특가템 최대 50%
				</p>
			</div>
			<ul class="shop2_list">
				<li>
					<c:forEach var="product" items="${product }" end="0" >
						<a href="productDetail.do?pcode=${product.pcode }">
							<div class="img_wrap">
								<img src="img/${product.pictureurl}">
							</div>
							<a href="cartInsert.do?pcode=${product.pcode }&cartcnt=1" class="cart_btn">
								<img src="icon/sh_cart.png" class="s_cart">
								담기
							</a>
							<div class="info">
								<h4	class="p_tit">
									${product.pname}
								</h4>
								<p class="price">
									<span class="discount">50%</span>
									 ${product.price}원
								</p>
							</div>
						</a>
					</c:forEach>
				</li>	
				<li>
					<c:forEach var="product" items="${product }" begin="1" end="1" >
						<a href="productDetail.do?pcode=${product.pcode }">
							<div class="img_wrap">
								<img src="img/${product.pictureurl}">
							</div>
							<a href="cartInsert.do?pcode=${product.pcode }&cartcnt=1" class="cart_btn">
								<img src="icon/sh_cart.png" class="s_cart">
								담기
							</a>
							<div class="info">
								<h4	class="p_tit">
									${product.pname}
								</h4>
								<p class="price">
									<span class="discount">50%</span>
									 ${product.price}원
								</p>
							</div>
						</a>
					</c:forEach>
				</li>	
				<li>
					<c:forEach var="product" items="${product }" begin="2" end="2" >
						<a href="productDetail.do?pcode=${product.pcode }">
							<div class="img_wrap">
								<img src="img/${product.pictureurl}">
							</div>
							<a href="cartInsert.do?pcode=${product.pcode }&cartcnt=1" class="cart_btn">
								<img src="icon/sh_cart.png" class="s_cart">
								담기
							</a>
							<div class="info">
								<h4	class="p_tit">
									${product.pname}
								</h4>
								<p class="price">
									<span class="discount">50%</span>
									 ${product.price}원
								</p>
							</div>
						</a>
					</c:forEach>
				</li>	
			</ul>
		</div>
	</section>
	<section class="shop4">
		<div class="inner">
			<div class="tit_wrap">
				<h6 class="main_tit">
				컬리멤버스 특가
				</h6>
				<p class="con_txt">
					매일 달라지는 특가 찬스! 
				</p>
			</div>
			<ul class="shop2_list">
				<li>
					<c:forEach var="product" items="${product }" begin="3" end="3" >
						<a href="productDetail.do?pcode=${product.pcode }">
							<div class="img_wrap">
								<img src="img/${product.pictureurl}">
							</div>
							<a href="cartInsert.do?pcode=${product.pcode }&cartcnt=1" class="cart_btn">
								<img src="icon/sh_cart.png" class="s_cart">
								담기
							</a>
							<div class="info">
								<h4	class="p_tit">
									${product.pname}
								</h4>
								<p class="price">
									<span class="discount">50%</span>
									 ${product.price}원
								</p>
							</div>
						</a>
					</c:forEach>
				</li>				
			</ul>
		</div>
	</section>
</div>
<script src="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.js"></script>
<script src="js/script.js"></script>
</body>
</html>