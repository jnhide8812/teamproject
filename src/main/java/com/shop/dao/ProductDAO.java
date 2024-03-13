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

	// 상품 리스트
	public List<ProductVO> selectAllProducts() {
		// System.out.println("DAO연결");
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
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// 상품 등록
	public void insertProduct(ProductVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into product(pname, price, pstock, catecode, pstatus, pinfo, pictureurl) values(?,?,?,?,?,?,?)";
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

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 상품 수정
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
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return vo;
	}

	// 상품 업데이트
	public void updateProduct(ProductVO vo) {
		//System.out.println("업데이트DAO 테스트");
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
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 상품 삭제
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
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	 

	
	// 상품 재고 1 이상인 것만 메인 페이지에 출력
		public List<ProductVO> selectSellProduct() {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			String sql = "select * from product where pstock>=1 order by pcode desc";

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
					list.add(vo);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return list;
		}
	
		
		


//검색 기능
	public List<ProductVO> searchProduct(String searchText){
		List<ProductVO> list = new ArrayList<ProductVO>();
		
		Connection conn = null;
		ResultSet rs = null;
		String sql = "select * from Product where ";
		try {
			if(searchText != null && !searchText.equals("")) {
				sql += "Like '%"+searchText.trim()+"%'order by pname desc limit 12" ;
			}
			conn = DBManager.getConnection();
			PreparedStatement pstmt = null;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductVO pvo = new ProductVO();
				pvo.setPictureurl(rs.getString(1));
				pvo.setCatecode(rs.getString(2));
				pvo.setPcode(rs.getInt(3));
				pvo.setPname(rs.getString(4));
				pvo.setPrice(rs.getInt(5));
				pvo.setPstatus(rs.getString(6));
				pvo.setPstock(rs.getInt(7));
				list.add(pvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}return list;
	}

}


