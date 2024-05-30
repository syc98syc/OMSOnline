package com.shinhan.controller;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.shinhan.dto.MenuDTO;
import com.shinhan.service.MenuService;

@WebServlet("/menu/menuDetail.go")
public class MenuDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int menu_code = Integer.parseInt( request.getParameter("menu_code"));
        try {
			request.setAttribute("menu", new MenuService().getMenuByCode(menu_code));
		} catch (SQLException e) {
			e.printStackTrace();
		}
        request.getRequestDispatcher("menuDetail.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String encoding = "utf-8";
		request.setCharacterEncoding(encoding);
    	int menu_code = Integer.parseInt(request.getParameter("menu_code"));
    	String name =request.getParameter("name");
        String category =request.getParameter("category");
        int price = Integer.parseInt(request.getParameter("price"));
        
        MenuDTO menu = new MenuDTO(menu_code, name, category, price);
        System.out.println(menu);
        int result = new MenuService().menuUpdateByCode(menu);
        System.out.println(result + "건 수정");
        //재요청
        response.sendRedirect("selectAll.go");
    }
}