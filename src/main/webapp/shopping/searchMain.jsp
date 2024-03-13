<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>검색 결과</title>
</head>
<body>
    <h1>검색 결과</h1>
    <p>검색어: ${searchText}</p>

    <%-- 검색 결과를 반복문으로 출력 --%>
    <c:forEach items="${searchResult}" var="product">
        <div>
            <img src="img/${product.pictureurl}" alt="Product Image" width="100">
            <p>상품명: ${product.pname}</p>
            <p>가격: ${product.price}원</p>
        </div>
    </c:forEach>
</body>
</html>
