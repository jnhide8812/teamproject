package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.shop.dto.ManagerVO;

import util.DBManager;

public class ManagerDAO {
	
	private ManagerDAO() {
		
	}
	
	private static ManagerDAO instance = new ManagerDAO();
	
	public static ManagerDAO getInstance() {
		return instance;
	}
	
	//매니저 리스트(상품등록리스트) 출력
	public List<ManagerVO> selectAllManager(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from product order by code";
		
		List<ManagerVO> list = new ArrayList<ManagerVO>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ManagerVO vo = new ManagerVO();
				vo.setPname(rs.getString("name"));
				vo.setPrice(rs.getInt("price"));
				vo.setPstock(rs.getInt("stock"));
				vo.setCatecode(rs.getInt("catecode"));
				vo.setPstatus(rs.getString("status"));
				vo.setPinfo(rs.getString("info"));
				vo.setPictureurl(rs.getString("pictureurl"));
				list.add(vo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	//매니저 리스트에 상품등록 추가
	public void insertProduct(ManagerVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
	}
}
