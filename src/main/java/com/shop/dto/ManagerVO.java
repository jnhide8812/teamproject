package com.shop.dto;

public class ManagerVO {
	private int pcode;
	private String pname;
	private int price;
	private int pstock;
	private int catecode;
	private String pstatus;
	private String pinfo;
	private String pictureurl;
	public int getPcode() {
		return pcode;
	}
	public void setPcode(int pcode) {
		this.pcode = pcode;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPstock() {
		return pstock;
	}
	public void setPstock(int pstock) {
		this.pstock = pstock;
	}
	public int getCatecode() {
		return catecode;
	}
	public void setCatecode(int catecode) {
		this.catecode = catecode;
	}
	public String getPstatus() {
		return pstatus;
	}
	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
	}
	public String getPinfo() {
		return pinfo;
	}
	public void setPinfo(String pinfo) {
		this.pinfo = pinfo;
	}
	public String getPictureurl() {
		return pictureurl;
	}
	public void setPictureurl(String pictureurl) {
		this.pictureurl = pictureurl;
	}
	@Override
	public String toString() {
		return "ManagerVO [pcode=" + pcode + ", pname=" + pname + ", price=" + price + ", pstock=" + pstock
				+ ", catecode=" + catecode + ", pstatus=" + pstatus + ", pinfo=" + pinfo + ", pictureurl=" + pictureurl
				+ "]";
	}
	
	
}
