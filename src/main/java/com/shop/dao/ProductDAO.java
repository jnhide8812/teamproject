package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shop.dto.ProductVO;

import util.DBManager;


public class ProductDAO {
	public ProductDAO() {
		 
	}
	private static ProductDAO instance = new ProductDAO();
	public static ProductDAO getInstance() {
		return instance;
	}
	
	//상품 리스트
	public List<ProductVO> selectAllProducts(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from product order by pcode desc"; 
		
		List<ProductVO> list = new ArrayList<ProductVO>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setPname(rs.getString("pname"));
				vo.setPrice(rs.getInt("price"));
				vo.setPstock(rs.getInt("pstock"));
				vo.setPstatus(rs.getString("pstatus"));
				vo.setPinfo(rs.getString("pinfo"));
				vo.setPictureurl(rs.getString("pictureurl"));
				vo.setCatecode(rs.getString("catecode"));
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
	public void insertProduct(ProductVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into product(pname, price, pstock, catecode, pstatus, pinfo, pictureurl) values(?,?,?,?,?,?,?)";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,vo.getPname());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setInt(3, vo.getPstock());
			pstmt.setString(4, vo.getCatecode());
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
	public ProductVO selectProductByPcode(String pcode) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from product where pcode = ?";
		ProductVO vo = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pcode);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new ProductVO();
				vo.setPcode(rs.getInt("pcode"));
				vo.setPname(rs.getString("pname"));
				vo.setPrice(rs.getInt("price"));
				vo.setPstock(rs.getInt("pstock"));
				vo.setPstatus(rs.getString("pstatus"));
				vo.setPinfo(rs.getString("pinfo"));
				vo.setPictureurl(rs.getString("pictureurl"));
				vo.setCatecode(rs.getString("catecode"));			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return vo;
	}
	
	
	//상품 업데이트
	public void updateProduct(ProductVO vo) {
		String sql = "update product set pname=?, price=?, pstock=?, catecode=?, pstatus=?, pinfo=?, pictureurl=? where pcode=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPname());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setInt(3, vo.getPstock());
			pstmt.setString(4, vo.getCatecode());
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
	public void deleteProduct(String pcode) {
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
