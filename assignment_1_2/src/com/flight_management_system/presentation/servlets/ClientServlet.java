package com.flight_management_system.presentation.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flight_management_system.business_logic.services.UserServiceImpl;

public class ClientServlet extends HttpServlet {

	private static final long serialVersionUID = 183010968341969780L;

	private UserServiceImpl userService;

	@Override
	public void init() {
		this.userService = new UserServiceImpl();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("client-home.jsp");
		rd.forward(request, response);
	}
}