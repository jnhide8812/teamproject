<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<td><a href="main.do"><img id="logo" src="icon/kurly.jpeg"></a></td>
		<th>${users.uname}관리자님 환영합니다.</th>
			<td align="right" id="padding">
			<a href="logout.do">로그아웃</a> &nbsp;
			<a href="manager.do">관리자 메인으로</a>
			</td>
	</tr>
</table>
</header>
<div id="wrap" align="center">
	<table id="list">
		<tr id="textcenter" style="background-color: #5f0080; color: white;">
			<td>주문 번호</td>
			<td>아이디</td>
			<td>주 소</td>
			<td>배송 상태</td>			
		</tr>
		
		<c:forEach var="managerOrderList" items="${managerOrderList}">
		<tr class="recode">
			<td align="center"><a href="ManagerOrderDetail.do?ordernumber=${managerOrderList.ordernumber}">${managerOrderList.ordernumber}</a></td>
			<td>${managerOrderList.id}</td>
			<td>${managerOrderList.daddress}</td>
			<td>${managerOrderList.orderstatus}</td>
		</tr>
		</c:forEach>
		
	</table>
</div>
</body>
</html>