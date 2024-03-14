<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../main.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세 페이지</title>
<link rel="stylesheet" href="css/prodetail.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script>
//ajax 참고
$(document).ready(function(){
    // 수량 변경 시 이벤트 처리
    $("input[name='cartcnt']").on('input', function(){
        var cnt = $(this).val();
        var price = ${productDetail.price};
        var totalPrice = price * cnt;
        $(this).closest('.order').find('.tt_price').text('총 상품 금액 ' + totalPrice + '원');
    });
});
$(document).ready(function(){
    // 수량 변경 시 이벤트 처리
    $("input[name='cartcnt']").on('input', function(){
        calculateTotalPrice();
    });
    
    // 페이지 로딩 시 초기 상품 금액 계산 및 tt_price에 표시
    calculateTotalPrice();
});
function calculateTotalPrice() {
    var cnt = $("input[name='cartcnt']").val();
    var price = ${productDetail.price};
    var totalPrice = price * cnt;
    $('.tt_price').text('총 상품 금액 ' + totalPrice + '원');
}
</script>
</head>
<body>

    <div id="detail_wrap">
       <div class="content_pro">
            <section class="left">
                <div class="product_img">
                    <img src="img/${productDetail.pictureurl}" alt="Product Image">
                </div>
            </section>
            <section class="right">
                <div class="info">
                    <ul>
                        <li>
                            <span>${productDetail.pstatus}</span>
                        </li>
                        <li>
                            <h1>${productDetail.pname}</h1>
                        </li>
                        <li>
                            <h2>${productDetail.price}원</h2>
                        </li>
                        <li>
                            <p>${productDetail.pinfo}</p>
                        </li>
                    </ul>
                </div>
                <div class="order">
                	<form action="cartInsert.do"> 
                    <ul>
                        <li>
                            <div class="cnt">
                                <input type="text" name="cartcnt" value="${empty cartcnt ? '1' : cartcnt}"  >
                                <input type ="hidden" name="pcode" value="${productDetail.pcode }">
                                 <input type="hidden" name="cartcnt" value="${cartcnt }" >
                                
                            </div>
                        </li>
                        <li>
                            <div class="tt_price">
                                 총 상품 금액 ${productDetail.price * cartcnt}원
                            </div>
                        </li>
                        <li>
                            <div class="cart_btn"><button type="submit" value="장바구니 담기" >장바구니담기</button>
                              
                            </div>
                        </li>
                    </ul></form>
                </div>
            </section>
       </div>
    </div>
</body>
</body>
</html>
