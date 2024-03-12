<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../main.jsp" %>
<!DOCTYPE html>
<html>
<head>ㄴ
<meta charset="UTF-8">
<title>마이페이지</title>
<!-- <script type="text/javascript" src="script/shop.js"></script> -->
<style>

h1{
   font-size:1.5em;
   color:#5F0080;
   font-weight: bold;
   
}

#wrap{
   margin:100px;
   padding:5px;

}

#mypage{
   width:1000px;
   font-size:1.2em;
   table-layout: fixed;
   margin:0 auto;
   
}

#mypage td, th{
   padding:5px;
   text-align: center;
   vertical-align: middle;
}

</style>
</head>
<body>
<h1>마이페이지</h1>
 <div id="wrap">
	<form action="mypage.do" method="post">
		<table id = "mypage">
			<tr>
				<th colspan="2">
					<c:choose>
						<c:when test="${loginUser.ugrade eq 1}">Basic</c:when>
						<c:when test="${loginUser.ugrade eq 2}">VIP</c:when>
					</c:choose>
				 ${loginUser.uname}님</th>
			</tr>
			<tr>
				<th rowspan="2">적립금 &nbsp; ${loginUser.upoint} &nbsp; point</th>
			
				<td><input type="button" value="개인정보 수정" onclick="location.href='userUpdate.do'"></td>
			</tr>
			<tr>
				
				<td><input type="button"value="주문내역 보기" onclick="location.href='orderList.do'"></td>
			</tr>
		</table>

	</form>
	</div>
</body>
</html>