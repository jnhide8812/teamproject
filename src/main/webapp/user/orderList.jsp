<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>특정 유저의 오더리스트 보기</title>
<style>


#owrap{
	 width: 1050px;
   margin: 0px auto;
   padding-top: 200px;
}


#owrap h1{
	font-size:1.5em;
	color:#5F0080;
	font-weight: bold;
	
}

#owrap h3{
	color:#5F0080;
	font-weight: bold;
	text-align:center;
	border-bottom: 1px solid #5F0080;
	font-size: 26px;
	padding-bottom: 10px;
	width: 450px;
	
}
#list{
	width:500px;
	font-size:1.2em;
	table-layout: fixed;
	display:flex;
	justify-content:center;
	align-items: center;
	
}
#list td{
	line-height: 1em;
	padding:10px 10px 1px 10px;
	table-layout: fixed;
	width:600px;
	text-align:center;
}



</style>
</head>
<body>
	<div id="owrap" align="center">


		<table id="list">
			<c:forEach var="orderList" items="${orderList }">
				<tr>
					<td colspan="2"><a href="orderDetail.do?ordernumber=${orderList.ordernumber }"><h3>주문 내역 상세 보기</h3></a></td>
					
				</tr>
				<tr>
					<td width="30%">주문 번호</td>
					<td>${orderList.ordernumber}</td>
				</tr>

				<tr>
					<td width="50%">결제 금액</td>
					<td>${orderList.totalprice}</td>
				</tr>
				<tr>
					<td>결제 방법</td>
					<td>${orderList.payment}</td>
				</tr>

				<tr>
					<td>주문 상태</td>
					<td>${orderList.orderstatus }</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td></td>
				</tr>

			</c:forEach>

		</table>

	</div>
</body>
</html>