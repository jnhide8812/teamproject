<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>

<style>
#wrap {
	margin: 100px;
	padding: 5px;
}

#findPwd {
	width: 1000px;
	font-size: 1.2em;
	table-layout: fixed;
	margin: 0 auto;
}

#findPwd td, th {
	padding: 5px;
	text-align: center;
	vertical-align: middle;
}
</style>
</head>
<body>
	<div id="wrap">
		<form method="post" action="findPwd.do">
			<table border="1" id="findPwd">
				<tr>
					<td rowspan="3">비밀번호 찾기</td>
					<td>아이디 <input type="text" name="id"></td>
				</tr>
				<tr>
					<td>이름 <input type="text" name="uname"></td>
				</tr>
				<tr>
					<td>전화번호 <input type="text" name="uphone"></td>
				</tr>
				<tr>
					<td colspan="3"><input type="submit" value="찾기"></td>
				</tr>
			</table>



		</form>
	</div>
</body>
</html>