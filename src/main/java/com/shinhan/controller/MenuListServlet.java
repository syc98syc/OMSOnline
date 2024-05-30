package com.shinhan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.service.MenuService;

@WebServlet("/menu/selectAll.go")
public class MenuListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MenuService service = new MenuService();
        request.setAttribute("mlist", service.selectAll());
 
        request.getRequestDispatcher("menuList.jsp").forward(request, response);
	}
 

}