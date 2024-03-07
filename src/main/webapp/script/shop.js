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
