package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Context init =new InitialContext();
			Context envContext = (Context)init.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/shoppingmall");
			conn = ds.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	//select 수행후 닫기
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs != null)
				rs.close();
			if(stmt != null)
				stmt.close();
			if(conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//create, update, delete 수행 후 닫기
	public static void close(Connection conn, Statement stmt) {
		try {
			if(stmt != null)
				stmt.close();
			if(conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
