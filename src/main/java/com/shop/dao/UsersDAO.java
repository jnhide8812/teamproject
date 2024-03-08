package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shop.dto.UsersVO;

import util.DBManager;

public class UsersDAO {

	private UsersDAO() {

	}

	private static UsersDAO instance = new UsersDAO();

	public static UsersDAO getInstance() {
		return instance;
	}

	// 사용자 체크 메소드(로그인 가능 여부)
	public int userCheck(String id, String upwd, String ugrade) {
		int result = 1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from users where id=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				// 비밀번호 일치
				if (upwd.equals(rs.getString("upwd"))) {
					// 회원등급 확인
					if (ugrade.equals(rs.getString("0"))) {
						result = 2; // 관리자로 로그인 성공
						if (ugrade.equals("2")) {
							result = 3; // vip회원으로 로그인 성공
						}
						if (ugrade.equals("1")) {
							result = 4; // 일반회원으로 로그인 성공
						}
					}
				} else {
					result = 1; // 비밀번호 불일치
				}

			} else {
				result = -1; // 아이디가 존재하지 않을 때
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (Exception e2) {

			}
		}
		return result;
	}

	public void insertUsers(UsersVO member) {
		System.out.println("dao");
		String sql = "insert into users values(?,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		System.out.println(member.getUbirth());
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getUpwd());
			pstmt.setString(3, member.getUname());
			pstmt.setString(4, member.getUphone());
			pstmt.setString(5, member.getUbirth());
			pstmt.setString(6, member.getUaddress());
			pstmt.setString(7, member.getUgrade());
			pstmt.setInt(8, member.getUpoint());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {

			}

		}

	}

	public int confirmID(String id) {
		int result = 1;
		String sql = "select id from users where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = 1;// 중복 아이디 있음
			} else {
				result = -1; // 사용가능한 아이디
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {

			}
		}
		return result;

	}

	//id 회원정보 가져오는 메소드 
			public UsersVO selectById(String id) {
				UsersVO uvo = null;
				String sql = "select * from users where id=?";
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					conn = DBManager.getConnection();
				    pstmt = conn.prepareStatement(sql);
				    pstmt.setString(1,id);
				    rs = pstmt.executeQuery();
				    if(rs.next()) {
				    	uvo = new UsersVO();
				    	uvo.setId(rs.getString("id"));
				    	uvo.setUpwd(rs.getString("upwd"));
				    	uvo.setUname(rs.getString("uname"));
				    	uvo.setUaddress(rs.getString("uaddress"));
				    	uvo.setUgrade(rs.getString("ugrade"));
				    	uvo.setUbirth(rs.getString("ubirth"));
				    	uvo.setUphone(rs.getString("uphone"));
				    	uvo.setUpoint(rs.getInt("upoint"));
				    	
				    
				    }
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					try {
						if(rs != null)
							rs.close();
						if(pstmt != null)
							pstmt.close();
						if(conn != null)
							conn.close();
					} catch (Exception e2) {
						
					}
					
				} return uvo;
			}
			public int updateUser(UsersVO uvo) {
				int result = -1; //정보수정 실패 시 -1 반환
				String sql = "update users set uphone=?, uaddress=? where id=?" ;
				Connection conn = null;
				PreparedStatement pstmt = null;
				try {
					conn = DBManager.getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,uvo.getUphone());
					pstmt.setString(2, uvo.getUaddress());
					pstmt.setString(3, uvo.getId());
					
					
					result = pstmt.executeUpdate(); //정보수정 완료시 1 반환
					
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					
				try {
					if(pstmt != null)
						pstmt.close();
					if(conn != null)
						pstmt.close();
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			} return result;

		}
	
}
