<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 보기</title>
<link rel = "stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div align="center">
		<h1>장바구니 리스트</h1>

		<table>
			<tr>
				<th>이미지</th>
				<th>상품이름</th>
				<th>상품수량</th>
				<th>금액</th>
			</tr>
			<c:forEach var="cartList" items="${cartList }">
				<tr>
					<td><img src="img/${cartList.pictureurl }"></td>
					<td>${cartList.pname }</td>
					<td>${cartList.cartcnt }</td>
					<td>${cartList.price }</td>
				</tr>
			</c:forEach>


		</table>
	</div>

</body>
</html>