<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main.jsp" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:forEach var="product" items="${product }" end="12">

		<ul class="shop2_list">
			<li><a href="productDetail.do">
					<div class="img_wrap">
						<img src="img/${product.pictureurl}">
					</div> <a href="cartInsert.do?pcode=${product.pcode }&cartcnt=1"
					class="cart_btn"> <img src="icon/sh_cart" class="s_cart">
						담기
				</a>
					<h4 class="p_tit">${product.pname}</h4>
					<p class="price">
						<span class="discount">50%</span> ${product.price}
					</p>
			</a></li> ${product.pictureurl}

			<img src="img/${product.pictureurl}">
	</c:forEach>


</body>
</html>