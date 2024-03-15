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
#rpwrap {
	margin: 0px auto;
	padding-top: 300px;
	width: 1050px;
}

form.rp {
	font-size: 1.2em;
	table-layout: fixed;
	display: flex;
	justify-content: center;
	align-items: center;
}
.pur{
	width: 400px;
	height: 250px;
	background-color:#F5F1FF;
	border:1px solid #F5F1FF;
	border-radius: 6px;
	text-align:center;
}
#findpwd{
	display:flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	padding-top: 50px;
}
#findpwd th{
	font-size: 20px;
	padding: 5px;
	text-align: center;
	vertical-align: middle;
	letter-spacing: -.5px;
}

#findpwd td{
	font-size: 18px;
	
}
input.lbtn{
	width:250px;
	height: 40px;
	font-size: 18px;
	background-color: #5F0080;
	border:1px solid #5F0080;
	border-radius: 4px;
	color: #fff;
	margin-top: 30px;
}

</style>
</head>
<body>
	<div id="rpwrap">
		<form class="rp">
			<div class="pur">
				<table border="1" id="findpwd">
					<tr>
						<th>고객님의 컬리 비밀번호를 찾았습니다</th>
					</tr>
					<tr>
						<th>비밀번호 확인 후 로그인해 주세요</th>
					</tr>
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>고객님의 비밀번호 : ${upwd}</td>
					</tr>
					<tr>
						<td><input type="button" value="로그인"
							onclick="location.href='login.do'" class="lbtn"></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
</body>
</html>