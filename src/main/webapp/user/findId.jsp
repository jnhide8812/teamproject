<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<link rel="stylesheet" href="./css/findId.css">
</head>
<body>
<div id="wrap">
<h1>아이디 찾기</h1>
	<form method="post" action="findId.do">
	    <div class="find">
	            <ul>
	                <li>
	                    <label for="name">이름</label>
	                    <input type="text" name="uname" placeholder="이름을 입력해 주세요">
	                    
	                </li>
	                <li class="phone">
	                    <label for="name">전화번호</label>
	                    <input type="text" name="uphone" placeholder="휴대폰 번호를 입력해 주세요">
	                </li>
	             </ul>   
	             <div class="btn_wrap">
	                 <input type="submit" value="찾기" class="fbtn">
	             </div>
        </div>
	</form>
	</div>
</body>
</html>