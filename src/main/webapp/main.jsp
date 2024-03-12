<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/main.css">
</head>
<body>
<div id="container">
	<header>
		<div class="inner">
			<nav class="h_top">
				<ul>
				<c:if test="${empty loginUser }">
					<li class="regi"><a href="register.do">회원가입</a></li>
					<li><a href="login.do">로그인</a></li>
				</c:if>
					<c:if test="${!empty loginUser }">
						<li>${loginUser.uname}님</li>
						<li class="regi"><a href="logout.do">로그아웃</a></li>
						<li><a href="mypage.do">마이페이지</a></li>
				</c:if>
				</ul>
			</nav>
			<div class="middle">
				<div class="logo">
					<img src="./icon/h_logo.png" class="h_logo">
					<h1><a href="mainpage.jsp" class="char_lg">마켓컬리</a></h1>
				</div>
				<form action="https://search.naver.com/search.naver">
            	<div class="search">
                	<input type="text" placeholder="검색어를 입력해주세요" class="main_search">
                	<button type="submit" class="search_icon"></button>
                </div>
               </form>
               <a href="cart.do" class="cart">
               		<img src="icon/h_cart.png" alt="위에 카트" class="h_cart">
               </a>
        	 </div>

        	 <div class="h_bottom">
        	 	<div class="category">
        	 		<img src="icon/menu.png" class="menu">
        	 		<span>카테고리</span>
        	 	</div>
        	 	<nav>
        	 		<ul>
        	 			<li><a href="#">신상품</a></li>
        	 			<li><a href="#">베스트</a></li>
        	 			<li><a href="#">알뜰쇼핑</a></li>
        	 		</ul>
        	 	</nav>
			</div>
		</div>
	</header>
	<footer>
		<div class="ft_shop1">
			<div class="inner">
			<div class="ft_left">
				<div class="tit_wrap">
					<h7 class="main_tit">
						고객행복 센터
					</h7>
					<p class="con_txt">
						<span class="num">1644-1107</span>
						월~토요일 오전7시- 오후6시
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
			</div>
			<div class="ft_right">
				<nav>
					<ul class="ft_list">
						<li><a href="#">컬리소개</a></li>
						<li><a href="#">컬리소개영상</a></li>
						<li><a href="#">투자정보</a></li>
						<li><a href="#">인재채용</a></li>
						<li><a href="#">이용약관</a></li>
						<li><a href="#">개인정보처리방침</a></li>
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
							<img src="../icon/youtube.png" class="ft_sns">
						</a>
					</li>
				</ul>
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
						<img src="icon/t_pay.png" class="icon_wrap">
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
				<p class="con_txt">
					<img src="icon/c_icon.png" class="bottom">
					KURLY CORP.ALL RIGHTSRESERVED
				</p>
			</div>
		</div>
	</footer>
</div>
</body>
</html>