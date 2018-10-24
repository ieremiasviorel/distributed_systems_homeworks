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

public class AuthorizationFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();

		StringBuffer url = httpRequest.getRequestURL();
		String applicationSubDomain = url.toString().split("/")[2].toUpperCase();

		String userPermission = (String) session.getAttribute("user_authority");

		if (applicationSubDomain.equals("CLIENT") || applicationSubDomain.equals("ADMIN")) {
			if (applicationSubDomain.toUpperCase().equals(userPermission)) {
				chain.doFilter(request, response);
			} else {
				httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
				httpResponse.sendRedirect("access-denied.jsp");
			}
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
