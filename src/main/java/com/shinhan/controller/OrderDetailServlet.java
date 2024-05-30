package com.shinhan.controller;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.shinhan.dto.OrderingDTO;
import com.shinhan.service.OrderingService;
import com.shinhan.util.DateUtil;

@WebServlet("/order/orderDetail.go")
public class OrderDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int order_code = Integer.parseInt( request.getParameter("order_code"));
        request.setAttribute("order", new OrderingService().selectById(order_code));
		
        request.getRequestDispatcher("orderDetail.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String encoding = "utf-8";
		request.setCharacterEncoding(encoding);
    	int order_code = Integer.parseInt(request.getParameter("order_code"));
    	int menu_code = Integer.parseInt(request.getParameter("menu_code"));
    	int member_code = Integer.parseInt(request.getParameter("member_code"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int price = Integer.parseInt(request.getParameter("price"));
        Date order_date = DateUtil.getSQLDate(request.getParameter("order_date"));
        String progress = request.getParameter("progress");
        String cancel_or = request.getParameter("cancel_or");
        
        OrderingDTO order = new OrderingDTO(order_code, menu_code, member_code, quantity, price, order_date, progress, cancel_or );
        System.out.println(order);
        int result = new OrderingService().orderCook(order);
        request.setAttribute("message", result+ "건 조리를 시작합니다!");
        
        //재요청
        RequestDispatcher rd = 
   				request.getRequestDispatcher("result.jsp");
   	    rd.forward(request, response);
    }
}