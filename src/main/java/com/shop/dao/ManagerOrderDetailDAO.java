package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shop.dto.ManagerOrderDetailVO;

import util.DBManager;

public class ManagerOrderDetailDAO {
	public ManagerOrderDetailDAO() {
		
	}
	private static ManagerOrderDetailDAO instance = new ManagerOrderDetailDAO();
	public static ManagerOrderDetailDAO getInstance() {
		return instance;
	}
	
	
	//회원 리스트 뽑아오기
	public List<ManagerOrderDetailVO> selectAllMembers(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from users order by code desc";
		
		List<ManagerOrderDetailVO> memberlist = new ArrayList<ManagerOrderDetailVO>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ManagerOrderDetailVO vo = new ManagerOrderDetailVO();
				vo.setId(rs.getString("id"));
				vo.setUpwd(rs.getString("upwd"));
				vo.setUphone(rs.getString("uphone"));
				vo.setUbirth(rs.getString("ubirth"));
				vo.setUaddress(rs.getString("uaddress"));
				vo.setUgrade(rs.getString("ugrade"));
				vo.setUpoint(rs.getInt("upoint"));
			}				
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return memberlist;
	}
	
	
	//주문상세테이블에서 상세번호와 주소, 상품수량 뽑아오기
		public List<ManagerOrderDetailVO> selectOrderDetail(){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql = "select orderdetailnumber, daddress, ordercnt from orderdetail order by ordernumber desc";
			
			List<ManagerOrderDetailVO> orderdetaillist = new ArrayList<ManagerOrderDetailVO>();
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					ManagerOrderDetailVO vo = new ManagerOrderDetailVO();
					vo.setOrderdetailnumber(rs.getInt("orderdetailnumber"));
					vo.setDaddress(rs.getString("daddress"));
					vo.setOrdercnt(rs.getInt("ordercnt"));
				}				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(conn, pstmt, rs);
			}
			return orderdetaillist;
		}
	
		
		//주문테이블에서 주문번호와 총합과 배송상태 뽑아오기
			public List<ManagerOrderDetailVO> selectOrderTable(){
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				String sql = "select ordernumber, orderstatus, totalprice from orderdetable order by orderdate desc";
				
				List<ManagerOrderDetailVO> orderlist = new ArrayList<ManagerOrderDetailVO>();
				try {
					conn = DBManager.getConnection();
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						ManagerOrderDetailVO vo = new ManagerOrderDetailVO();
						vo.setOrderdetailnumber(rs.getInt("orderdetailnumber"));
						vo.setDaddress(rs.getString("daddress"));
					}				
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					DBManager.close(conn, pstmt, rs);
				}
				return orderlist;
		}
	
	
		//상품테이블에서 상품코드와 상품이름과 가격 뽑아오기
			public List<ManagerOrderDetailVO> selectProductTable(){
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				String sql = "select pcode, pname, price from product order by pcode desc";
				
				List<ManagerOrderDetailVO> productlist = new ArrayList<ManagerOrderDetailVO>();
				try {
					conn = DBManager.getConnection();
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						ManagerOrderDetailVO vo = new ManagerOrderDetailVO();
						vo.setPcode(rs.getInt("pcode"));
						vo.setPname(rs.getString("pname"));
						vo.setPrice(rs.getInt("price"));
					}				
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					DBManager.close(conn, pstmt, rs);
				}
				return productlist;
		}			
			
			
			//장바구니 테이블에서 수량 뽑아오기
			public List<ManagerOrderDetailVO> selectCartTable(){
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				String sql = "select cartcnt from cart order by cartnumber desc";
				
				List<ManagerOrderDetailVO> cartlist = new ArrayList<ManagerOrderDetailVO>();
				try {
					conn = DBManager.getConnection();
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						ManagerOrderDetailVO vo = new ManagerOrderDetailVO();
						vo.setCartcnt(null);
					}				
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					DBManager.close(conn, pstmt, rs);
				}
				return cartlist;
		}			
			
			
			//주문 상세 수정
			public ManagerOrderDetailVO selectOrderDetailByNumber(String orderdetailnumber) {
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String sql = 
				
				
			}
			
			
			
			
			
			