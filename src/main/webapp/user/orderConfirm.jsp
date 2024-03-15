<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 완료 페이지</title>
<link rel="stylesheet href="css/style.css">
<style>


#wrap{
	width:1050px;
	padding-top: 250px;
	margin:0px auto;

}
.back {
	width: 350px;
	height: 250px;
	background-color: #F5F0FA;
	border-radius: 5px;
	border: 1px solid #F5F0FA;
}
.tit{
	padding-top: 30px;
}
h1{
	font-size: 28px;
	color:#5F0080;
	font-weight: bold;
	text-align:center;
	padding-bottom: 25px;
	
}
.orlist ul{
	display:flex;
	flex-direction:column;
	align-items: center;
	justify-content: space-between;
	height: 180px;
	padding-bottom: 25px;
	
}
.orlist ul li{
	font-size: 18px;
	font-weight: 400;
	padding-top: 20px;
}

	
.orbtn{
	width: 315px;
	height: 55px;
	background-color: #5F0080;
	border:1px solid #5F0080;
	text-align:center;
	border-radius: 5px;
	display: flex;
	align-items: center;
	justify-content: center;

}
.orbtn a.listbtn{
	color: #FFFFFF;
	font-size: 18px;
}

</style>

</head>
<body>
<div id="wrap" align="center">
<div class="back">
	<div class="tit">
		<h1>주문 완료</h1>
		<div class="orlist">
			<ul>
				<li>
					주문번호 : ${ordernumber} || 결제금액 : ${ordertable.totalprice }
				</li>
				<li>
					<div class="orbtn">
						<a href="orderList.do" class="listbtn">주문내역보기</a>
					</div>
				</li>
			</ul>
		</div>
	</div>
</div>
</div>

</body>
</html>