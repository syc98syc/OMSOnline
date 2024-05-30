package com.shinhan.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dto.MemberDTO;
import com.shinhan.service.MemberService;

@WebServlet("/auth/join.do")
public class MemberJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		RequestDispatcher rd;
		rd = request.getRequestDispatcher("join.jsp");
		rd.forward(request, response);
   	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDTO mem = makeMem(request);
		MemberService service = new MemberService();
		//System.out.println(mem);
		int result = service.memberInsert(mem);
		System.out.println(result + "건 입력됨");
		request.setAttribute("message", result + "건 회원가입 성공!");

		//1)JSP에 응답을 위임하는 경우 (MVC2모델)
		RequestDispatcher rd = 
   				request.getRequestDispatcher("result.jsp");
   	    rd.forward(request, response);
   	    
	}
	private MemberDTO makeMem(HttpServletRequest request) throws UnsupportedEncodingException {
		
		String encoding = "utf-8";
		request.setCharacterEncoding(encoding);
		MemberDTO mem = new MemberDTO();
		String name = request.getParameter("name");
		String id = request.getParameter("uid");
		String pw = request.getParameter("pw");
		String contact = request.getParameter("contact");
		
		
		mem.setName(name);
		mem.setId(id);
		mem.setPw(pw);
		mem.setContact(contact);
		return mem;
	}
}
