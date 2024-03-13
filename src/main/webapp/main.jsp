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
					<h1><a href="main.do" class="char_lg">마켓컬리</a></h1>
				</div>
				<form action="search.do">
            	<div class="search">
                	<input type="text" placeholder="검색어를 입력해주세요" name="searchText" class="main_search">
                	<input type ="button" onclick="location.href='search.do'" class="search_icon">
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
</div>
</body>
</html>