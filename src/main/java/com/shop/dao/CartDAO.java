package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.DBManager;

public class CartDAO {

	
	private CartDAO() {
		
	}
	private static CartDAO instance = new CartDAO();
	
	public static CartDAO getInstance() {
		return instance;
	}
	
	//아이디 눌러 장바구니 보기 
	public List<Object> selectCartById(String id){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Object> list = new ArrayList<>();
		
		String sql = "select  c.uname, a.pname, a.pictureurl, b.cartcnt	"
				+ "from product a join cart b on a.pcode=b.pcode "
								+ "join users c on c.id=b.id "
								+ "where b.id =?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Map<String,String> hm = new HashMap<>();
				hm.put("uname", rs.getString("uname"));
				hm.put("pname", rs.getString("pname"));
				hm.put("pictureurl", rs.getString("pictureurl"));
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
