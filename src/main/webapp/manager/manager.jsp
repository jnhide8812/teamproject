<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/managerMain.css">
<script type="text/javascript"></script>
</head>
<body>
<header>
	<table>
		<tr>
			<td><a href="Main.do"><img src="kurly.jpeg"></a></td>
			<td>${users.uname}관리자님환영합니다.</td>
		</tr>
		
		<tr>
			<td colspan="7" style="border:white; text-align:right">
			<a href="manager.jsp">관리자 메인</a>&nbsp;&nbsp;&nbsp;
			<a href="logout.do">로그아웃</a>
			</td>
		</tr>
	</table>
</header>	
	<div id="wrap">
		<form method="post" name="frm" enctype="multipart/form-data">
			<table>
				<ul>
					<li><a href="ManagerWrite.do">상품 등록</a></li>
					<br>
				</ul>
					
				<ul>
					<li><a href="ManagerList.do">상품리스트</a></li>
					<br>
					<br>
				</ul>

				<ul>
					<li><a href="ManagerOrderList.do">주문 목록</a></li>
					<br>
					<br>
				</ul>

				<ul>
					<li><a href="MemberList.do">회원 관리</a></li>
				</ul>

			</table>
		</form>

	</div>

</body>
</html>