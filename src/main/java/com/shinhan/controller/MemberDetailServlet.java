package com.shinhan.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dto.MemberDTO;
import com.shinhan.service.MemberService;
import com.shinhan.util.DateUtil;

@WebServlet("/member/memberDetail.do")
public class MemberDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int member_code = Integer.parseInt( request.getParameter("member_code"));
        try {
			request.setAttribute("member", new MemberService().selectMem(member_code));
		} catch (SQLException e) {
			e.printStackTrace();
		}
        request.getRequestDispatcher("memberDetail.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//String path = request.getRequestURI();
    	
    	String encoding = "utf-8";
		request.setCharacterEncoding(encoding);
    	int member_code = Integer.parseInt(request.getParameter("member_code"));
    	String authority =request.getParameter("authority");
    	String name =request.getParameter("name");
    	String id =request.getParameter("id");
    	String pw =request.getParameter("pw");
    	String contact =request.getParameter("contact");
        Date join_date = DateUtil.getSQLDate(request.getParameter("join_date"));
        
        MemberDTO member = new MemberDTO(member_code, authority, name, id, pw, contact, join_date);
        System.out.println(member);
        int result = new MemberService().memberUpdate(member);
        System.out.println(result + "건 수정");
		request.setAttribute("message", result + "건 수정됨");

		RequestDispatcher rd = 
   				request.getRequestDispatcher("result.jsp");
   	    rd.forward(request, response);
    }
}