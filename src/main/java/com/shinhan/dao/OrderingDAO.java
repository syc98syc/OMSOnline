package com.shinhan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.dto.OrderingDTO;
import com.shinhan.util.DBUtil;

public class OrderingDAO {
	Connection conn;
	Statement st;
	PreparedStatement pst;

	ResultSet rs;

	// 주문입력
	public int orderInsert(OrderingDTO order) {
		int result = 0;
		String sql = "insert into ordering values(ORDER_CODE_SEQ.nextval,?,?,?,?,sysdate,'N','N')";
		conn = DBUtil.dbConnection();
		try {

			pst = conn.prepareStatement(sql);
			pst.setInt(1, order.getMenu_code());
			pst.setInt(2, order.getMember_code());
			pst.setInt(3, order.getQuantity());
			pst.setInt(4, order.getPrice());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}

// 주문모두조회
	public List<OrderingDTO> selectAll() {
		List<OrderingDTO> orderlist = new ArrayList<OrderingDTO>();
		String sql = "select * from ordering";
		conn = DBUtil.dbConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				OrderingDTO order = makeOrderList(rs);
				orderlist.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return orderlist;
	}

	// 특정주문 1개 조회
	private OrderingDTO makeOrderList(ResultSet rs) throws SQLException {
		OrderingDTO order = new OrderingDTO();
		order.setCancel_or(rs.getString("cancel_or"));
		order.setMember_code(rs.getInt("member_code"));
		order.setMenu_code(rs.getInt("menu_code"));
		order.setOrder_code(rs.getInt("order_code"));
		order.setOrder_date(rs.getDate("order_date"));
		order.setPrice(rs.getInt("price"));
		order.setProgress(rs.getString("progress"));
		order.setQuantity(rs.getInt("quantity"));
		return order;
	}
	
	

	// 멤버코드로 자신주문내역 조회
	public List<OrderingDTO> getOrderByCode(int memCode) throws SQLException {
		List<OrderingDTO> orderlist = new ArrayList<OrderingDTO>();

		String sql = "select * from ordering where member_code = ?";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, memCode);
			rs = pst.executeQuery();

			while (rs.next()) {
				OrderingDTO order = makeOrderList(rs);
				orderlist.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return orderlist;
	}

	// 주문 삭제
	public int orderDelete(OrderingDTO order) {
		int result = 0;
		String sql = "delete from ordering where order_code = ? and progress = 'N'";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, order.getOrder_code());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}

	// 주문 조리 시작
	public int orderCook(OrderingDTO order) {
		int result = 0;
		String sql = "update ordering set progress = 'Y' where order_code = ?";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, order.getOrder_code());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}

	// 주문 찾기
	public OrderingDTO selectById(int order_code) {
		OrderingDTO ordering = null;
		String sql = "select * from ordering where order_code= " + order_code;
		conn = DBUtil.dbConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				ordering = makeOrderList(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ordering;
	}
}
