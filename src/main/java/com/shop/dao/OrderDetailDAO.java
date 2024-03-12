package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.shop.dto.OrderDetailVO;

import util.DBManager;

public class OrderDetailDAO {

	private OrderDetailDAO() {
		
	}
	private static OrderDetailDAO instance = new OrderDetailDAO();
	
	public static OrderDetailDAO getInstance() {
		return instance;
	}
	
	//주문상세 테이블에 인서트하기
	public int insertOrderDetail(OrderDetailVO odvo) {
		int result = 0;
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
			
			result = pstmt.executeUpdate();  //주문상세 등록 성공하면 1 반환
						
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
		
	}
	
	//주문 상세 리스트로 출력하기
	//public List<Object> 
	
}
