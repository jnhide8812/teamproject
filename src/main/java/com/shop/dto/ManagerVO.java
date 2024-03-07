package com.shop.dto;

public class ManagerVO {
	private int pcode; //상품 코드
	private int catecode; //카테고리 코드
	private String pname; //상품 이름
	private int price; //상품 가격
	private int pstock; //상품 재고
	private String pstatus; //상품 상태
	private String pinfo; //상품 정보
	private String pictureurl; //상품 사진
	
	
	
	public int getPcode() {
		return pcode;
	}

	public void setPcode(int pcode) {
		this.pcode = pcode;
	}

	public int getCatecode() {
		return catecode;
	}

	public void setCatecode(int catecode) {
		this.catecode = catecode;
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
		return "ManagerVO [pcode=" + pcode + ", catecode=" + catecode + ", pname=" + pname + ", price=" + price
				+ ", pstock=" + pstock + ", pstatus=" + pstatus + ", pinfo=" + pinfo + ", pictureurl=" + pictureurl
				+ "]";
	}

}
