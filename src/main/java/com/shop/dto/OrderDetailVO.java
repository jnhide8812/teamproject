package com.shop.dto;
 
public class OrderDetailVO {
	private int orderdetailnumber; // 주문상세번호
	private int ordernumber; //주문번호
	private String id;  //아이디
	private int pcode; //상품 코드
	private int ordercnt; //상품수량
	private String daddress; //배송주소
	private String dname; //수령인명
	public int getOrderdetailnumber() {
		return orderdetailnumber;
	}
	public void setOrderdetailnumber(int orderdetailnumber) {
		this.orderdetailnumber = orderdetailnumber;
	}
	public int getOrdernumber() {
		return ordernumber;
	}
	public void setOrdernumber(int ordernumber) {
		this.ordernumber = ordernumber;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPcode() {
		return pcode;
	}
	public void setPcode(int pcode) {
		this.pcode = pcode;
	}
	public int getOrdercnt() {
		return ordercnt;
	}
	public void setOrdercnt(int ordercnt) {
		this.ordercnt = ordercnt;
	}
	public String getDaddress() {
		return daddress;
	}
	public void setDaddress(String daddress) {
		this.daddress = daddress;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	@Override
	public String toString() {
		return "OrderDetailVO [orderdetailnumber=" + orderdetailnumber + ", ordernumber=" + ordernumber + ", id=" + id
				+ ", pcode=" + pcode + ", ordercnt=" + ordercnt + ", daddress=" + daddress + ", dname=" + dname + "]";
	}
	 
	
	
	
	
	
	
}
