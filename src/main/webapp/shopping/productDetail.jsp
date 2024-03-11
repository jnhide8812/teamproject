<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../shopping/main.jsp" %>
<!-- 풋터 넣기 -->
<meta charset="UTF-8">
<title>상품 상세 페이지</title>
<style type="text/css">
    body {
        display: flex;
        align-items: center;
        justify-content: center;
        height: 100vh;
        margin: 0;
    }

    .product-container {
        display: flex;
        align-items: center;
    }

    .product-image {
        margin-right: 20px; /* 사진과 글 사이의 공백 조절 */ 
    }
</style>
</head>
<body>
    <div >
        <table>
            <tr>
                <td class="product-image" rowspan="4">
                    <img src="img/${productDetail.pictureurl}" alt="Product Image">
                </td>
                <td>${productDetail.pstatus}</td> 
            </tr>
            <tr>
                   <td>${productDetail.pname}</td>
            </tr>
            <tr>
                <td>${productDetail.price}원</td>
            </tr>
            <tr>
                <td colspan="2">${productDetail.pinfo}</td>
            </tr>
        </table>
    </div>
</body>
</html>
