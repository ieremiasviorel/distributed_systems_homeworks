package com.flight_management_system.presentation.servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flight_management_system.business_logic.entities.City;
import com.flight_management_system.business_logic.entities.Flight;
import com.flight_management_system.business_logic.services.CityServiceImpl;
import com.flight_management_system.business_logic.services.FlightServiceImpl;
import com.flight_management_system.business_logic.utils.FlightFilter;

public class AdminServlet extends HttpServlet {

	private static final long serialVersionUID = -3227831816606276654L;

	private FlightServiceImpl flightService;
	private CityServiceImpl cityService;

	@Override
	public void init() {
		this.flightService = new FlightServiceImpl();
		this.cityService = new CityServiceImpl();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/admin-home.jsp");

		List<Flight> flights = this.flightService.getAll();
		request.setAttribute("flights", flights);

		List<String> countries = this.flightService.getCountriesWithFlights();
		request.setAttribute("countries", countries);

		rd.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		FlightFilter flightFilter = new FlightFilter();

		flightFilter.setDepartureCountry(request.getParameter("departure_country"));
		flightFilter.setDepartureCity(request.getParameter("departure_city"));
		flightFilter.setArrivalCountry(request.getParameter("arrival_country"));
		flightFilter.setArrivalCity(request.getParameter("arrival_city"));
		String departureDateStartStr = request.getParameter("departure_date_start");
		if (departureDateStartStr != null && !departureDateStartStr.isEmpty()) {
			flightFilter.setDepartureStartDate(Date.valueOf(departureDateStartStr));
		}
		String departureDateEndStr = request.getParameter("departure_date_end");
		if (departureDateEndStr != null && !departureDateEndStr.isEmpty()) {
			flightFilter.setDepartureEndDate(Date.valueOf(departureDateEndStr));
		}
		request.setAttribute("flightFilter", flightFilter);

		List<String> countries = this.flightService.getCountriesWithFlights();
		request.setAttribute("countries", countries);

		if (flightFilter.getDepartureCountry() != null && !flightFilter.getDepartureCountry().isEmpty()) {
			List<City> departureCities = this.cityService.getByCountry(flightFilter.getDepartureCountry());
			request.setAttribute("departureCities", departureCities);
		} else {
			request.setAttribute("departureCities", null);
		}

		if (flightFilter.getArrivalCountry() != null && !flightFilter.getArrivalCountry().isEmpty()) {
			List<City> arrivalCities = this.cityService.getByCountry(flightFilter.getArrivalCountry());
			request.setAttribute("arrivalCities", arrivalCities);
		} else {
			request.setAttribute("arrivalCities", null);
		}

		List<Flight> flights = this.flightService.getByFilter(flightFilter);
		request.setAttribute("flights", flights);

		RequestDispatcher rd = request.getRequestDispatcher("/admin-home.jsp");
		rd.forward(request, response);
	}
}