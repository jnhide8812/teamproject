<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<%-- 헤더 넣기 --%>
<!-- 풋터 넣기 -->
<meta charset="UTF-8">
<title>상품 상세 페이지</title>
<link rel = "stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<!--사진 측 정렬, 오른쪽에 글씨  -->
<table align = "left">
	<img src = "pictureurl" >
	<table align = "right">
		<td>${product.pname }</td> 
		<td>${product.price }</td>
		<td>${product.pinfo }</td>
		<td></td>
	
	</table>


</table>


</div>




</body>
</html>