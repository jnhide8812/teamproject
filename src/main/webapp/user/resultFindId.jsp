<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../main.jsp" %> 

<style>
#riwrap {
	margin: 0px auto;
	padding-top: 300px;
	width: 1050px;
}

form.ri {
	font-size: 1.2em;
	table-layout: fixed;
	display: flex;
	justify-content: center;
	align-items: center;
}
.ple{
	width: 400px;
	height: 300px;
	background-color:#F5F1FF;
	border:1px solid #F5F1FF;
	border-radius: 6px;
	text-align:center;
}
#findid{
	display:flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	padding-top: 50px;
}
#findid th{
	font-size: 20px;
	padding: 5px;
	text-align: center;
	vertical-align: middle;
	letter-spacing: -.5px;
}

#findid td{
	font-size: 18px;
	
}
input.lgy{
	width:250px;
	height: 40px;
	font-size: 18px;
	background-color: #5F0080;
	border:1px solid #5F0080;
	border-radius: 4px;
	color: #fff;
	font-weight: 500;

}
input.pw{
	width:250px;
	height: 40px;
	font-size: 18px;
	color: #5F0080;
	background-color: #ffffff;
	border:1.5px solid #5F0080;
	border-radius: 4px;
	margin-top: 35px;
	font-weight: 500;
}
.fpbtn{
	display:flex;
	flex-direction: column;
	align-items:center;
}
</style>
</head>
<body>
	<div id="riwrap">
		<form class="ri">
			<div class="ple">
				<table border="1" id="findid">
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
						<td>
							<div class="fpbtn">
								<input type="button" value="비밀번호 찾기"
								onclick="location.href='findPwd.do'" class="pw">&nbsp;&nbsp;
								<input type="button" value="로그인" onclick="location.href='login.do'" class="lgy">
							</div>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</div>
</body>
</html>