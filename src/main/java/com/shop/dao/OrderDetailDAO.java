package com.shop.dao;

public class OrderDetailDAO {

	private OrderDetailDAO() {
		
	}
	private static OrderDetailDAO instance = new OrderDetailDAO();
	
	private static OrderDetailDAO getInstance() {
		return instance;
	}
	
	//주문상세 테이블에 인서트하기
	
	
}
