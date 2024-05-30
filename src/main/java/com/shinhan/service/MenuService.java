package com.shinhan.service;

import java.sql.SQLException;
import java.util.List;

import com.shinhan.dao.MenuDAO;
import com.shinhan.dto.MenuDTO;

public class MenuService {
	MenuDAO menuDAO = new MenuDAO();

	// 메뉴 입력(Insert)
	public int menuInsert(MenuDTO menu) {
		return menuDAO.menuInsert(menu);
	}

	// 메뉴 수정2
	public int menuUpdateByCode(MenuDTO menu) {
		return menuDAO.menuUpdateByCode(menu);
	}

	// 메뉴 수정
	public int menuUpdate(MenuDTO menu) {
		return menuDAO.menuUpdate(menu);
	}

	// 메뉴 삭제
	public int menuDelete(MenuDTO menu) {
		return menuDAO.menuDelete(menu);
	}

	// 메뉴 삭제 코드로
	public int menuDeleteByCode(int menu_code) {
		return menuDAO.menuDeleteByCode(menu_code);
	}

	// 메뉴 조회
	public List<MenuDTO> selectAll() {
		return menuDAO.selectAll();
	}

	// 메뉴코드로 메뉴조회 - 주문에 이용
	public MenuDTO getMenuByCode(int no) throws SQLException {
		return menuDAO.getMenuByCode(no);
	}
}
