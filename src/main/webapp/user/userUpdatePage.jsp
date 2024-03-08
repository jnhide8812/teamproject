<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ include file = "header.jsp" %> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="script/shop.js"></script>
<link rel = "stylesheet" type="text/css" href="../css/style.css">
<title>개인정보 수정 페이지</title>

</head>
<body>
<form action = "userUpdate.do" method="post">
	<table align = "center" width = "550">
	<tr>
	<td colspan = "2" align = "center">개인정보수정</td>
	</tr>
	<tr>
	<td align = "center">아이디</td>
	<td><input type = "text" name="id" readonly></td> 
	</tr>
	<tr>
	<td align = "center">비밀번호</td>
	<td><input type = "password" name="upwd" readonly></td>
	</tr>
 
	<tr>
	<td align = "center">이름</td>
	<td><input type = "text" name="uname" readonly></td> 
	</tr>
	<tr>
	<td align = "center">전화번호</td>
	<td><input type = "text" name="uphone"></td>
	</tr>
	
	<tr>
	<td align = "center">생년월일</td>
	<td><input type = "text" name="ubirth" readonly></td> 
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
		<input type="submit" value="수정" onclick="location.href='mypage.jsp'">
	</td>
	</tr>
</table>
</form>
</body>
</html>