package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.shop.dto.OrderDetailVO;

import util.DBManager;

public class OrderDetailDAO {

	private OrderDetailDAO() {
		
	}
	private static OrderDetailDAO instance = new OrderDetailDAO();
	
	private static OrderDetailDAO getInstance() {
		return instance;
	}
	
	//주문상세 테이블에 인서트하기
	public void insertOrderDetail(OrderDetailVO odvo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO orderdetail (ordernumber, id, pcode, ordercnt, daddress, dname) VALUES (?, ?, ?, ?, ?,?)";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, odvo.getOrdernumber());
			pstmt.setString(2, odvo.getId());
			pstmt.setInt(3, odvo.getPcode());
			pstmt.setInt(4, odvo.getOrdercnt());
			pstmt.setString(5, odvo.getDaddress());
			pstmt.setString(6, odvo.getDname());
			
			pstmt.executeUpdate();
						
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
}
