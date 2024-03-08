<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록 페이지</title>
<link rel="stylesheet" type="text/css" href="css/manager.css">
<script type="text/javascript" src="script/shop.js"></script>
</head>
<body>
<div id="wrap" align="center">
<h1>상품 수정 - 관리자</h1>
<form action="post" name="frm" enctype="multipart/form-data">

   <input type="hidden" name="pcode" value="${product.pcode}" >
   <input type="hidden" name="nonmakeImg" value="${product.pictureurl}" >
   <hr><hr><br>
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
            	  <th>카테고리</th>
                  <td>
                     <select name="category" value="${product.catecode}">
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
                     <select name="pstatus" value="${product.pstatus}">
                        <option value="A" selected>인기품목</option>
                        <option value="B">할인품목</option>
                     </select>
                  </td>
               </tr>
            
               <tr>
                  <th style="width:80px">상품 이름</th>
                  <td>
                     <input type="text" name="pname" value="${product.pname}" readonly>  
                  </td>
               </tr>
               
               <tr>
                  <th>상품 가격</th>
                  <td>
                     <input type="text" name="price" value="${product.price}">&nbsp원
                  </td>
               </tr>
            
               <tr>
                  <th>상품 재고</th>
                  <td>
                     <input type="text" name="pstock" value="${product.pstock}">&nbsp개
                  </td>
               </tr>
               
               <tr>
                  <th>상품 설명</th>
                  <td>
                     <textarea rows="7" cols="60" name="pinfo" readonly>
                     	${product.pinfo}
                     </textarea>
                  </td> 
               </tr>
               
               <tr>
                  <th>상품 사진</th>
                  <td>
                     <input type="file" name="pictureurl" value="${product.pictureurl}"><br>
                  </td>
               </tr>
            </table> 
         </td>
      </tr>
   </table>
   <br>
<<<<<<< HEAD
   	<input type="hidden" name="pcode" value="${product.pcode}">
	<input type="submit" value="수정완료" onclick="return shopCheck()">
	<input type="button" value="목록" onclick="location.href='ManagerList.do'">
	
=======
   	<input type="hidden" name="code" value="${product.code}">
	<input type="submit" value="상품 수정" onclick="return productCheck()">
	<input type="button" value="목록" onclick="location.href='ManagerList.do'">
>>>>>>> branch 'main' of https://github.com/jnhide8812/teamproject.git

</form>
</div>
</body>
</html>