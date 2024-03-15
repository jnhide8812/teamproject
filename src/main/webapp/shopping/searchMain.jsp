<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../main.jsp" %> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상품 목록</title>
    <style>
    #result {
    	width: 1050px;
    	margin:0px auto;
    	padding-top: 200px;
    }
    .rs{
	    display:flex;
	    jusitfy-content: center;
	    align-items:center;
	    flex-direction: column;
    }
    .rs h1{
    	text-align:center;
    	font-size: 40px;
    	font-weight: 800;
    	color: #5F0080;
    	padding-bottom: 40px;
    }
    
    .if{
    	padding-bottom: 15px;
    }
    .if ul{
    	display:flex;
	    jusitfy-content: center;
	    align-items:center;
	    flex-direction: row;
    }
    li.im {
    	padding-right:20px;
    }
    .iname p{
    	font-size: 30px;
    	font-weight: 500px;
    	padding-bottom: 5px;
    }
    img.pimage{
    	width:70px;
    	height:70px;
    	object-fit: cover;
    }
    </style>
   
  
</head>
<body>
<div id="result">
	<div class="rs">
	    <h1>검색 결과</h1>
		<div class="rc">
		    <%-- 검색 결과를 반복문으로 출력 --%>
		 	<c:forEach items="${searchResult}" var="product">
		        <div class="if">
		         	<ul>
		         		<li class="im">
		         			<a href="productDetail.do?pcode=${product.pcode }">
		            			<img src="img/${product.pictureurl}" class="pimage" width="100">
		            		</a>
		         		</li>
		         		<li>
		         			<div class="iname">
		            			<p>상품명: ${product.pname}</p>
		            			<p>가격: ${product.price}원</p>
							</div>  
		         		</li>
		         	</ul>    
		        </div>
		    </c:forEach>
	    </div>
	</div>
</div>
</body>
</html>
