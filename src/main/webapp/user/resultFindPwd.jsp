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
	min-height: 400px;
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
	height: 300px;
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
	padding-top: 30px;

}
#findpwd th h1{
	font-size: 28px;
	text-align: center;
	vertical-align: middle;
	letter-spacing: -.5px;
	font-weight: 500;
	padding-bottom: 10px;
}
#findpwd th{
	font-size: 14px;
	padding: 5px;
	text-align: left;
	vertical-align: middle;
	letter-spacing: -.5px;
}

#findpwd td{
	font-size: 18px;
	padding: 5px;
	text-align: center;
	letter-spacing: -.5px;
}
#findpwd td.b {
	text-align:center;
}
.box{
	height:40px;
}
input.in{
	width:250px;
	height: 40px;
	padding:0px 6px 1px 15px;
	border:1px solid #5F0080;
	border-radius: 4px;	
}


input.checkbtn{
	width:250px;
	height: 40px;
	font-size: 18px;
	background-color: #5F0080;
	border:1px solid #5F0080;
	border-radius: 4px;
	color: #fff;
	margin-top: 15px;
}

</style>
</head>
<body>
	<div id="rpwrap">
		<form action="upwdUpdate.do" method="post" class="rp">
			<div class="pur">
				<table border="1" id="findpwd">
					<tr>
						<th><h1>비밀번호 변경</h1></th>
					</tr>
					<tr>
						<th>새 비밀번호 등록</th>
					</tr>
					<tr>
						<td>
							<div class="box">
								<input type="text" name=upwd placeholder="새 비밀번호를 입력해 주세요" class="in">		
								<input type="hidden" name="id" value="${id}">
							</div>
						</td>
				
					</tr>
					<tr>
						<th>새 비밀번호 확인</th>
					</tr>
					<tr>
						<td>
							<div class="box">
								<input type="password" name=re_upwd placeholder="새 비밀번호를 한 번 더 입력해 주세요" class="in">
							</div>
						</td>
					</tr>
					<tr>
						<td class="b"><input type="submit" value="확인" class="checkbtn"></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
</body>
</html>