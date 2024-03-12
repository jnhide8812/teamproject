<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ include file = "header.jsp" %> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="script/shop.js"></script>
<link rel="stylesheet" type="text/css" href="css/regi.css">
<title>회원가입</title>

</head>
<body>
<div id="container">
		<form action="register.do" name = "frm" method="post" class="big">
			<table class="small">
				<tr class="h">
					<th colspan="2" align="center" class="subject">회원가입</th>
				</tr>
				<tr class="h">
					<th colspan="2" class="upline"></th>
				</tr>
				<tr class="h">
					<td align="center" class="name">아이디</td>
					<td><input type="text" name="id" placeholder="아이디 입력" class="box">
						<input type="button" value="중복 확인" onclick="idCheck()" class="idbtn"> 
						<input type="hidden" name="reid"></td>
				</tr>
				<tr class="h">
					<td align="center" class="name">비밀번호</td>
					<td><input type="password" name="upwd" placeholder="비밀번호 입력" class="box"></td>
				</tr>
				<tr class="h">
					<td align="center" class="name" >비밀번호 확인</td>
					<td><input type="password" name="upwd_re"
						placeholder="비밀번호 재입력" onclick="return pwdTest()" class="box"></td>
				</tr>
	
				<tr class="h">
					<td align="center" class="name">이름</td>
					<td><input type="text" name="uname" class="box"></td>
				</tr>
				<tr class="h">
					<td align="center" class="name">전화번호</td>
					<td><input type="text" name="uphone" class="box"></td>
				</tr>
	
				<tr class="h">
					<td align="center" class="name" >생년월일</td>
					<td><input type="text" name="ubirth" class="box"></td>
				</tr>
	
				<tr class="h">
					<td align="center" class="name">주소</td>
					<td><input type="text" name="uaddress" class="box" ></td>
				</tr>
				<tr class="h">
					<td><input type="hidden" name="ugrade" value="1"></td>
					<td><input type="hidden" name="upoint" value="0"></td>
				</tr>
				<tr class="h">
					<th colspan="2" class="dline"></th>
				</tr>
				<tr class="h">
					<td colspan="2" align="center">
					<input type="submit" value="회원가입하기"  id="joinBtn">
					</td>
				</tr>
	      ${message }
			</table>
		</form>
	</div>
</body>
</html>