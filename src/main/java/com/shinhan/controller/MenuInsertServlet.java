package com.shinhan.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dto.MenuDTO;
import com.shinhan.service.MenuService;

@WebServlet("/menu/menuInsert.go")
public class MenuInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("menuInsert.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MenuDTO menu = makeMenu(request);
		MenuService service = new MenuService();
		
		int result = service.menuInsert(menu);
		System.out.println(result + "건 입력됨");
		request.setAttribute("message", result + "건 입력됨");

		//1)JSP에 응답을 위임하는 경우 (MVC2모델)
		RequestDispatcher rd = 
   				request.getRequestDispatcher("result.jsp");
   	    rd.forward(request, response);
	}

	private MenuDTO makeMenu(HttpServletRequest request) throws UnsupportedEncodingException {
		String encoding = "utf-8";
		request.setCharacterEncoding(encoding);
		MenuDTO menu = new MenuDTO();
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		int price = Integer.parseInt(request.getParameter("price"));
		
		
		menu.setName(name);
		menu.setCategory(category);
		menu.setPrice(price);
		return menu;
	}

}