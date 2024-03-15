<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../main.jsp" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="script/shop.js"></script>
<title>개인정보 수정 페이지</title>
<style>


#wrap{
   width: 1050px;
   margin: 0px auto;
   padding-top: 250px;
   height: 100%;
 
}
form.fixx {
	display:flex;
	justify-content: center;
	align-items:center;
}
table.list h1 {
	color:#5F0080;
	font-size: 38px;
	font-weight: 650;
	padding-bottom: 20px;
}
td.sub{
	height: 100px;
}
.list{
	width: 700px;
	height: 800px;
	font-size:1.2em;
	table-layout: fixed;
	align:center;
	
}
.list th{
	text-align: center;
	font-size: 28px;
	font-weight: 500;
	width: 200px;
	height:65px;
	padding: 20px 0px;
}
.list td input.up{
	display:flex;
	justify-content: center;
	align-items:center;
	width: 300px;
	height: 40px;
	font-size: 22px;
	text-align: right;
	border:1px solid #333;
	padding: 2px 4px;
	border-radius: 3px;
}
.but {
	display:flex;
	justify-content: space-between;
	align-items:center;
	flex-direction: row;
	padding-top: 25px;
	width:550px;
	padding-left: 25px;
		
}
input.done{
	font-size: 20px;
	color: #FFFFFF;
	background-color: #5F0080;
	border:1px solid #5F0080;
	width:250px;
	height: 50px;
	border-radius: 5px;
	font-weight: 600px;
}
input.np {
	font-size: 20px;
	font-weight: 600px;
	color: #5F0080;
	border:1px solid #5F0080;
	width:250px;
	height: 50px;
	border-radius: 5px;
}

td.line{
	width: 700px;
	height: 2px;
	background-color: #5F0080;
	margin-top: 20px;
}
</style>
</head>
<body>
<div id = "wrap">
	<form action="userUpdate.do" method="post" class="fixx">
		<table class="list">
			<tr>
				<td colspan="2" align="center" class="sub"><h1>개인정보수정</h1></td>
			</tr>
			<tr>
				<th align="center">아이디</th>
				<td><input type="text" name="id" class="up" value="${loginUser.id }"
					readonly ></td>
			</tr>
			<tr>
				<th align="center">비밀번호</th>
				<td><input type="password" name="upwd"
					class="up" value="${loginUser.upwd }" readonly></td>
			</tr>

			<tr>
				<th align="center">이름</th>
				<td><input type="text" name="uname" class="up" value="${loginUser.uname }"
					readonly></td>
			</tr>
			<tr>
				<th align="center">전화번호</th>
				<td><input type="text" name="uphone" class="up" 
					value="${loginUser.uphone} "></td>
			</tr>

			<tr>
				<th align="center">생년월일</th>
				<td><input type="text" name="ubirth" class="up" 
					value="${loginUser.ubirth}" readonly></td>
			</tr>

			<tr class="ad">
				<th align="center">주소</th>
				<td><input type="text" name="uaddress" class="up"
					value="${loginUser.uaddress}"></td>
			</tr>
			<tr>
				<td colspan="2" class="line">
				<input type="hidden" name="ugrade" class="up"
					value="${loginUser.ugrade}">
					<input type="hidden" name="upoint" class="up"
					value="${loginUser.upoint}">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center" >
					<div class="but">
						<input type="submit" value="수정" class="done">
						<input type="button" value="마이페이지로" onClick='location.href="mypage.do"'class="np">
					</div>
				</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>