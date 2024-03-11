<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/managerMain.css">
<script type="text/javascript"></script>
</head>
<body>
<div id="wrap" align="left">
<form method="post" name="frm" enctype="multipart/form-data">
<header>
<table>
	<tr text-align="center">
		<td><a href="main.do"><img src="icon/kurly.jpeg"></a></td>
		<th>${users.uname}관리자님 환영합니다.</th>
			<td align="right" id="padding">
			<a href="logout.do">로그아웃</a> &nbsp;
			<a href="manager.do">관리자 메인으로</a>
			</td>
	</tr>

</table>
</header>

<div id="container">
<div id="item">
<p><a href="ManagerWrite.do">상품 등록</a></p>
</div>

<div id="item">
<p><a href="ManagerList.do">상품리스트</a></p>
</div>

<div id="item">
<p><a href="ManagerOrderList.do">주문 목록</a></p>
</div>

<div id="item">
<p><a href="memberList.do">회원 관리</a></p>
</div>

</div>
</form>

</div>

</body>
</html>