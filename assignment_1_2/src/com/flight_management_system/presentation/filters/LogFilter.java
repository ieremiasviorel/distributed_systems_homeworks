package com.flight_management_system.presentation.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();

		System.out.println(">>>>>>>>>>");
		System.out.println("Request URL: " + httpRequest.getRequestURL());
		System.out.println("Request method: " + httpRequest.getMethod());
		System.out.println("Session ID: " + session.getId());
		System.out.println("User: " + session.getAttribute("user"));
		System.out.println("Granted authorities: " + session.getAttribute("user_authority"));
		System.out.println("<<<<<<<<<<");

		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
}
