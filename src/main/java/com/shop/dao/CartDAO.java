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
	
	//아이디값으로 장바구니 보기 
	public List<Object> selectCartById(String id){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Object> list = new ArrayList<>();
		
		String sql = "select  b.cartnumber, c.uname, a.pname, a.price, a.pictureurl, b.cartcnt	"
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
	
	
}
