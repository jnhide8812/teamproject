<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main.jsp" %>
<%@ include file="../footer.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>

<style>
*{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}
#fpwrap{
    width:1050px;
    margin:auto;
    background-color: white;
    padding-bottom: 50px;
   	max-height: 500px;
   	
}
#fpwrap h2 {
    padding-bottom: 30px;
    font-weight: 500;
    font-size: 28px;
    text-align: center;
}
#fpwrap form {
    width: 350px;
    position: relative;
    padding: 0px 10px 6px;
    border-top: 2px solid #5F0080;
	margin:0px auto;
}
#fpwrap .find {
    padding: 15px 20px;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
}

#fpwrap li{
	display: flex;
    flex-direction: column;
    padding-bottom: 12px;
    list-style: none;
}
#fpwrap ul{
	display: flex;
    flex-direction: column;
	width:350px;
	justify-content:center;
	align-items: center;
}
#fpwrap label{
    display:inline-block;
    padding: 8px 0px 8px ;
    font-size: 15px;
    font-weight:650;
    line-height: 19px;
    color: #333;
}
#fpwrap input{
    width: 350px;
    height: 46px;
    padding: 0px 11px 1px 15px;
    border-radius: 4px;
    border: 1px solid rgb(221, 221, 221);
    font-weight: 400;
    font-size: 16px;
    line-height: 1.5;
    color: #333;
    outline: none;
    box-sizing: border-box;
}
#fpwrap .btn_wrap{
    margin-top: 18px;
}
#fpwrap input.fbtn{
    display: block;
    padding: 0px 10px;
    text-align: center;
    overflow: hidden;
    width: 350px;
    height: 52px;
    border-radius: 4px;
    color: white;
    background-color: #5F0080;
    border: 0px none;
    font-size: 16px;
    font-weight: 600;
}

</style>
</head>
<body>
<div id="fpwrap">
	<h2>비밀번호 찾기</h2>
	<form method="post" action="findPwd.do">
		<div class="find">
	            <ul>
	                <li>
	                    <label for="name">아이디</label>
	                    <input type="text" name="id" placeholder="아이디를 입력해 주세요">
	                    
	                </li>
	                <li>
	                    <label for="name">이름</label>
	                    <input type="text" name="uname" placeholder="이름을 입력해 주세요">
	                    
	                </li>
	                <li class="phone">
	                    <label for="name">휴대폰 번호</label>
	                    <input type="text" name="uphone" placeholder="휴대폰 번호를 입력해 주세요">
	                </li>
	             </ul>   
	             <div class="btn_wrap">
	                 <input type="submit" value="비밀번호 변경" class="fbtn">
	             </div>
        </div>
	</form>
	</div>
</body>
</html>