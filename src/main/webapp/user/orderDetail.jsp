<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 상세 내역</title>
<style>
.orderDetailList img{
	width:50px;
	height:68px;
	object-fit:cover;

}
h1{
	font-size:1.5em;
	color:#5F0080;
	font-weight: bold;
	
}

#wrap{
	margin:100px;
	padding:5px;

}

.list{
	width:600px;
	font-size:1.2em;
	table-layout: fixed;
	
}

.list td, th{
	vertical-align: middle;
	border-bottom: 1px solid #5F0080;
	line-height: 2em;
	
}


</style>
</head>
<body>
<div id="wrap" class="orderDetailList" align ="center">
	<h1>주문 내역 상세</h1><br>
		<table class="list">
			<tr>
				<th width="30%" align="center">주문 번호 : ${orderList.ordernumber }</th>
				<th></th>
			</tr>
			<c:forEach var="orderDetailList" items="${orderDetailList }">
				<tr>
					<td align="center"><img src="img/${orderDetailList.pictureurl}">
					<td>${orderDetailList.pname} <br>
					${orderDetailList.price}원 | ${orderDetailList.ordercnt}개</td>
				</tr>

			</c:forEach>
			 
		</table>
		<br><br><br>
		<table class="list">
			<tr>
				<th colspan="2">결제 정보</th>
			</tr>
			<tr>
				<td>결제 금액</td><td>${orderList.totalprice}</td>
			</tr>
			<tr>
				<td>결제 방법</td><td>${orderList.payment}</td>
			</tr>
			<tr>
				<td>배송 상태</td><td>${orderList.orderstatus}</td>
			</tr>
		
		</table><br>
		
		
			<input type="button" value="목록으로" onClick='location.href="orderList.do"'>

	</div>


</body>
</html>