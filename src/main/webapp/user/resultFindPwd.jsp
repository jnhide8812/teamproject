<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../main.jsp"%>
<link rel="stylesheet" href="../css/style.css">

<style>
#rpwrap {
	margin: 0px auto;
	padding-top: 300px;
	width: 1050px;
	min-height: 400px;
}

form.rp {
	font-size: 1.2em;
	table-layout: fixed;
	display: flex;
	justify-content: center;
	align-items: center;
}
.pur{
	width: 400px;
	height: 350px;
	background-color:#F5F1FF;
	border:1px solid #F5F1FF;
	border-radius: 6px;
	text-align:center;
}
.findpwd{
	display:flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	padding-top: 30px;
	padding-bottom: 10px;

}
.findpwd h1{
	font-size: 28px;
	text-align: center;
	vertical-align: middle;
	letter-spacing: -.5px;
	font-weight: 500;
	padding-bottom: 25px;
}
.findpwd label{
	font-size: 14px;
	padding: 5px 0;
	text-align: left;
	letter-spacing: -.5px;
}

#rpwrap li{
	font-size: 18px;
	text-align: left;
	letter-spacing: -.5px;
	font-weight: 400;
	padding-bottom:30px;
}
#rpwrap .b {
	text-align:center;
	padding-top:5px;
}
.box{
	height:40px;
	padding-top: 5px;
}
input.in{
	width:300px;
	height: 45px;
	padding:0px 6px 1px 15px;
	border:1px solid #5F0080;
	border-radius: 4px;	
	font-weight: 500;
}


input.checkbtn{
	width:300px;
	height: 50px;
	font-size: 18px;
	background-color: #5F0080;
	border:1px solid #5F0080;
	border-radius: 4px;
	color: #fff;
	margin-top: 15px;
}

</style>
</head>
<body>
	<div id="rpwrap">
        <form action="upwdUpdate.do" method="post" class="rp">
            <div class="pur">
                <div class="findpwd">
                    <h1>비밀번호 변경</h1>
                    <ul>
                        <li>
                            <label>
                                새 비밀번호 등록
                            </label>
                            <div class="box">
                                <input type="text" name=upwd placeholder="새 비밀번호를 입력해 주세요" class="in">		
								<input type="hidden" name="id" value="${id}">
                            </div>
                        </li>
                        <li>
                            <label>
                                새 비밀번호 확인
                            </label>
                            <div class="box">
                                <input type="password" name=re_upwd placeholder="새 비밀번호를 한 번 더 입력해 주세요" class="in">
                            </div>
                        </li>
                        <li>
                            <div class="b">
                                <input type="submit" value="확인" class="checkbtn">
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </form>
    </div>
</body>
</html>