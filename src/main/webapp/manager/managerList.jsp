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
<header>
<table>
	<tr>
		<td><a href="main.do"><img id="logo" src="icon/kurly.jpeg"></a></td>
		<th>${users.uname}관리자님 환영합니다.</th>
			<td align="right" id="padding">
			<a href="logout.do">로그아웃</a> &nbsp;
			<a href="manager.do">관리자 메인으로</a>
			</td>
	</tr>

</table>
</header>
<div id="wrap" align="center">
	<table id="list">
		<tr style="background-color: #5f0080;">
			<td colspan="8" style="border:white; text-align:right">
				<a id="littlepadding" href="ManagerWrite.do" style="color: white;">상품 등록</a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a id="littlepadding" href="Manager.do" style="color: white;">메인 화면</a>
			</td>
		</tr> 
		
		
		<tr id="textcenter" style="background-color: #5f0080; color: white;">
			<td>상품 코드</td>
			<td>상품 이름</td>
			<td>상품 가격</td>
			<td>잔여 재고</td>
			<td>카테고리 코드</td>
			<td>상품 상태</td>
			<td colspan="2">수정 / 삭제</td>
			
		</tr>
		
		<c:forEach var="productList" items="${productList}">
		<tr class="recode">
			<td>${productList.pcode}></td>
			<td>${productList.pname}</td>
			<td>${productList.price}</td>
			<td>${productList.pstock}</td>
			<td>${productList.catecode}</td>
			<td align="center">${productList.pstatus}</td>
			<td align="center"><a id="little" href="ManagerProductUpdate.do?pcode=${productList.pcode}">수정</a></td>
			<td align="center"><a id="little" href="ManagerProductDelete.do?pcode=${productList.pcode}">삭제</a></td>
		</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>