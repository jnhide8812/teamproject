package com.shop.dto;

public class ManagerVO {
	private String pname;
	private Integer price;
	private Integer pstock;
	private String pstatus;
	private String pinfo;
	private String pictureurl;
	private Integer pcode;
	private Integer catecode;
	
	
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
	public Integer getPstock() {
		return pstock;
	}
	public void setPstock(Integer pstock) {
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
	
	@Override
	public String toString() {
		return "ManagerVO [pname=" + pname + ", price=" + price + ", pstock=" + pstock + ", pstatus=" + pstatus
				+ ", pinfo=" + pinfo + ", pictureurl=" + pictureurl + ", pcode=" + pcode + ", catecode=" + catecode
				+ "]";
	}
		
	
	
	
}
