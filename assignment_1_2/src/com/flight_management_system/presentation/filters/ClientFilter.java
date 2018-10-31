package com.flight_management_system.presentation.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ClientFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();

		String userRole = (String) session.getAttribute("user_role");
		if (userRole != null)
			if (userRole.equals("CLIENT")) {
				chain.doFilter(request, response);
			} else {
				httpResponse.sendRedirect("access-denied.jsp");
			}
		else {
			httpResponse.sendRedirect("/login");
		}
	}

	@Override
	public void destroy() {
	}
}