<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../main.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상품 목록</title>
    <style>
        .product-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
        }
        .product-item {
            width: 30%; /* 각 상품이 차지하는 너비 */
            margin-bottom: 20px;
            border: 1px solid #ccc;
            padding: 10px;
            box-sizing: border-box;
            text-align: center;
        }
        .product-image {
            max-width: 100%;
            height: auto;
            margin-bottom: 10px;
        }
    </style>
   
  
</head>
<body>
    <h1>검색 결과</h1>

    <%-- 검색 결과를 반복문으로 출력 --%>
    <c:forEach items="${searchResult}" var="product">
        <div>
            <a href="productDetail.do?pcode=${product.pcode }">
            <img src="img/${product.pictureurl}" alt="Product Image" width="100">
            </a>
            <p>상품명: ${product.pname}</p>
            <p>가격: ${product.price}원</p>
        </div>
    </c:forEach>
</body>
</html>
