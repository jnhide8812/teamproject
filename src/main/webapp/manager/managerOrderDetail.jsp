<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" href="css/manager.css">
<script type="text/javascript" src="script/shop.js"></script>
</head>
<body>
<header>

<table>
	<tr>
		<td><a href="main.do"><img id="logo" src="icon/kurly.jpeg"></a></td>
		<th>${users.uname}관리자님 환영합니다.</th>
			<td align="right" id="padding">
			<a href="logout.do">로그아웃</a> &nbsp;
			<a href="Manager.do">관리자 메인으로</a>
			</td>
	</tr> 
</table>

</header>
	<form method="post" action="ManagerOrderDetail.do">
		<div id="image_container" align="center">
			
			<input type="hidden" name="orderdetailnumber" 
			value="${orderdetail.orderdetailnumber}">
		<br>
		<table id="list" style="width: 500px;">
				<tr>
					<th style="text-align: right; font-size: 16px;">아이디</th>
					<td><input type="text" name="id"
						value="${orderdetail.id}" readonly></td>
				</tr>

				<tr>
					<th style="text-align: right; font-size: 16px;">배송지 주소</th>
					<td><input type="text" name="daddress" 
					value="${orderdetail.daddress}" readonly></td>
				</tr>

				<tr>
					<th style="text-align: right; font-size: 16px;">상품 코드</th>
					<td><input type="text" name="pcode"
						value="${orderdetail.pcode}" readonly></td>
				</tr>

				<tr>
					<th style="text-align: right; font-size: 16px;">수령인 이름</th>
					<td><input type="text" name="pname"
						value="${orderdetail.dname}" readonly></td>
				</tr>
				
				<tr>
					<th style="text-align: right; font-size: 16px;">주문 물품 수량</th>
					<td><input type="text" name="ordercnt"
						value="${orderdetail.ordercnt}" readonly>&nbsp;개</td>
				</tr>

				<tr>
					<th style="text-align: right; font-size: 16px;">Total 금액</th>
					<td><input type="text" name="totalprice">&nbsp;원</td>
				</tr>

				<tr>
					<th style="text-align: right; font-size: 16px;">주문 상태 변경</th>
					<td>
						<select name="oderstatus">
							<option value="1" selected>결제완료</option>
							<option value="2">배송중</option>
							<option value="3">배송완료</option>
					</select>
					</td>
				</tr>		
			</table>
			
			<br>
			<input type="submit" value="확인" onclick="location href='ManagerOrderDetail.do'">
		</div> 
	</form>
</body>
</html>