<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../main.jsp" %>
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">
<title>상품 상세 페이지</title>
<!-- <style type="text/css">
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
</style> -->
<style>
h1{
   font-size:1.5em;
   color:#5F0080;
   font-weight: bold;
   
}

#wrap{
   margin:5px;
   padding:5px;

}

#product_detail{
   width:1000px;
   font-size:1.2em;
   table-layout: fixed;
   margin:0 auto;
   
}

#product_detail td, th{
   padding:5px;
   text-align: center;
   vertical-align: middle;
}

</style>
</head>
<body>

    <div id="wrap">
        <table id="product_detail">
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
