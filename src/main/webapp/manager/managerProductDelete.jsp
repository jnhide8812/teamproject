<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 삭제 페이지</title>
<link rel="stylesheet" type="text/css" href="css/manager.css">
<script type="text/javascript" src="script/shop.js"></script>
</head>
<body>
   <div id="wrap" align="center">
      <h1>상품 삭제 - 관리자</h1>
      <form method="post" action="ManagerProductDelete.do">
      <hr><hr><br>
         <table>
            <tr>
               <td><c:choose>
                     <c:when test="${empty product.pictureurl}">
                        <img src="img/noimg.png">
                     </c:when>
                     <c:otherwise>
                        <img src="img/${product.pictureurl}">
                     </c:otherwise>
                  </c:choose></td>
               <td>
                  <table>
                     <tr>
                        <th>카테고리</th>
                        <td><select name="catecode">
                              <option value="1" selected>육류</option>
                              <option value="2">과일</option>
                              <option value="3">채소</option>
                              <option value="4">가공식품</option>
                              <option value="5">유제품</option>
                        </select></td>
                     </tr>

                     <tr>
                        <th>상품 상태</th>
                        <td><select name="pstatus">
                              <option value="A" selected>일반품목</option>
                              <option value="B">인기품목</option>
                              <option value="C">할인품목</option>
                        </select></td>
                     </tr>

                     <tr>
                        <th style="width: 80px">상품 이름</th>
                        <td><input type="text" name="pname"></td>
                     </tr>

                     <tr>
                        <th>상품 가격</th>
                        <td><input type="text" name="price">&nbsp원</td>
                     </tr>

                     <tr>
                        <th>상품 재고</th>
                        <td><input type="text" name="pstock">&nbsp;개</td>
                     </tr>

                     <tr>
                        <th>상품 설명</th>
                        <td><textarea rows="7" cols="60" name="pinfo">
                     
                     </textarea></td>
                     </tr>

                     <tr>
                        <th>상품 사진</th>
                        <td><input type="file" name="pictureurl"><br>
                        </td>
                     </tr>
                  </table>
               </td>
            </tr>
         </table>
         <br> <input type="hidden" name="pcode" value="${product.pcode}">
             <input type="submit" value="삭제" onclick="return shopCheck()"> 
             <input type="button"value="목록" onclick="location.href='ManagerList.do'">

      </form>
   </div>
</body>
</html>