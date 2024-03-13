package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	public int userCheck(String id, String upwd) {
		int result = 1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select upwd, ugrade from users where id=?";
		String ugrade = "0";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				// 비밀번호 일치
				if (upwd.equals(rs.getString("upwd"))) {
					// 회원등급
					if (ugrade.equals(rs.getString("ugrade"))) {
						result = 2; // 관리자 로그인 성공
						if (ugrade.equals("ugrade")) {
							result = 1;// 일반회원, vip 로그인 성공
						}
					}
				} else {
					result = 0; // 비밀번호가 맞지 않을 때
				}
			} else {
				result = -1; // 아이디가 존재하지 않을때
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
			} catch (Exception e) {

			}
		}
		return result;
	}

	public void insertUsers(UsersVO member) {
		// System.out.println("dao");
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

	// id 회원정보 가져오는 메소드
	public UsersVO selectById(String id) {
		UsersVO uvo = null;
		String sql = "select * from users where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
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
		return uvo;
	}

	public int updateUser(UsersVO uvo) {
		int result = -1; // 정보수정 실패 시 -1 반환
		String sql = "update users set uphone=?, uaddress=?, ugrade=? where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uvo.getUphone());
			pstmt.setString(2, uvo.getUaddress());
			pstmt.setString(3, uvo.getId());
			pstmt.setString(4, uvo.getUgrade());
			
			result = pstmt.executeUpdate(); // 정보수정 완료시 1 반환

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					pstmt.close();

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return result;

	}
	 
	//회원관리 리스트 출력(7)
	public List<UsersVO> selectAllUsers(){
		//System.out.println("연결Test");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from users order by id desc";
		
		List<UsersVO> userlist = new ArrayList<UsersVO>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				UsersVO uvo = new UsersVO();
				uvo.setId(rs.getString("id"));
				uvo.setUpwd(rs.getString("upwd"));
				uvo.setUname(rs.getString("uname"));
				uvo.setUphone(rs.getString("uphone"));
				uvo.setUbirth(rs.getString("ubirth"));
				uvo.setUaddress(rs.getString("uaddress"));
				uvo.setUgrade(rs.getString("ugrade"));
				uvo.setUpoint(rs.getInt("upoint"));
				userlist.add(uvo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return userlist;
	}
	//아이디를 찾는 메소드 
			public String findId(String uname, String uphone) {
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				String id = null;
				String sql = "select id from users where uname=? and uphone=?";
				try {
					conn = DBManager.getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, uname);
					pstmt.setString(2, uphone);
					rs = pstmt.executeQuery();
					
					if(rs.next()) {
						id= rs.getString("id");
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					DBManager.close(conn, pstmt, rs);
				}return id;
				
				
				
			}

			// 비밀번호를 찾는 메소드
			public String findPwd(String id, String uname, String uphone) {
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;

				String upwd = null;
				String sql = "select upwd from users where id=? and uname=? and uphone=?";
				try {
					conn = DBManager.getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.setString(2, uname);
					pstmt.setString(3, uphone);
					rs = pstmt.executeQuery();
					
					if (rs.next()) {
						upwd = rs.getString("upwd");
						return upwd;
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					DBManager.close(conn, pstmt, rs);
				}
				return upwd;

			}
}
