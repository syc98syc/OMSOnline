package com.shinhan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.dto.MenuDTO;
import com.shinhan.util.DBUtil;

public class MenuDAO {
	Connection conn;
	Statement st;
	PreparedStatement pst;

	ResultSet rs;

	// 메뉴 입력
	public int menuInsert(MenuDTO menu) {
		int result = 0;
		String sql = "insert into menu values(MENU_CODE_SEQ.nextval,?,?,?)";
		conn = DBUtil.dbConnection();
		try {

			pst = conn.prepareStatement(sql);
			pst.setString(1, menu.getName());
			pst.setString(2, menu.getCategory());
			pst.setInt(3, menu.getPrice());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}

	// 메뉴 수정
	public int menuUpdate(MenuDTO menu) {
		int result = 0;
		String sql = "update menu set category=?,price=? where name=?";
		conn = DBUtil.dbConnection();
		try {

			pst = conn.prepareStatement(sql);
			pst.setString(1, menu.getCategory());
			pst.setInt(2, menu.getPrice());
			pst.setString(3, menu.getName());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	
	// 메뉴 수정2
		public int menuUpdateByCode(MenuDTO menu) {
			int result = 0;
			String sql = "update menu set name=?,category=?,price=? where menu_code=?";
			conn = DBUtil.dbConnection();
			try {

				pst = conn.prepareStatement(sql);
				pst.setString(1, menu.getName());
				pst.setString(2, menu.getCategory());
				pst.setInt(3, menu.getPrice());
				pst.setInt(4, menu.getMenu_code());
				result = pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.dbDisconnect(conn, pst, rs);
			}
			return result;
		}
	
	// 메뉴 삭제2
		public int menuDeleteByCode(int menu_code) {
			int result = 0;
			String sql = "delete from menu where menu_code=?";
			conn = DBUtil.dbConnection();
			try {
				pst = conn.prepareStatement(sql);
				pst.setInt(1, menu_code);
				result = pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.dbDisconnect(conn, pst, rs);
			}
			return result;
		}

	// 메뉴 삭제
	public int menuDelete(MenuDTO menu) {
		int result = 0;
		String sql = "delete from menu where name=?";
		conn = DBUtil.dbConnection();
		try {

			pst = conn.prepareStatement(sql);
			pst.setString(1, menu.getName());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}

	// 메뉴모두조회
	public List<MenuDTO> selectAll() {
		List<MenuDTO> menulist = new ArrayList<MenuDTO>();
		String sql = "select * from menu";
		conn = DBUtil.dbConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				MenuDTO menu = makeMenu(rs);
				menulist.add(menu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return menulist;
	}

	// 특정메뉴 1개 조회
	private MenuDTO makeMenu(ResultSet rs) throws SQLException {
		MenuDTO menu = new MenuDTO();
		menu.setMenu_code(rs.getInt("menu_code"));
		menu.setName(rs.getString("name"));
		menu.setCategory(rs.getString("category"));
		menu.setPrice(rs.getInt("price"));

		return menu;
	}

	// 메뉴코드로 1개 조회
	public MenuDTO getMenuByCode(int code) throws SQLException {
		MenuDTO dto = null;
		String sql = "select * from menu where menu_code = ?";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, code);
			rs = pst.executeQuery();

			if (rs.next()) {
				int menu_code = rs.getInt("menu_code");
				String name = rs.getString("name");
				String category= rs.getString("category");
				int price = rs.getInt("price");
				dto = new MenuDTO(menu_code, name, category, price);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return dto;
	}
}
