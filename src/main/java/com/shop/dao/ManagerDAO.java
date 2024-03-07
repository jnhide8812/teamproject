package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shop.dto.ManagerVO;

import util.DBManager;

public class ManagerDAO {
	public ManagerDAO() {
		 
	}
	private static ManagerDAO instance = new ManagerDAO();
	public static ManagerDAO getInstance() {
		return instance;
	}
	
	//상품 리스트
	public List<ManagerVO> selectAllProducts(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from product order by code desc";
		
		List<ManagerVO> list = new ArrayList<ManagerVO>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ManagerVO vo = new ManagerVO();
				vo.setPname(rs.getString("pname"));
				vo.setPrice(rs.getInt("price"));
				vo.setPstock(rs.getInt("pstock"));
				vo.setPstatus(rs.getString("pstatus"));
				vo.setPinfo(rs.getString("pinfo"));
				vo.setPictureurl(rs.getString("pictureurl"));
				vo.setCatecode(rs.getInt("catecode"));
				vo.setPcode(rs.getInt("pcode"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	//상품 등록
	public void insertProduct(ManagerVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into product(pname, price, pstock, catecode, pstatus, pinfo, pictureurl) values(?,?,?,?,?,?,?)";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,vo.getPname());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setInt(3, vo.getPstock());
			pstmt.setInt(4, vo.getCatecode());
			pstmt.setString(5, vo.getPstatus());
			pstmt.setString(6, vo.getPinfo());
			pstmt.setString(7, vo.getPictureurl());
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	
	//상품 수정
	public ManagerVO selectProductByPcode(String pcode) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from product where pcode = ?";
		ManagerVO vo = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pcode);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new ManagerVO();
				vo.setPcode(rs.getInt("pcode"));
				vo.setPname(rs.getString("pname"));
				vo.setPrice(rs.getInt("price"));
				vo.setPstock(rs.getInt("pstock"));
				vo.setPstatus(rs.getString("pstatus"));
				vo.setPinfo(rs.getString("pinfo"));
				vo.setPictureurl(rs.getString("pictureurl"));
				vo.setCatecode(rs.getInt("catecode"));			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return vo;
	}
	
	
	//상품 업데이트
	public void updateProduct(ManagerVO vo) {
		String sql = "update product set pname=?, price=?, pstock=?, catecode=?, pstatus=?, pinfo=?, pictureurl=? where pcode=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
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
			pstmt.setInt(8, vo.getPcode());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	//상품 삭제
	private void deleteProduct(String pcode) {
		String sql = "delete from product where pcode=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pcode);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	
}
