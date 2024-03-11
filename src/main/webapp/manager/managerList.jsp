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
	<h1>상품 리스트 - 관리자 </h1>
	<hr><hr><br>
	<table class="list">
		<tr>
			<td colspan="8" style="border:white; text-align:right">
				<a href="ManagerWrite.do">상품 등록</a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="Manager.do">메인 화면</a>
			</td>
		</tr>
		
		
		<tr>
			<td>상품 코드</td>
			<td>상품 이름</td>
			<td>상품 가격</td>
			<td>잔여 재고</td>
			<td>카테고리 코드</td>
			<td>상품 상태</td>
			<td><a href="ManagerProductUpdate.do">수정</a></td>
			<td><a href="ManagerProductDelete.do">삭제</a></td>
			
		</tr>
		
		<c:forEach var="productList" items="${productList}">
		<tr class="recode">
			<td>${productList.pcode}></td>
			<td>${productList.pname}</td>
			<td>${productList.price}</td>
			<td>${productList.pstock}</td>
			<td>${productList.catecode}</td>
			<td>${productList.pstatus}</td>
			<td><a href="ManagerProductUpdate.do?pcode=${productList.pcode}">수정</a></td>
			<td><a href="ManagerProductDelete.do?pcode=${productList.pcode}">삭제</a></td>
		</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>