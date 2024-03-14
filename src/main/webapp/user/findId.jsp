<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<style>
#wrap{
   margin:100px;
   padding:5px;

}

#findId{
   width:1000px;
   font-size:1.2em;
   table-layout: fixed;
   margin:0 auto;
   
}

#findId td, th{
   padding:5px;
   text-align: center;
   vertical-align: middle;
}
</style>
</head>
<body>
<div id="wrap">
	<form method="post" action="findId.do">
		<table id ="findId">
			<tr ><td  rowspan="2">아이디 찾기</td>
			<td> 성함 <input type ="text" name="uname" ></td></tr>
			<tr><td> 전화번호 <input type ="text" name="uphone" ></td></tr>
		 	<tr><input type="submit" value="찾기"></tr>
		
		
		
		</table>
	
	
	
	</form>
	</div>
</body>
</html>