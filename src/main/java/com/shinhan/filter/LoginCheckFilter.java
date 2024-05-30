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

@WebFilter("*.do")
public class LoginCheckFilter extends HttpFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 로그인하지않으면 업무로직 수행못함
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse rep = (HttpServletResponse)response;
		
		if(!(req.getRequestURI().endsWith("login.do") || req.getRequestURI().endsWith("join.do") || req.getRequestURI().endsWith("userIdCheck.do"))) {
			HttpSession session = req.getSession();
			MemberDTO emp = (MemberDTO) session.getAttribute("loginMem");
			if(emp == null) {
				//로그인되어있지않으면 로그인으로 재요청
				rep.sendRedirect("../auth/login.do");
				return;
			}
		}
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}
