<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ include file = "header.jsp" %> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="script/shop.js"></script>
<link rel = "stylesheet" type="text/css" href="../css/style.css">
<title>회원가입</title>

</head>
<body>
<form action = "register.do" method="post">
	<table align = "center" width = "550">
	<tr>
	<td colspan = "2" align = "center">회원가입</td>
	</tr>
	<tr>
	<td align = "center">아이디</td>
	<td><input type = "text" name="id" placeholder="아이디 입력">
		<input type = "button" value="중복 확인" onclick = "idCheck()">
		<input type = "hidden" name= "reid" > 
	</td> 
	</tr>
	<tr>
	<td align = "center">비밀번호</td>
	<td><input type = "password" name="upwd" placeholder="비밀번호 입력"></td>
	</tr>
	<tr>
	<td align = "center">비밀번호 확인</td>
	<td> <input type="password" name="upwd_re" placeholder="비밀번호 재입력" onclick ="return pwdTest()"></td>
	</tr> 
	
	<tr>
	<td align = "center">이름</td>
	<td><input type = "text" name="uname"></td> 
	</tr>
	<tr>
	<td align = "center">전화번호</td>
	<td><input type = "text" name="uphone"></td>
	</tr>
	
<!--<tr>
	<td align = "center">권한</td>
	<td><select name ="lev">
		<option value="0" >운영자</option>
		<option value="1" >일반회원</option>
	</select>
	</td>
	</tr> -->
	
	<tr>
	<td align = "center">생년월일</td>
	<td><input type = "text" name="ubirth"></td> 
	</tr>
	
	<tr>
	<td align = "center">주소</td>
	<td><input type = "text" name="uaddress"></td>
	</tr>
	<tr>
	<td><input type = "hidden" name="ugrade" value="1"></td>
	<td><input type = "hidden" name="upoint" value="0"></td>
	</tr>
	
	<td colspan = "2" align="center">
		<input type="submit" value="회원가입하기" onclick="location.href='login.do'" id="joinBtn">
	</td>
	</tr>




</table>
</form>
</body>
</html>