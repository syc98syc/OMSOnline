package com.shinhan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	// DB연결

	public static Connection dbConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // EE - data source explorer 에서 찾기
		String userid = "OMS";
		String password = "OMS";
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // Referenced Libraries에서 찾기
			//System.out.println("1. JDBC Driver load 성공");
			conn = DriverManager.getConnection(url, userid, password);
			//System.out.println("2. Connection 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

	// DB연결해제
	public static void dbDisconnect(Connection conn, Statement st, ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(st!=null) st.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
