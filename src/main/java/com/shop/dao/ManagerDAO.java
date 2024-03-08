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
		
		String sql = "select * from product order by pcode";
		
		List<ManagerVO> list = new ArrayList<ManagerVO>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ManagerVO vo = new ManagerVO();
				vo.setPname(rs.getString("pname"));
				vo.setPrice(rs.getInt("price"));
				vo.setPstock(rs.getInt("pstock"));
				vo.setCatecode(rs.getInt("catecode"));
				vo.setPstatus(rs.getString("pstatus"));
				vo.setPinfo(rs.getString("pinfo"));
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
		String sql = "insert into product(name,price,pstock,catecode,pstatus,pinfo,pictureurl) values(?,?,?,?,?,?,?)";
		
		try {
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPname());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setInt(3, vo.getPstock());
			pstmt.setInt(4, vo.getCatecode());
			pstmt.setString(5, vo.getPstatus());
			pstmt.setString(6, vo.getPinfo());
			pstmt.setString(7, vo.getPictureurl());
			
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
	}
}
