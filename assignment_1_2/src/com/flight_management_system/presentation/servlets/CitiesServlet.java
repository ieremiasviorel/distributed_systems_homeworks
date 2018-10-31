package com.flight_management_system.presentation.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flight_management_system.business_logic.entities.City;
import com.flight_management_system.business_logic.services.CityServiceImpl;

public class CitiesServlet extends HttpServlet {

	private static final long serialVersionUID = -2649091256199178934L;

	private CityServiceImpl cityService;

	@Override
	public void init() throws ServletException {
		this.cityService = new CityServiceImpl();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String country = request.getParameter("country");
		System.out.println(country);
		List<City> citiesByCountry = this.cityService.getByCountry(country);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String textResponse = "";
		for (City c : citiesByCountry) {
			textResponse += "\"" + c.getName() + "\", ";
		}
		textResponse = "[" + textResponse.substring(0, textResponse.length() - 2) + "]";
		out.println(textResponse);
	}

	@Override
	public void destroy() {
	}
}