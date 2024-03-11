<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 상세 페이지 - 관리자</title>
<link rel="stylesheet" type="text/css" href="css/manager.css">
<script type="text/javascript" src="script/shop.js"></script>
</head>
<body>
	<form name="frm" method="post" action="ManagerOrderDetail.do">
		<div id="wrap" align="center">
			<h1>주문 상세 페이지 - 관리자</h1>
			<input type="hidden" name="orderdetailnumber"
				value="${orderdetail.orderdetailnumber}">
			<hr>
			<hr>

			<table>
				<tr>
					<th style="width: 80px">수령인 이름</th>
					<td><input type="text" name="dname"
						value="${orderdetail.dname}" readonly></td>
				</tr>

				<tr>
					<th>배송지 주소</th>
					<td><input type="text" name="daddress"></td>
				</tr>

				<tr>
					<th>상품 코드</th>
					<td><input type="text" name="pcode"
						value="${orderdetail.pcode}" readonly></td>
				</tr>

				<tr>
					<th>상품 이름</th>
					<td><input type="text" name="pname"
						value="${orderdetail.pname}" readonly></td>
				</tr>

				<tr>
					<th>Total 금액</th>
					<td><input type="text" name="totalprice">&nbsp;원</td>
				</tr>

				<tr>
					<th>주문 상태 변경</th>
					<td><select name="oderstatus">
							<option value="1" selected>결제완료</option>
							<option value="2">배송중</option>
							<option value="3">배송완료</option>
					</select></td>
				</tr>

			</table>
			
			<input type="submit" value="확인" onclick="location href='ManagerOrderDetail.do'">
		</div>
	</form>
</body>
</html>