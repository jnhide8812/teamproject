<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 리스트 - 관리자 페이지</title>
<link rel="stylesheet" type="text/css" href="css/shop.css">
</head>
<body>
<div id="wrap" align="center">
	<h1>상품 리스트 - 관리자 페이지</h1>
	<table class="list">
		<tr>
			<td colspan="5" style="border:white; text-align:right">
				<a href="ManagerWrite.do">상품 등록</a>
				<a href="Manager.do">메인 화면으로</a>
			</td>
		</tr>
		
		<tr>
			<td>상품 코드</td>
			<td>상품 이름</td>
			<td>상품 가격</td>
			<td>잔여 재고</td>
			<td>카테고리 코드</td>
			<td>상품 상태</td>
			<td>수정</td>
			<td>삭제</td>
		</tr>
		
		<c:forEach var="product" items="${managerList}">
		<tr class="recode">
			<td>${product.pcode}</td>
			<td>${product.pname}</td>
			<td>${product.price}원</td>
			<td>${product.pstock}</td>
			<td>${product.catecode}</td>
			<td>${product.pstatus}</td>
			<td><a href="ManagerProductUpdate.do?pcode=${product.pcode}">상품수정</a></td>
			<td><a href="ManagerProductDelete.do?pcode=${product.pcode}">상품삭제</a></td>
		</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>