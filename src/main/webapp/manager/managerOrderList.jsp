<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 리스트 - 관리자 페이지</title>
<link rel="stylesheet" type="text/css" href="css/manager.css">
</head>
<body>
<div id="wrap" align="center">
	<h1>주문 목록 리스트 - 관리자</h1>
	<hr><hr><br>
	<table class="list">
		<tr>
			<td colspan="5" style="border:white; text-align:right">
				<a href="Manager.do">메인 화면</a>
			</td>
		</tr>
		
		
		<tr>
			<td>주문 번호</td>
			<td>아이디</td>
			<td>주 소</td>
			<td>주문 물품</td>
			<td>배송 상태</td>			
		</tr>
		
		<c:forEach var="orderdetail" items="${managerOrderList}">
		<tr class="recode">
			<td><a href="ManagerOrderDetail.do?ordernumber=${orderdetail.ordernumber}"></a></td>
			<td>${orderdetail.id}</td>
			<td>${orderdetail.daddress}</td>
			<td>${product.pstock}</td>
			<td></td>
			<td>${orderdetail.pstatus}</td>
		</tr>
		</c:forEach>
		
	</table>
</div>
</body>
</html>