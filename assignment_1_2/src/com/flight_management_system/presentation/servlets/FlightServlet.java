package com.flight_management_system.presentation.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flight_management_system.business_logic.services.FlightServiceImpl;

public class FlightServlet extends HttpServlet {

	private static final long serialVersionUID = -2649091256199178934L;

	private FlightServiceImpl flightService;

	@Override
	public void init() throws ServletException {
		this.flightService = new FlightServiceImpl();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.println("<h2>There are " + this.flightService.getAllFlights().size() + " flights available for you!");
	}

	@Override
	public void destroy() {
	}
}