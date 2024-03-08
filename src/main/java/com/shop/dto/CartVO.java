package com.shop.dto;

public class CartVO {
	private int cartnumber;
	private String id;
	private int pcode;
	private int cartcnt;
	public int getCartnumber() {
		return cartnumber;
	}
	public void setCartnumber(int cartnumber) {
		this.cartnumber = cartnumber;
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
	public int getCartcnt() {
		return cartcnt;
	}
	public void setCartcnt(int cartcnt) {
		this.cartcnt = cartcnt;
	}
	@Override
	public String toString() {
		return "CartVO [cartnumber=" + cartnumber + ", id=" + id + ", pcode=" + pcode + ", cartcnt=" + cartcnt + "]";
	}
	
	
	
	
}
