<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../main.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<!-- <script type="text/javascript" src="script/shop.js"></script> -->
<style>

#mywrap{
	width: 1050px;
	margin: 0px auto;
	padding-top: 300px;
	padding-bottom: 525px;
	background-color: #f7f7f7;
}
.ground{
	display:flex;
	align-items: center;
	justify-content: center;
	flex-direction: column;
	width: 1050px;
	height: 250px;
	background-color: #ffffff;
}
.good {
	display:flex;
	align-items: center;
	justify-content: space-between; 
}
#mywrap h1 {
	font-size: 40px;
	font-weight:700;
	color: #5F0080;
	text-align:center;
	padding-bottom: 20px;
}
li.name{
	display:flex;
	flex-direction: row;
}
.myinfo ul li{
	font-size: 18px;
	letter-spacing: -0.5px;
	font-weight: 500px;
}

.btn_wrap ul li{
	padding-top: 10px; 
}
input.fix{
	
}
</style>
</head>
<body>
 <div id="mywrap">
 	<div class="ground">
 		<h1>마이 컬리</h1>
		<form action="mypage.do" method="post">
			<div class="good">
				<div class="myinfo">
					<ul>
						<li class="name">
							<div class="lev">
							<c:choose>
								<c:when test="${loginUser.ugrade eq 1}">Basic</c:when>
								<c:when test="${loginUser.ugrade eq 2}">VIP</c:when>
							</c:choose>
							</div>
				 			<span>${loginUser.uname}님</span>
						</li>
						<li>
							적립금 &nbsp; ${loginUser.upoint} &nbsp; point
						</li>
					</ul>
				</div>
				<div class="btn_mwrap">
					<ul>
						<li>
							<input type="button" value="개인정보 수정" onclick="location.href='userUpdate.do'" class="fix">
						</li>
						<li>
							<input type="button"value="주문내역 보기" onclick="location.href='orderList.do'" class="list">
						</li>
					</ul>
				</div>
			</div>
		</form>
		</div>
	</div>
</body>
</html>