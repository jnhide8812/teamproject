<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shop.css">
<script type="text/javascript"></script>
</head>
<body>
<div id="wrap" align="center">
<form method="post" name="frm" enctype="multipart/form-data">
<header>
<table >
	<tr text-align="center">
		<td><a href="main.do"><img src="kurly.jpeg"></a></td>
		<td>${users.uname}관리자님 환영합니다.</td>
	</tr>
	<tr text-align="center">
	<a href="logout.do">로그아웃</a>
	</tr>
	<tr text-align="center">
	<a href="manager.jsp">관리자 메인으로</a>
	</tr>
</table>
</header>
<table>
<tr>
	<td><a href="managerWrite.do">상품 등록</a></td><td><a href="managerList.do">상품리스트</a></td>
</tr>
<tr>
	<td><a href="managerOrderList.do">주문 목록</a></td><td><a href="memberList.do">회원 관리</a></td>
</tr>
</table> 
</form>

</div>

</body>
</html>