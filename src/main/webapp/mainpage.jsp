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
<link rel="stylesheet" href="css/footer.css">
</head>
<body>
<jsp:include page="main.jsp"/>
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
			<ul class="shop_list">
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
			<ul class="shop_list">
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
				<li>
					<c:forEach var="product" items="${product }" begin="4" end="4" >
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
					<c:forEach var="product" items="${product }" begin="5" end="5" >
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
	<div id="ft_section">
		<footer>
			<div class="mid">
				<div class="ft_shop1">
					<div class="inner">
						<div class="ft_left">
							<div class="box1">
								<h2>고객행복센터</h2>
								<p class="open">
									1644-1107<span class="time">월~토요일 오전7시-오후6시</span>
								</p>
							</div>
							<ul class="ft_list">
								<li>
									<a href="#" class="ask_btn">카카오톡 문의</a>
									<p class="list_tit">
										월~토요일 : 오전7시 ~ 오후6시<br>
										일/공휴일 : 오전7시 ~ 오후1시
									</p>
								</li>
								<li>
									<a href="#" class="ask_btn">1:1 문의</a>
									<p class="list_tit">
										365일<br>
										고객센터 운영시간에 순차적으로 답편해드리겠습니다. 
									</p>
								</li>
								<li>
									<a href="#" class="ask_btn">대량주문 문의</a>
									<p class="list_tit">
										월~금요일 : 오전9시 ~ 오후6시<br>
										점심시간 : 낮12시-오후1시 
									</p>
								</li>
							</ul>
							<span class="ask_e">
							비회원 문의 : help@kurlycorp.com
							</span>
						</div>
						<div class="ft_right">
							<nav>
								<ul class="ft_list">
									<li><a href="#">컬리소개</a></li>
									<li><a href="#">컬리소개영상</a></li>
									<li><a href="#">투자정보</a></li>
									<li><a href="#">인재채용</a></li>
									<li><a href="#">이용약관</a></li>
									<li><a href="#" class="personal">개인정보처리방침</a></li>
									<li><a href="#">이용안내</a></li>
								</ul>
							</nav>
							<p class="address">
								법인명(상호):주식회사 컬리 | 사업자등록번호 : 261-81-23567 <span>사업자정보 확인</span><br>
								통신판매업 : 제 2018-서울강남-01646호<br>
								주소 : 서울특별시 강남구 테헤란로 133, 18충 (역삼동) | 대표이사 김슬아<br>
								채용문의 : <span>recruit@kurlycorp.com</span><br>
								팩스 : 070-7500-6098<br>
							</p>
							<ul class="sns_wrap"> 
								<li>
									<a href="#">
										<img src="icon/instagram.png" class="ft_sns">
									</a>
								</li>
								<li>
									<a href="#">
										<img src="icon/facebook.png" class="ft_sns">
									</a>
								</li>
								<li>
									<a href="#">
										<img src="icon/blog.png" class="ft_sns">
									</a>
								</li>
								<li>
									<a href="#">
										<img src="icon/post.png" class="ft_sns">
									</a>
								</li>
								<li>
									<a href="#">
										<img src="icon/youtube.png" class="ft_sns">
									</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
				<div class="ft_shop2">
					<div class="inner">
						<ul class="ft_list2">
							<li>
								<img src="icon/isms.png" class="icon_wrap">
								<p class="ft_list_txt">
									[인증범위] 컬리 쇼핑몰 서비스 개발, 운영<br>
									(심사받지 않은 물리적 인프라 제외)<br>
									[유효기간] 2022.01.19 ~ 2025.01.18
								</p>
							</li>
							<li>
								<img src="icon/ft_icon2.png" class="icon_wrap">
								<p class="ft_list_txt">
									개인정보보호 우수 웹사이트<br>
									개인정보처리시스템 인증(ePRIVACY PLUS)
								</p>
							</li>
							<li>
								<img src="icon/t_pay.svg" class="icon_wrap_pay">
								<p class="ft_list_txt">
									토스페이먼츠 구매안전(예스크로)<br>
									서비스를 이용하실수 있습니다.
								</p>
							</li>
							<li>
								<img src="icon/bank.png" class="icon_wrap">
								<p class="ft_list_txt">
									고객님이 현금으로 결제한 금액에 대한 우리은행과<br>
									재무지급보증 계약을 채결하여 안전거래를 보장하고<br>
									있습니다.
								</p>
							</li>
						</ul>
					</div>
				</div>
				<div class="ft_shop3">
					<div class="inner">
						<div class="tit_wrap">
							컬리에서 판매되는 상품 중에는 컬리에 입점한 개별 판매자가 판매하는 마켓플레이스(오픈마켓) 상품이 포함되어 있습니다.<br>
							마켓플레이스(오픈마켓) 상품의 경우 컬리는 통신판매중개자로서 통신판매의 당사자가 아닙니다. 컬리는 해당 상품의 주문, 품질, 교환/환불 등 의무와 책임을 부담하지 않습니다.
						</div>
						<br>
						<p class="con_txt">
							<img src="icon/ccc.png" class="bottom">
							KURLY CORP.ALL RIGHTSRESERVED
						</p>
					</div>
				</div>
			</div>
		</footer>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.js"></script>
<script src="js/script.js"></script>
</body>
</html>