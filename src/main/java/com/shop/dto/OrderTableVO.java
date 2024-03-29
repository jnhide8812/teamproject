package com.shop.dto;
 
public class OrderTableVO {
	private int ordernumber; //주문번호
	private String id; //아이디
	private int totalprice; //결제금액
	private String orderstatus; //주문상태(배송상태)
	private String payment; //결제방법
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
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public String getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	@Override
	public String toString() {
		return "OrderTableVO [ordernumber=" + ordernumber + ", id=" + id + ", totalprice=" + totalprice
				+ ", orderstatus=" + orderstatus + ", payment=" + payment + "]";
	}
	
	
	
	
	
}
