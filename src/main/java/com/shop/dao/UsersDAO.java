package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.shop.dto.UsersVO;

public class UsersDAO {
	
	private UsersDAO() {
		
	}

	 private static UsersDAO instance = new UsersDAO();
	   
	   public static UsersDAO getInstance() {
	      return instance;
	   }
	
	 //DBCP 접속 메소드
	   Connection getConnection() {
	      Connection conn = null;
	      Context initContext;
	      try {
	         initContext = new InitialContext();
	         DataSource ds = (DataSource)initContext.lookup("java:/comp/env/jdbc/shoppingmall");
	         conn = ds.getConnection();
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return conn;
	   }
	   
	   //사용자 체크 메소드(로그인 가능 여부)
	   public int userCheck(String id, String upwd, String ugrade) {
	      int result = 1;         //레벨이 틀린경우
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      String sql = "select * from users where id=?";
	      
	     
	      try {
	         conn = getConnection();
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, id);
	         
	         rs = pstmt.executeQuery();
	       
	         
	         if(rs.next()) {
	            //비밀번호 일치
	            if(upwd.equals(rs.getString("upwd"))) {
	               //회원등급 확인
	               if(ugrade.equals(rs.getString("0"))) {
	                  result = 2;   // 관리자로 로그인 성공
	                  if(ugrade.equals("1")) {
	                     result=3; //일반회원으로 로그인 성공
	                  }
	               }
	            }else {
	               result = 0;  //비밀번호 불일치
	            }
	            
	         }else {
	            result = -1;  //아이디가 존재하지 않을 때
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         try {
	            if(rs !=null)
	               rs.close();
	            if( pstmt != null)
	               pstmt.close();
	            if(conn != null)
	               conn.close();
	               
	         } catch (Exception e2) {
	            
	         }
	      }
	      return result;
	   }
	   
	   public void insertUsers(UsersVO member) {
		   String sql = "insert into users values(?,?,?,?,?,?,?,?)";
		   Connection conn = null;
		   PreparedStatement pstmt = null;
		   try {
			conn = getConnection();
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
		}finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch (Exception e2) {
				
			}
			
		}
		   
		   
		   
		   
		   
	   }
	   
	   public int confirmID(String id) {
			int result =1;
			String sql = "select id from users where id=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result = 1;//중복 아이디 있음
			}else {
				result = -1; //사용가능한 아이디
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
		}return result;
		
		
		
		}

	   
	   
}
