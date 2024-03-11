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

function idCheck() {
    var id = document.frm.id.value;

    if (id === "") {
        alert("아이디를 입력해주세요");
        document.frm.id.focus();
        return;
    }

    $.ajax({
        url: 'idCheck.do', // 실제 서버의 주소로 변경
        type: 'GET',
        data: {id: id},
        success: function(response) {
            // 서버에서 받은 응답(response)에 따라 처리
            if (response === 'available') {
                alert('사용 가능한 아이디입니다.');
                document.frm.reid.value = id; // 중복 체크된 아이디를 숨은 필드에 저장
            } else {
                alert('이미 사용 중인 아이디입니다. 다른 아이디를 입력해주세요.');
                document.frm.id.focus();
            }
        },
        error: function(error) {
            console.error('Error during id check:', error);
        }
    });
}

function idok() {
    opener.frm.id.value = document.frm.id.value;
    opener.frm.reid.value = document.frm.id.value;
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