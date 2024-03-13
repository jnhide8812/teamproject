package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shop.dto.OrderTableVO;

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
	public void insertOrder(OrderTableVO ovo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO ordertable (id, totalprice, orderstatus, payment) VALUES(?,?,?,?)";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ovo.getId());
			pstmt.setInt(2, ovo.getTotalprice());
			pstmt.setString(3, ovo.getOrderstatus());
			pstmt.setString(4, ovo.getPayment());
			pstmt.executeUpdate();
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	//주문상세 넣기 전처리 -오더넘버 출력
	public int selectOrdernumber(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int ordernumber;
		
		String sql = "select ordernumber from ordertable where id=? and orderstatus='주문중' order by ordernumber desc";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				OrderTableVO ovo = new OrderTableVO();
				ordernumber = rs.getInt("ordernumber");
				return ordernumber;
			}
				} catch (Exception e2) {
			e2.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return 0;
	}
	
	//주문상세테이블에 주문 등록되면 주문테이블에 상태를 "주문완료"로 상태 변경
	public void updateOrderStatus(int ordernumber) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update ordertable set orderstatus='주문완료' where ordernumber=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ordernumber);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	//주문상세테이블에 주문 등록 실패하면 주문 delete
	public void deleteOrder(int ordernumber) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from ordertable where ordernumber=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ordernumber);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	//주문 완료 내역 출력
	public List<OrderTableVO> selectOrderTableById(String id){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from ordertable where id=? order by ordernumber desc";
		List<OrderTableVO> list = new ArrayList<OrderTableVO>();
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				OrderTableVO ovo = new OrderTableVO();
				ovo.setOrdernumber(rs.getInt("ordernumber"));
				ovo.setId(rs.getString("id"));
				ovo.setTotalprice(rs.getInt("totalprice"));
				ovo.setOrderstatus(rs.getString("orderstatus"));
				ovo.setPayment(rs.getString("payment"));
				
				list.add(ovo);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
		
	}
	
	
	//개인 주문 내역 정보 전부 출력 ---- 사용XXXX
		public List<Object> selectOrderListById(String id){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "select c.pname, a.ordernumber, a.id, a.totalprice, a.orderstatus, a.payment, b.orderdetailnumber, b.pcode, b.ordercnt, b.daddress, b.dname from ordertable a join orderdetail b on a.ordernumber = b.ordernumber join product c on b.pcode=c.pcode where a.id=? order by ordernumber desc";
			List<Object> list = new ArrayList<>();
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					Map<String,Object> hm = new HashMap<>();
					hm.put("pname", rs.getString("pname"));
					hm.put("ordernumber", rs.getInt("ordernumber"));
					hm.put("id", rs.getString("id"));
					hm.put("totalprice", rs.getInt("totalprice"));
					hm.put("orderstatus", rs.getString("orderstatus"));
					hm.put("payment", rs.getString("payment"));
					hm.put("orderdetailnumber", rs.getInt("orderdetailnumber"));
					hm.put("pcode", rs.getInt("pcode"));
					hm.put("ordercnt", rs.getInt("ordercnt"));
					hm.put("daddress", rs.getString("daddress"));
					hm.put("dname", rs.getString("dname"));
					
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
