<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../main.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 보기</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<style>
.cartlist img{
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

#list{
	width:600px;
	font-size:1.2em;
	table-layout: fixed;
	
}

#list td, th{
	padding:5px;
	text-align: center;
	vertical-align: middle;
	border-bottom: 1px solid #5F0080;
}

.cartlist .btn {
	width:8px;
	height:8px;
	margin:3px;
	align: center;
}
#calcbox{
	width:300px;
	background-color: rgb(250, 250, 250);
	border: 1px solid rgb(242,242,242);
	margin:5px;
	padding:18px;

}
#calcbox td{
	font-size:1.3em;
	line-height: 1em;
	padding:20px 20px 1px 20px;
	table-layout: fixed;
}



</style>
</head>
<body>

	<div id="wrap" class="cartlist" align="center">
		<h1>${loginUser.uname }님의 장바구니 리스트</h1><br>
		

		
		<form method="post" action="receipt.do">
			<input type="hidden" name="id" value="${loginUser.id }">
			<table id="list">
				<tr>
					<th width="1%"></th>
					<th></th>
					<th width="30%"></th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
				<c:set var="totalprice" value="0" />
				<c:forEach var="cartList" items="${cartList }">
					<tr >
						<!-- <input type="checkbox" name="chk"> -->
						<td>	<input type="hidden" name="pcode[]" value="${cartList.pcode }">
						</td>
						<td><a href="productDetail.do?code=${cartList.pcode }"><img src="img/${cartList.pictureurl }"></a></td>
						<td>${cartList.pname }</td>
						<td>
							<a href="cartUpdate.do?cartcnt=${cartList.cartcnt }&cartnumber=${cartList.cartnumber}&name=minus"><img src="icon/minus.png" class="btn"></a>&nbsp;
							${cartList.cartcnt }개&nbsp;
							<a href="cartUpdate.do?cartcnt=${cartList.cartcnt }&cartnumber=${cartList.cartnumber}&name=plus"><img src="icon/plus.png" class="btn"></a>
							<input type="hidden" name="cartcnt[]" value="${cartList.cartcnt}">
						</td>
						<td>${cartList.price*cartList.cartcnt }원</td>
						<td><a href="cartDelete.do?code=${cartList.cartnumber }">삭제</a></td>
					</tr>
					<c:set var="totalprice" value="${totalprice + (cartList.price*cartList.cartcnt) }"/>
					
				</c:forEach>
				<input type="hidden" name="totalprice" value="${totalprice }">
			</table><br>
			
			<c:choose>
				<c:when test="${!empty cartList }">
			<div id="calcbox">
				<table>
					<tr>
						<td align="left">상품금액</td>
						<td align="right"><c:out value="${totalprice }" />원</td>
					</tr>

					<c:choose>
						<c:when test="${totalprice>=40000 }">
							<tr>
								<td align="left">배송비</td>
								<td align="right">0원</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td></td>
							</tr>
							<tr>
								<td align="left">결제예정금액</td>
								<td align="right" style="font-size:1.4em; font-weight:bold; color:#5F0080;">${totalprice }원</td>
							</tr>
						</c:when>
						<c:otherwise>
						<tr>
								<td align="left">배송비</td>
								<td align="right">4000원</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td></td>
							</tr>
							<tr>
								<td align="left">결제예정금액</td>
								<td align="right" style="font-size:1.4em; font-weight:bold; color:#5F0080;">${totalprice+4000 }원</td>
								
							</tr>
						</c:otherwise>
					</c:choose>
					<tr>
						<td>&nbsp;</td>
						<td></td>
					</tr>
					<tr align="center">
						<td colspan="2"><input type="submit" value="결제하기"></td>
					</tr>
					
				</table>
			
			</div>
			</c:when>
			<c:otherwise>
				<div><h2>장바구니가 비어있습니다.</h2></div>
			</c:otherwise>
			</c:choose>
		
			
		</form>
		
		
	</div>

</body>
</html>