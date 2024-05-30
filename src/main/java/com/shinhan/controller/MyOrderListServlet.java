package com.shinhan.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.service.OrderingService;


@WebServlet("/myorder/selectAll.do")
public class MyOrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderingService service = new OrderingService();
		int member_code = Integer.parseInt(request.getParameter("member_code"));
        try {
			request.setAttribute("olist", service.getOrderByCode(member_code));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
        request.getRequestDispatcher("orderList.jsp").forward(request, response);
        
	}

}
