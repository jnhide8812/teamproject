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
.myinfo{
	display:flex;
	flex-direction: row;
}
.good {
	width: 850px;
	height:140px;
	display:flex;
	align-items: center;
	justify-content: space-between; 
}
ul.grade{
	width: 140px;
	height: 140px;
	display:flex;
	text-align:center;
	justify-content:center;
}
ul.grade li {
	width:140px;
	height: 140px;
	background-color: white;
	border: 2px solid #5F0080;
	text-align:center;
	border-radius: 50%;
	display: flex;
	align-items: center;
	justify-content:center;

}
ul.grade li{
	color: #5F0080;
	font-size: 30px;
	font-weight: 700;
	letter-spacing: -0.5px;
}
ul.text {
	display: flex;
	align-items: center;
	justify-content:center;
	text-align:left;
	flex-direction: column;
	padding:0px 50px;
}
ul.text li{
	padding-bottom: 10px;
	font-size: 20px;
}

#mywrap h1 {
	font-size: 40px;
	font-weight:700;
	color: #5F0080;
	text-align:center;
	padding-bottom: 20px;
}
ul.text li.name{
	font-size: 30px;
	font-weight: 600;
	color: #333;
	letter-spacing: -0.5px;
}

.btn_wrap ul{
	padding: 20px 0px; 
	
}
input.fix{
	width: 230px;
	height:50px;
	display:flex;
	text-align:center;
	justify-content: center;
	background-color: #5F0080;
	color: white;
	border: 1px solid #5F0080;
	border-radius: 6px;
	font-size: 16px;
	font-weight: 600px;
	margin-bottom:10px;
}
input.list{
	width: 230px;
	height:50px;
	display:flex;
	text-align:center;
	justify-content: center;
	background-color: #fffff;
	color: #5F0080;
	border: 1px solid #5F0080;
	border-radius: 6px;
	font-size: 16px;
	font-weight: 600;
	margin-bottom:10px;
}
</style>
</head>
<body>
 <div id="mywrap">
 	<div class="ground">
 		<h1>마이 컬리</h1>
		<form action="mypage.do" method="post" class="mm">
			<div class="good">
				<div class="myinfo">
					<ul class="grade">
						<li>
							<div class="lev">
							<c:choose>
								<c:when test="${loginUser.ugrade eq 1}">Basic</c:when>
								<c:when test="${loginUser.ugrade eq 2}">VIP</c:when>
							</c:choose>
							</div>
						</li>
					</ul>
					<ul class="text">
						<li class="name">
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