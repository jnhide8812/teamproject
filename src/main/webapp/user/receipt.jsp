<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../main.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문서 페이지</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<style>


#wrap{
	margin:100px;
	padding:5px;
}

h1{
	font-size: 26px;
	color:#5F0080;
	font-weight: bold;
	
}
#list{
	width:600px;
	font-size:1.2em;
	table-layout: fixed;
	
}

#list td, th{
	padding:5px;
	text-align: center;
	vertical-align: middle;
	border-bottom: 1px solid #5F0080;
}

#orderbox{
	width:600px;
	background-color: rgb(250, 250, 250);
	border: 1px solid rgb(242,242,242);
	margin:10px;
	padding:30px;
	align:center;

}

#orderbox td{
	font-size:1.3em;
	line-height: 1em;
	padding:20px 20px 1px 20px;
	table-layout: fixed;
	}
.paybtn{
	width:280px;
	height: 50px;
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
<h1>주문서</h1>
<br><br>

<form method="post" action="order.do">

<table id="list">
<c:forEach var="orderList" items="${orderList }">
<tr>
<td>
<input type="hidden" name="id" value="${loginUser.id}">
<input type="hidden" name="pcode[]" value="${orderList.pcode }"></td>
<td>${orderList.pname }</td>
<td><input type="hidden" name="ordercnt[]" value="${orderList.cartcnt }">${orderList.cartcnt }개</td>
</tr>
</c:forEach>
</table>
<br><br>


<table id="orderbox">
<tr>
	<td>수령인</td>
	<td><input type="text" name="dname" size="20" value="${loginUser.uname }">
</tr>
<tr>
	<td>배송 주소</td>
	<td><input type="text" name="daddress" size="50" value="${loginUser.uaddress }"></td>
</tr>
<tr>
	<td>결제방법</td>
	<td><select name="payment">
		<option value="신용카드">신용카드</option>
		<option value="무통장입금">무통장입금</option>
	
	</select></td>
</tr>
<!--로그인 유저의 마일리지 값 넘지못하게 제한할것

<tr>
	<td>적립금 사용</td>
	<td><input type="text" name="upoint" value="${loginUser.upoint }" ></td>   
</tr> 

-->
<tr>
	<td>총 결제금액</td>
	<td>${totalprice }원 <input type ="hidden" name="totalprice" value="${totalprice }"></td>
</tr>
<tr>
	<td colspan="2" align="center"><input type="submit" value="결제하기" class="paybtn"></td>
</tr>
<tr>
	<td>&nbsp;</td><td></td>
</tr>
</table>
</form>



</div>

</body>
</html>