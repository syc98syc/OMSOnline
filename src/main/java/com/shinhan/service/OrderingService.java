package com.shinhan.service;

import java.sql.SQLException;
import java.util.List;

import com.shinhan.dao.OrderingDAO;
import com.shinhan.dto.OrderingDTO;

public class OrderingService {

	// 주문
	OrderingDAO orderingDAO = new OrderingDAO();

	// 주문하기
	public int orderInsert(OrderingDTO order) {
		return orderingDAO.orderInsert(order);
	}

	// 주문 전체 조회
	public List<OrderingDTO> selectAll() {
		return orderingDAO.selectAll();
	}

	// 내 주문 조회
	public List<OrderingDTO> getOrderByCode(int no) throws SQLException {
		return orderingDAO.getOrderByCode(no);
	}

	// 주문 취소
	public int orderDelete(OrderingDTO order) {
		return orderingDAO.orderDelete(order);
	}

	// 주문 조리 시작
	public int orderCook(OrderingDTO order) {
		return orderingDAO.orderCook(order);
	}

	// 주문 찾기 - 조리시작에 이용 //String->int로 변경(240509)
	public OrderingDTO selectById(int id) {
		return orderingDAO.selectById(id);
	}

}
