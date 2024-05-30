package com.shinhan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dto.MemberDTO;
import com.shinhan.service.MemberService;


@WebServlet("/auth/userIdCheck.do")
public class UserIdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		
		MemberService service = new MemberService();
		MemberDTO mem = service.selectById(uid);
		String message = "1";
		if(mem==null) {
			message="0";
		}
		//response.setCharacterEncoding("utf-8");
		response.getWriter().append(message);
	}
}
