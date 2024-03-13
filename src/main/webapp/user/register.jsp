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
<div id="join_wrap">
	<form action="register.do" name = "frm" method="post" class="big">
	<h1>회원가입</h1>
		<div class="upline"></div>
		<nav>
			<ul>
				<li>
					<label for="id">아이디</label>
					<input type="text" name="id" placeholder="아이디 입력" class="box">
					<input type="button" value="중복 확인" onclick="idCheck()" class="idbtn"> 
					<input type="hidden" name="reid">
				</li>
				<li>
					<label for="pwd">비밀번호</label>
					<input type="password" name="upwd" placeholder="비밀번호 입력" class="box">
				</li>
				<li>
					<label for="upwd_re">비밀번호 확인</label>
					<input type="password" name="upwd_re"
						placeholder="비밀번호 재입력"  class="box">
				</li>
				<li>
					<label for="name">이름</label>
					<input type="text" name="uname" class="box">
				</li>
				<li>
					<label for="phone">전화번호</label>
					<input type="text" name="uphone" class="box">
				</li>
				<li>
					<label for="phone">생년월일</label>
					<input type="text" name="ubirth" class="box">
				</li>
				<li>
					<label for="address">주소</label>
					<input type="text" name="uaddress" class="box" >
				</li>
				<li>
					<input type="hidden" name="ugrade" value="1">
					<input type="hidden" name="upoint" value="0">
				</li>
				<li>
					<div class="downline"></div>
				</li>
				<li class="btn_wrap">
					<input type="submit" value="회원가입하기" onclick="return pwdTest()" class="joinbtn">
				</li>
				
			</ul>
		</nav>
			${message }
		</form>
	</div>
</body>
</html>