package com.shinhan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.service.MenuService;

@WebServlet("/menu/menuDelete.go")
public class MenuDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int menu_code = Integer.parseInt(request.getParameter("menu_code"));
		int result = new MenuService().menuDeleteByCode(menu_code);
		System.out.println(result + "건 삭제됨");
		
		response.sendRedirect("selectAll.go");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}