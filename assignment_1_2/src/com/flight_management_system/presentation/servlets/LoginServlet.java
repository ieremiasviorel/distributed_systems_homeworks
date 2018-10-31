package com.flight_management_system.presentation.servlets;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flight_management_system.business_logic.entities.User;
import com.flight_management_system.business_logic.services.UserServiceImpl;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 6682699885820337872L;

	private UserServiceImpl userService;

	@Override
	public void init() {
		this.userService = new UserServiceImpl();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
		rd.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User user = userService.findForAuthentication(username, password);
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user.getUsername());
			List<String> grantedAuthorities = user.getRoles().stream().map(role -> role.getName())
					.collect(Collectors.toList());
			session.setAttribute("user_role", grantedAuthorities.get(0));
			session.setMaxInactiveInterval(30 * 60);
			if (grantedAuthorities.contains("ADMIN")) {
				response.sendRedirect("/admin");
			} else if (grantedAuthorities.contains("CLIENT")) { 
				response.sendRedirect("/client");
			}
		} else {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			response.sendRedirect("/login");
		}
	}
}