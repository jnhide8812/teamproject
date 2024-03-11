<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../main.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="script/shop.js"></script>
<!-- <link rel="stylesheet" type="text/css" href="../css/style.css"> -->
<title>개인정보 수정 페이지</title>

</head>
<body>
<div id = "wrap">
	<form action="userUpdate.do" method="post">
		<table align="center" width="550">
			<tr>
				<td colspan="2" align="center">개인정보수정</td>
			</tr>
			<tr>
				<td align="center">아이디</td>
				<td><input type="text" name="id" value="${loginUser.id }"
					readonly></td>
			</tr>
			<tr>
				<td align="center">비밀번호</td>
				<td><input type="password" name="upwd"
					value="${loginUser.upwd }" readonly></td>
			</tr>

			<tr>
				<td align="center">이름</td>
				<td><input type="text" name="uname" value="${loginUser.uname }"
					readonly></td>
			</tr>
			<tr>
				<td align="center">전화번호</td>
				<td><input type="text" name="uphone"
					value="${loginUser.uphone} "></td>
			</tr>

			<tr>
				<td align="center">생년월일</td>
				<td><input type="text" name="ubirth"
					value="${loginUser.ubirth}" readonly></td>
			</tr>

			<tr>
				<td align="center">주소</td>
				<td><input type="text" name="uaddress"
					value="${loginUser.uaddress}"></td>
			</tr>
			<tr>
				<td><input type="text" name="ugrade"
					value="${loginUser.ugrade}"></td>
				<td><input type="hidden" name="upoint"
					value="${loginUser.upoint}"></td>
			</tr>
			<tr>
			<td colspan="2" align="center"><input type="submit" value="수정"></td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>