<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script type="text/javascript" src="script/shop.js"></script>
<link rel = "stylesheet" type="text/css" href="css/login.css">
</head>
<body>
<div id="lncontainer">
	<form action="login.do" method="post" class="main">
	<table class="log">
		<tr>
			<th colspan="1" align="center" class="tit" >로그인</th>
		</tr>
		<tr>
			<td><input type="text" placeholder="아이디를 입력해주세요" name="id" class="id"></td>
		</tr>
		<tr>
			<td><input type="password" placeholder="비밀번호를 입력해주세요" name="upwd" class="pwd"></td>
		</tr>
		<tr>
			<td class="find">
				<a href="findId.do">아이디 찾기</a>
				<span class="divide"></span>
				<a href="findPwd.do">비밀번호 찾기</a>
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="로그인" class="blog">
			</td>
		</tr>
		<tr>
			<td>
				<input type="button" value="회원가입" onclick="location.href='register.do'" class="regi">
			</td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td align="center">${message }</td></tr>
	</table>
	</form>

</div>
</body>
</html>