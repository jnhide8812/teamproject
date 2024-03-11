<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../main.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<script type="text/javascript" src="script/shop.js"></script>
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
	<form action="mypage.do" method="post">
		<table>
			<tr>
				<td>${loginUser.ugrade} ${loginUser.id }</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button" value="개인정보 수정" onclick="location.href='userUpdate.do'"></td>
			</tr>
			<tr>
				<td>적립금 ${loginUser.upoint}</td>
				<td colspan="2" align="center"><input type="button"value="주문내역 보기" onclick="location.href='orderList.do'"></td>
			</tr>
		</table>

	</form>
</body>
</html>