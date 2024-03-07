package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.shop.dto.managerVO;

public class managerDAO {
	
	private managerDAO() {
		
	}
	
	private static managerDAO instance = new managerDAO();
	
	public static managerDAO getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws Exception{
		Connection conn = null;
		Context init = new InitialContext();
		Context envContext = (Context)init.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/shoppingmall");
		conn = ds.getConnection();
		return conn;
	}
	
	public List<managerVO> selectAllManager(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from product order by code";
		
		List<managerVO> list = new ArrayList<managerVO>();
		try {
			conn = dbm
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}
}
