<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../main.jsp"%>

<style>
#wrap {
	margin: 100px;
	padding: 5px;
}

#findId {
	width: 1000px;
	font-size: 1.2em;
	table-layout: fixed;
	margin: 0 auto;
}

#findId td, th {
	padding: 5px;
	text-align: center;
	vertical-align: middle;
}
</style>
</head>
<body>
	<div id="wrap">
		<form>
			<table border="1" id="findId">
				<tr>
					<th>고객님의 컬리 계정을 찾았습니다</th>
				</tr>
				<tr>
					<th>아이디 확인 후 로그인해 주세요</th>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>고객님의 아이디 : ${id}</td>
				</tr>

				<tr>
					<td><input type="button" value="비밀번호 찾기"
						onclick="location.href='findPwd.do'">&nbsp;&nbsp;
						<input type="button" value="로그인" onclick="location.href='login.do'"></td>
				</tr>



			</table>

		</form>
	</div>
</body>
</html>