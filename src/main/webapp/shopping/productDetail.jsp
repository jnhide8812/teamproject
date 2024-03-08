<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%-- <%@ include file = "header.jsp" %> --%>
<!-- 풋터 넣기 -->
<meta charset="UTF-8">
<title>상품 상세 페이지</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <table>
        <c:forEach var="product" items="${productList }">
            <tr>
                <td rowspan="2">
                    <img src="img/${product.pictureurl}" >
                </td>
                <td>${product.pname }</td>
            </tr>
            <tr>
                <td>${product.price }</td>
            </tr>
            <tr>
                <td colspan="2">${product.pinfo }</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>