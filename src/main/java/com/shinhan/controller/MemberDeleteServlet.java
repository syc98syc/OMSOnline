package com.shinhan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.service.MemberService;

@WebServlet("/member/memberDelete.do")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int member_code = Integer.parseInt(request.getParameter("member_code"));
		int result = new MemberService().memberDeleteByCode(member_code);
		System.out.println(result + "건 삭제됨");
		
		HttpSession session = request.getSession();
		session.invalidate(); //setAttribute()한 내용이 모두 제거된다.
		response.sendRedirect("../index.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}