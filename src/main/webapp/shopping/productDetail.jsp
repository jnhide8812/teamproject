<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../main.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세 페이지</title>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script>
//ajax 참고
$(document).ready(function(){
    // 수량 변경 시 이벤트 처리
    $("input[name='cartcnt']").on('input', function(){
        var cnt = $(this).val();
        var price = ${productDetail.price};
        var totalPrice = price * cnt;
        $(this).closest('tr').find('.total-price').text('총 상품 금액 ' + totalPrice + '원');
    });
});
</script>
</head>
<body>
    <div id="wrap">
        <table border ="1" id="product_detail">
        	<tr>
        	<td><input type="hidden" name="pcode" value="${ pcode}">
        	</td>
        	</tr>
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
            <tr>
            	<td><input type="text" name="cartcnt" value="${cartcnt }" ></td>
            </tr>
            <tr>	
            <td class="total-price">총 상품 금액 ${productDetail.price * cartcnt}원</td>
            </tr>
            <tr>
            	<td><a href ="cartInsert.do?pcode=${pcode}&cartcnt=${cartcnt }">장바구니 담기</a></td>
            </tr>
        </table>
    </div>
</body>
</html>
