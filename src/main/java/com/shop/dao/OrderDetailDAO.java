package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.util.List;
import java.util.HashMap;
import java.util.Map;


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

	//OrderDetail 업데이트
	public void updateOrderDetail(OrderDetailVO odvo) {
		//System.out.println("업데이트DAO 테스트");
		String sql = "update orderdetail set ordernumber=?, id=?, pcode=? ordercnt=? daddress=? dname=? where orderdetailnumber=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, odvo.getOrderdetailnumber());
			pstmt.setInt(2, odvo.getOrdernumber());
			pstmt.setString(3, odvo.getId());
			pstmt.setInt(4, odvo.getPcode());
			pstmt.setInt(5, odvo.getOrdercnt());
			pstmt.setString(6, odvo.getDaddress());
			pstmt.setString(7, odvo.getDname());
			
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	//OrderDetail 수정
	public OrderDetailVO selectOrderDetailByOrdernumber(String ordernumber) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from orderdetail where ordernumber=?";
		OrderDetailVO ovo = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ordernumber);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				ovo = new OrderDetailVO();
				ovo.setOrderdetailnumber(rs.getInt("orderdetailnumber"));
				ovo.setOrdernumber(rs.getInt("ordernumber"));
				ovo.setPcode(rs.getInt("pcode"));
				ovo.setOrdercnt(rs.getInt("ordercnt"));
				ovo.setId(rs.getString("id"));
				ovo.setDname(rs.getString("dname"));
				ovo.setDaddress(rs.getString("daddress"));
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return ovo;
	}

	//주문 상세 내역 출력하기
	public List<Object> selectOrderDetail(int ordernumber) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select a.ordercnt, a.daddress, a.dname, b.pname, b.price, b.pictureurl from orderdetail a join product b on a.pcode=b.pcode where a.ordernumber=?";
		List<Object> list = new ArrayList<Object>();
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ordernumber);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Map<String, Object> hm = new HashMap<>();
				hm.put("ordercnt", rs.getInt("ordercnt"));
				hm.put("daddress", rs.getString("daddress"));
				hm.put("dname", rs.getString("dname"));
				hm.put("pname", rs.getString("pname"));
				hm.put("price", rs.getInt("price"));
				hm.put("pictureurl", rs.getString("pictureurl"));
				list.add(hm);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
		
		
	}

	
}
