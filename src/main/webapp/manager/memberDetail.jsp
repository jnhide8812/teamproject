<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" href="css/manager.css">
</head>
<body>
<header>
<table>
	<tr>
		<td><a href="main.do"><img src="icon/kurly.jpeg"></a></td>
		<th>${users.uname}관리자님 환영합니다.</th>
			<td align="right" id="padding">
			<a href="logout.do">로그아웃</a> &nbsp;
			<a href="manager.do">관리자 메인으로</a>
			</td>
	</tr> 
</table>
</header>
<div id="wrap" align="center">
<form method="post" name="frm" action="MemberDetail.do">

	<table class="list">
		<tr>
			<td>
				<table>
					<tr>
					<th>아이디</th>
						<td><input type="text" name="id" value="${orderdetail.id}"></td>
					</tr>
					
					<tr>
						<th>회원 등급</th>
						<td>
							<select name="ugrade">
								<option value="BASIC" selected>BASIC</option>
								<option value="VIP">VIP</option>
							</select>
						</td>
					</tr>
				
					<tr>
						<th>등록 주소</th>
						<td>
							<input type="text" name="daddress" value="${orderdetail.daddress}">
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<br>
	<input type="submit" value="확인" onclick="location.href='MemberList.do'">&nbsp;&nbsp;
	<input type="reset" value="다시작성">

	 
</form>
</div>
</body>
</html>