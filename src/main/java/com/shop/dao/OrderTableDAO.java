package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import util.DBManager;

public class OrderTableDAO {

	private OrderTableDAO(){
		
	}
	private static OrderTableDAO instance = new OrderTableDAO();
	
	public static OrderTableDAO getInstance() {
		return instance;
	}
	
	//INSERT INTO ordertable (id, totalprice, orderstatus, payment)
	//주문 테이블에 인서트하기
	public void insertOrder(String id, int totalprice, String orderstatus, String payment) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO ordertable (?,?,?,?)";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, totalprice);
			pstmt.setString(3, orderstatus);
			pstmt.setString(4, payment);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
		
		
		
	}
	
	
	
}
