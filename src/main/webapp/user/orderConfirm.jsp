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
	width:1050px;
	padding-top: 130px;
	margin:0px auto;

}
.back {
	width: 350px;
	height: 250px;
	background-color: #F5F0FA;
	border-radius: 5px;
	border: 1px solid #F5F0FA;
}
.tit{
	padding-top: 60px;
}
h1{
	font-size:1.5em;
	color:#5F0080;
	font-weight: bold;
	text-align:center;
	
}

#list{
	width:300px;
	font-size:1.2em;
	table-layout: fixed;
	text-align: center;
}

#list td{
	
	line-height: 1em;
	padding:20px 20px 1px 20px;
	table-layout: fixed;
	}
.listbtn{
	width: 315px;
	height: 55px;
	color: #FFFFFF;
	background-color: #5F0080;
	border:1px solid #5F0080;
	font-size: 16px;
	text-align:center;
	border-radius: 5px;
}

</style>

</head>
<body>
<div id="wrap" align="center">
<div class="back">
	<div class="tit">
		<h1>주문 완료</h1>
		<table id="list">
			<tr>
				<td align="center">주문번호 : ${ordernumber} || 결제금액 : ${ordertable.totalprice } </td>
			</tr>
			<tr>
				<td> </td>
			</tr>
			<tr>
				<td align="center"><a href="orderList.do" class="listbtn">주문내역보기</a></td>
			</tr>
		</table>
	</div>
</div>
</div>

</body>
</html>