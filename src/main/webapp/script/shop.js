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