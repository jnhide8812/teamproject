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

	
function pwdTest() {
      var p1 = document.getElementById("upwd").value;
      var p2 = document.getElementById("upwd_re").value;
      if( p1 != p2 ) {
        alert("비밀번호가 일치 하지 않습니다");
        return false;
      } else{
        alert("비밀번호가 일치합니다");
        return true;
      }

    }
    
    
    function joinCheck(){
   if(document.frm.name.value.length==0){
      alert("이름을 써 주세요");
      frm.name.focus();
      return false;
   }
   if(document.frm.id.value.length==0){
      alert("아이디를 써 주세요");
      frm.userid.focus();
      return false;
   }
   if(document.frm.id.value.length<4){
      alert("아이디는 최소 4글자 이상이어야 합니다");
      frm.id.focus();
      return false;
   }
   if(document.frm.pwd.value==""){
      alert("암호는 반드시 입력해야 합니다");
      frm.pwd.focus();
      return false;
   }
   if(document.frm.pwd.value != document.frm.upwd_re.value){
      alert("암호가 일치하지 않습니다.");
      frm.pwd.focus();
      return false;
   }
   if(document.frm.reid.value.length==0){
      alert("중복체크를 하지 않았습니다.");
      frm.id.focus();
      return false;
   }
}
