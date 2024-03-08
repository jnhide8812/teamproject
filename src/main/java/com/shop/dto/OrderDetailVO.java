package com.shop.dto;

public class OrderDetailVO {
	private Integer orderdetailnumber; // 주문상세번호
	private Integer ordernumber; //주문번호
	private String id;  //아이디
	private Integer pcode; //상품 코드
	private Integer ordercnt; //상품수량
	private String daddress; //배송주소
	private String dname; //수령인명
	public Integer getOrderdetailnumber() {
		return orderdetailnumber;
	}
	public void setOrderdetailnumber(Integer orderdetailnumber) {
		this.orderdetailnumber = orderdetailnumber;
	}
	public Integer getOrdernumber() {
		return ordernumber;
	}
	public void setOrdernumber(Integer ordernumber) {
		this.ordernumber = ordernumber;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getPcode() {
		return pcode;
	}
	public void setPcode(Integer pcode) {
		this.pcode = pcode;
	}
	public Integer getOrdercnt() {
		return ordercnt;
	}
	public void setOrdercnt(Integer ordercnt) {
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
