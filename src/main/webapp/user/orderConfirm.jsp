<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 완료 페이지</title>
<style>


#wrap{
	margin:100px;
	padding:5px;

}
h1{
	font-size:1.5em;
	color:#5F0080;
	font-weight: bold;
	
}

#list{
	width:600px;
	font-size:1.2em;
	table-layout: fixed;
	
}

</style>

</head>
<body>
<div id="wrap" align="center">
<h1>주문 완료</h1>
<table id="list">
	<tr>
		<td>주문번호 : ${ordernumber} || 결제금액 : ${ordertable.totalprice } </td>
	</tr>
	<tr>
		<td> </td><td></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><a href="orderList.do">주문내역보기</a></td>
	</tr>

</table>

</div>

</body>
</html>