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
		<form action="upwdUpdate.do" method="post" class="rp">
			<div class="pur">
				<table border="1" id="findpwd">
					<tr>
						<th>새 비밀번호 등록</th>
					</tr>
					<tr><th><input type="text" name=upwd >		
						<input type="hidden" name="id" value="${id}"></th>
				
					</tr>
					<tr>
						<th>새 비밀번호 확인</th>
					</tr>
					<tr>
						<th><input type="password" name=re_upwd ></th>
					</tr>
					
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<th><input type="submit" value="확인" ></th>
					</tr>
				</table>
			</div>
		</form>
	</div>
</body>
</html>