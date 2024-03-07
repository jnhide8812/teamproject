<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록 페이지</title>
<link rel="stylesheet" type="text/css" href="css/shop.css">
<script type="text/javascript" src="script/shop.js"></script>
</head>
<body>
<div id="wrap" align="center">
<h1>상품 등록 페이지 - 관리자 페이지</h1>
<form action="post" name="frm" enctype="multipart/form-data">

	<input type="hidden" name="pcode" value="${product.pcode}" >
	<input type="hidden" name="nonmakeImg" value="${product.pictureurl}" >
	<table>
		<tr>
			<td>
				<c:choose>
					<c:when test="${empty product.pictureurl}">
						<img src="img/noimg.png">
					</c:when>
					<c:otherwise>
						<img src="img/${product.pictureurl}">
					</c:otherwise>
				</c:choose>
			</td>
			<td>
				<table>
					<tr>
					<td align="center">카테고리</td>
						<td>
							<select name="category">
								<option value="1" selected>육류</option>
								<option value="2">채소</option>
								<option value="3">가공식품</option>
								<option value="4">유제품</option>
							</select>
						</td>
					</tr>
					
					<tr>
						<th>상품 상태</th>
						<td>
							<select name="pstatus">
								<option value="A" selected>인기품목</option>
								<option value="B">할인품목</option>
							</select>
						</td>
					</tr>
				
					<tr>
						<th style="width:80px">상품 이름</th>
						<td>
							<input type="text" name="pname" value="${product.pname}" size="80">
						</td>
					</tr>
					
					<tr>
						<th>상품 가격</th>
						<td>
							<input type="text" name="price" value="${product.price}">원
						</td>
					</tr>
				
					<tr>
						<th>상품 재고</th>
						<td>
							<input type="text" name="pstock" value="${product.pstock}">개
						</td>
					</tr>
					
					<tr>
						<th>상품 설명</th>
						<td>
							<textarea rows="7" cols="60" name="pinfo">
								${product.pinfo}
							</textarea>
						</td>
					</tr>
					
					<tr>
						<th>상품 사진</th>
						<td>
							<input type="file" name="pictureUrl"><br>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<br>
	<input type="submit" value="등록" onclick="return shopCheck()">
	<input type="reset" value="다시작성">
	<input type="button" value="목록" onclick="location.href='ManagerList.do'">
	
</form>
</div>
</body>
</html>