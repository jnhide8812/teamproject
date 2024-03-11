<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script type="text/javascript" src="script/shop.js"></script>
<link rel = "stylesheet" type="text/css" href="../css/login.css">
</head>
<body>
<form action="login.do" method="post" id="main">
<table class="log">
	<tr>
		<td colspan="1" align="center" class="tit" >로그인</td>
	</tr>
	<tr>
		<td><input type="text" placeholder="아이디를 입력해주세요" name="id" class="id"></td>
	</tr>
	<tr>
		<td><input type="password" placeholder="비밀번호를 입력해주세요" name="upwd" class="pwd"></td>
	</tr>
	<tr>
		<td class="fid"><a href="#">아이디 찾기</a></td>
		<td>|</td>
		<td class="fpwd"><a href="#">비밀번호 찾기</a></td>
	</tr>
	<tr>
		<td>
			<input type="submit" value="로그인" class="blog">
		</td>
	</tr>
	<tr>
		<td>
			<input type="button"  value="회원가입" class="regi">
		</td>
	</tr>
</table>
</form>
</body>
</html>