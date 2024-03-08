package com.shop.dto;

public class ManagerOrderDetailVO {
	// orderdetail
	private Integer orderdetailnumber;
	private String daddress;
	private String dname;

	// ordertable
	private Integer ordernumber;
	private String orderstatus;
	private Integer totalprice;
	private Integer ordercnt;

	// users
	private String id;
	private String upwd;
	private String uname;
	private String uphone;
	private String ubirth;
	private String uaddress;
	private String ugrade;
	private Integer upoint;

	// product
	private Integer pcode;
	private String pname;
	private Integer price;

	// cart
	private Integer cartcnt;

	public Integer getOrderdetailnumber() {
		return orderdetailnumber;
	}

	public void setOrderdetailnumber(Integer orderdetailnumber) {
		this.orderdetailnumber = orderdetailnumber;
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

	public Integer getOrdernumber() {
		return ordernumber;
	}

	public void setOrdernumber(Integer ordernumber) {
		this.ordernumber = ordernumber;
	}

	public String getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	public Integer getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(Integer totalprice) {
		this.totalprice = totalprice;
	}

	public Integer getOrdercnt() {
		return ordercnt;
	}

	public void setOrdercnt(Integer ordercnt) {
		this.ordercnt = ordercnt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUphone() {
		return uphone;
	}

	public void setUphone(String uphone) {
		this.uphone = uphone;
	}

	public String getUbirth() {
		return ubirth;
	}

	public void setUbirth(String ubirth) {
		this.ubirth = ubirth;
	}

	public String getUaddress() {
		return uaddress;
	}

	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}

	public String getUgrade() {
		return ugrade;
	}

	public void setUgrade(String ugrade) {
		this.ugrade = ugrade;
	}

	public Integer getUpoint() {
		return upoint;
	}

	public void setUpoint(Integer upoint) {
		this.upoint = upoint;
	}

	public Integer getPcode() {
		return pcode;
	}

	public void setPcode(Integer pcode) {
		this.pcode = pcode;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getCartcnt() {
		return cartcnt;
	}

	public void setCartcnt(Integer cartcnt) {
		this.cartcnt = cartcnt;
	}

	@Override
	public String toString() {
		return "ManagerOrderDetailVO [orderdetailnumber=" + orderdetailnumber + ", daddress=" + daddress + ", dname="
				+ dname + ", ordernumber=" + ordernumber + ", orderstatus=" + orderstatus + ", totalprice=" + totalprice
				+ ", ordercnt=" + ordercnt + ", id=" + id + ", upwd=" + upwd + ", uname=" + uname + ", uphone=" + uphone
				+ ", ubirth=" + ubirth + ", uaddress=" + uaddress + ", ugrade=" + ugrade + ", upoint=" + upoint
				+ ", pcode=" + pcode + ", pname=" + pname + ", price=" + price + ", cartcnt=" + cartcnt + "]";
	}

}