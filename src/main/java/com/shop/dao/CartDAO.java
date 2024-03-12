package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shop.dto.CartVO;

import util.DBManager;

public class CartDAO {

	
	private CartDAO() {
		
	}
	private static CartDAO instance = new CartDAO();
	
	public static CartDAO getInstance() {
		return instance;
	}
	
	//아이디값으로 장바구니 보기 //
	public List<Object> selectCartById(String id){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Object> list = new ArrayList<>();
		
		
		//product a, cart b, users c
		String sql = "select  b.pcode, b.cartnumber, c.uname, a.pname, a.price, a.pictureurl, b.cartcnt	"
				+ "from product a join cart b on a.pcode=b.pcode "
								+ "join users c on c.id=b.id "
								+ "where b.id =?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Map<String,Object> hm = new HashMap<>();
				hm.put("pcode", rs.getInt("pcode"));
				hm.put("cartnumber", rs.getInt("cartnumber"));
				hm.put("uname", rs.getString("uname"));
				hm.put("pname", rs.getString("pname"));
				hm.put("pictureurl", rs.getString("pictureurl"));
				hm.put("price", rs.getString("price"));
				hm.put("cartcnt", rs.getString("cartcnt"));
				list.add(hm);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	//장바구니 담기 insert 
	public void insertCart(CartVO cvo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into cart(id, pcode, cartcnt) values(?,?,?)";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cvo.getId());
			pstmt.setInt(2, cvo.getPcode());
			pstmt.setInt(3, cvo.getCartcnt());
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
				
	}
	
	
	//장바구니 넘버로 해당 항목 삭제
	public void deleteCart(int cartnumber) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from cart where cartnumber=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cartnumber);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
				
	}
	
	//카트의 수량 증가시키는 버튼 메소드
	public void plusCartcnt(int cartnumber, int cartcnt) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update cart set cartcnt=?+1 where cartnumber=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cartcnt);
			pstmt.setInt(2, cartnumber);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	//카트의 수량 감소시키는 버튼 메소드
	public void minusCartcnt(int cartnumber, int cartcnt) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update cart set cartcnt=?-1 where cartnumber=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cartcnt);
			pstmt.setInt(2, cartnumber);
			pstmt.executeUpdate(); // 수행이 된다면 1 반환
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	
	}
	
		//아이디값, pcode, ordercnt로 주문할 사항 보기 --삭제예정
		public List<Object> selectReceiptByIdPcodeOrdercnt(String id, int pcode, int ordercnt){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<Object> list = new ArrayList<>();
			
			
			//product a,  users c
			
			
			String sql = "select a.pname, a.price, a.pictureurl,c.uname"
					+ "from product a join "
									+ "users c on c.id=b.id "
									+ "where b.id =?";
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					Map<String,Object> hm = new HashMap<>();
					hm.put("pcode", rs.getInt("pcode"));
					hm.put("cartnumber", rs.getInt("cartnumber"));
					hm.put("uname", rs.getString("uname"));
					hm.put("pname", rs.getString("pname"));
					hm.put("pictureurl", rs.getString("pictureurl"));
					hm.put("price", rs.getString("price"));
					hm.put("cartcnt", rs.getString("cartcnt"));
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
