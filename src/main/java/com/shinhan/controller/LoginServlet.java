package com.shinhan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.dto.MemberDTO;
import com.shinhan.service.MemberService;

@WebServlet("/auth/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자가 입력한 ID, pass검사
		MemberService service = new MemberService();
		String id= request.getParameter("id");
		String pw = request.getParameter("pw");
				
		MemberDTO mem = service.loginChk(id, pw);
		if(mem==null || mem.getMember_code()==-1) {
			request.setAttribute("message", "존재하지않는 ID입니다.");
		}else if(mem.getMember_code()==-2) {
			request.setAttribute("message", "비밀번호오류");
		}else {
			//로그인성공
			HttpSession session = request.getSession();
			//LoginImpl loginUser = new LoginImpl(id, pw);

			//session.setAttribute("loginUser", loginUser);
			session.setAttribute("loginMem", mem);
			
			String lastAddress = (String)session.getAttribute("lastRequest");
            if(lastAddress==null || lastAddress.length()==0) {
                lastAddress = getServletContext().getContextPath();
            }
            //System.out.println(lastAddress);
            String authority = mem.getAuthority();
            if(authority.equals("Y")) {
            	response.sendRedirect(lastAddress+"/main/managerMain.go");    
            }else {
            	response.sendRedirect(lastAddress+"/main/regularUserMain.do");            	
            }
            return;
		}
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}
}
