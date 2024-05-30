package com.shinhan.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.dto.MemberDTO;

@WebFilter("*.go")
public class AutorityCheckFilter extends HttpFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 관리자계정확인
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse rep = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		MemberDTO emp = (MemberDTO) session.getAttribute("loginMem");
		if(emp == null) {
			//로그인되어있지않으면 로그인으로 재요청
			rep.sendRedirect("../auth/login.do");
			return;
		}else if(!emp.getAuthority().equals("Y")) {
			//관리자 계정 확인
			rep.sendRedirect("../auth/authorityCheck.do");
			return;
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}
