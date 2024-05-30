package com.shinhan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.service.OrderingService;


@WebServlet("/order/selectAll.go")
public class OrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderingService service = new OrderingService();
        request.setAttribute("olist", service.selectAll());
 
        request.getRequestDispatcher("orderList.jsp").forward(request, response);
	}

}
