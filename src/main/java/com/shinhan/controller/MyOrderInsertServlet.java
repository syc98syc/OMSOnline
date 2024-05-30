package com.shinhan.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dto.MenuDTO;
import com.shinhan.dto.OrderingDTO;
import com.shinhan.service.MenuService;
import com.shinhan.service.OrderingService;

@WebServlet("/myorder/orderInsert.do")
public class MyOrderInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<MenuDTO> mlist = new MenuService().selectAll();
	 
		request.setAttribute("mlist",mlist );
		request.getRequestDispatcher("orderInsert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderingDTO order = makeOrder(request);
		OrderingService service = new OrderingService();
		
		int result = service.orderInsert(order);
		System.out.println(result + "건 입력됨");
		request.setAttribute("message", result + "건 주문 완료!");

		//1)JSP에 응답을 위임하는 경우 (MVC2모델)
		RequestDispatcher rd = 
   				request.getRequestDispatcher("result.jsp");
   	    rd.forward(request, response);
	}

	private OrderingDTO makeOrder(HttpServletRequest request) throws UnsupportedEncodingException {
		String encoding = "utf-8";
		request.setCharacterEncoding(encoding);
		OrderingDTO order = new OrderingDTO();
		MenuService service = new MenuService();
		int menu_code = Integer.parseInt(request.getParameter("menu_code"));
		int member_code = Integer.parseInt(request.getParameter("member_code"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int price = 0;
		try {
			price = quantity * service.getMenuByCode(menu_code).getPrice();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		order.setMenu_code(menu_code);
		order.setMember_code(member_code);
		order.setQuantity(quantity);
		order.setPrice(price);
		return order;
	}

}