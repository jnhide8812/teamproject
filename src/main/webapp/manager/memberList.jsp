<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리 리스트 - 관리자 페이지</title>
<link rel="stylesheet" type="text/css" href="css/manager.css">
</head>
<body>
<form method="post" action="MemberList.do">
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
		
		<tr id="textcenter">
			<td>회원 아이디</td>
			<td>회원 등급</td>
			<td>등록 주소</td>		
			<td>전화 번호</td>	
		</tr>
		
		<c:forEach var="memberList" items="${memberList}">
		<tr class="member">
			<td><a href="MemberDetail.do?id=${memberList.id}">${memberList.id}</a></td>
			<td>${memberList.ugrade}</td>
			<td>${memberList.uaddress}</td>
			<td>${memberList.uphone}</td>
		</tr>
		</c:forEach>
	</table>
</div>
</form>
</body>
</html>