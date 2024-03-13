function shopCheck(){
	if(document.frm.pname.value.length == 0){
		alert("상품명을 기입해 주세요");
		frm.pname.focus();
		return false;
	}
	
	if(document.frm.price.value.length == 0){
		alert("가격을 기입해 주세요");
		frm.price.focus();
		return false;
	}
	
	if(isNaN(document.frm.price.value)){
		alert("가격은 숫자로만 입력해 주세요");
		frm.price.focus();
		return false;
	}
	
	if(document.frm.pstock.value.length == 0){
		alert("재고수량을 기입해 주세요");
		frm.pstock.focus();
		return false;
	}
	
	if(isNaN(document.frm.pstock.value)){
		alert("재고수량은 숫자로만 입력해 주세요");
		frm.pstock.focus();
		return false;
	}
	
	if(document.frm.pinfo.value.length == 0){
		alert("설명란 을 작성해 주세요");
		frm.pinfo.focus();
		return false;
	}
	return true;
	
}
	
//아이디 중복 체크 함수
function idCheck(){
   if(document.frm.id.value==""){
      alert("아이디를 입력해주세요");
      document.frm.id.focus();
      return;
   }
   
   var url="idCheck.do?id=" + document.frm.id.value;
   window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
   
}

function idok(){
   opener.frm.id.value=document.frm.id.value;
   opener.frm.reid.value=document.frm.id.value;
   self.close();
   
}

	//회원가입 시 안내창 
  function pwdTest(){
   if(document.frm.uname.value.length==0){
      alert("이름을 써 주세요");
      frm.uname.focus();
      return false;
   }
   if(document.frm.id.value.length==0){
      alert("아이디를 써 주세요");
      frm.id.focus();
      return false;
   }
   
   if(document.frm.upwd.value==""){
      alert("암호는 반드시 입력해야 합니다");
      frm.upwd.focus();
      return false;
   }
   if(document.frm.upwd.value != document.frm.upwd_re.value){
      alert("암호가 일치하지 않습니다.");
      frm.upwd.focus();
      return false;
   }
   if(document.frm.reid.value.length==0){
      alert("중복체크를 하지 않았습니다.");
      frm.id.focus();
      return false;
   }
}
