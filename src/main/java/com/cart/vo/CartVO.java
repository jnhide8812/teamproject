package com.cart.vo;

public class CartVO {
	private Integer cartnumber;
	private String id;
	private Integer pcode;
	private Integer catecode;
	private Integer cartcnt;
	public Integer getCartnumber() {
		return cartnumber;
	}
	public void setCartnumber(Integer cartnumber) {
		this.cartnumber = cartnumber;
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
	public Integer getCatecode() {
		return catecode;
	}
	public void setCatecode(Integer catecode) {
		this.catecode = catecode;
	}
	public Integer getCartcnt() {
		return cartcnt;
	}
	public void setCartcnt(Integer cartcnt) {
		this.cartcnt = cartcnt;
	}
	@Override
	public String toString() {
		return "cartVO [cartnumber=" + cartnumber + ", id=" + id + ", pcode=" + pcode + ", catecode=" + catecode
				+ ", cartcnt=" + cartcnt + "]";
	}
	
	
}
