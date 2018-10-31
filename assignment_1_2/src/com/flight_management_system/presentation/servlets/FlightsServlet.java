package com.flight_management_system.presentation.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;

import com.flight_management_system.business_logic.entities.Flight;
import com.flight_management_system.business_logic.services.CityServiceImpl;
import com.flight_management_system.business_logic.services.FlightServiceImpl;

public class FlightsServlet extends HttpServlet {

	private static final long serialVersionUID = -7505238875102906553L;

	private FlightServiceImpl flightService;
	private CityServiceImpl cityService;
	private HttpClient httpClient;

	@Override
	public void init() {
		this.flightService = new FlightServiceImpl();
		this.cityService = new CityServiceImpl();
		this.httpClient = HttpClientBuilder.create().build();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flightNumber = request.getParameter("flightNumber");
		Flight flight = this.flightService.getByFlightNumber(flightNumber);

		StringBuilder urlBuilder = new StringBuilder();
		urlBuilder.append("https://maps.googleapis.com/maps/api/timezone/json?location=");
		urlBuilder.append(flight.getDepartureCity().getLatitude());
		urlBuilder.append(",");
		urlBuilder.append(flight.getDepartureCity().getLongitude());
		urlBuilder.append("&timestamp=");
		Timestamp departureTimestamp = new Timestamp(
				flight.getDepartureDate().getTime() + flight.getDepartureTime().getTime());
		urlBuilder.append(departureTimestamp.getTime() / 1000);
		// urlBuilder.append("&key=AIzaSyA8igDk0mDmXZJyzlK0gKQ0dZrWGwXZ0ng");
		urlBuilder.append("&key=AIzaSyD9BOYiPPJ3hYvpwMd9xzNqNTFMnaUaNbE");

		String url = urlBuilder.toString();
		HttpGet apiRequest = new HttpGet(url);
		HttpResponse apiResponse = httpClient.execute(apiRequest);
		BufferedReader rd = new BufferedReader(new InputStreamReader(apiResponse.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		JSONObject resultJSON = new JSONObject(result.toString());
		Long rawOffset = resultJSON.getLong("rawOffset");

		JSONObject flightJSON = new JSONObject(flight);
		Timestamp localTimeZoneTimestamp = new Timestamp(departureTimestamp.getTime() + rawOffset * 1000);

		if (apiResponse.getStatusLine().getStatusCode() == 200) {
			flightJSON.put("localDepartureDate", new Date(localTimeZoneTimestamp.getTime()));
			flightJSON.put("localDepartureTime", new Time(localTimeZoneTimestamp.getTime()));

			PrintWriter out = response.getWriter();
			out.println(flightJSON.toString());
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Flight flight = new Flight();
		flight.setFlightNumber(request.getParameter("form-flight-number"));
		flight.setAirplaneType(request.getParameter("form-airplane-type"));
		flight.setDepartureCity(this.cityService.getByName(request.getParameter("form-departure-city")));
		flight.setDepartureDate(Date.valueOf(request.getParameter("form-departure-date")));
		if (request.getParameter("form-departure-time").length() == 5) {
			flight.setDepartureTime(Time.valueOf(request.getParameter("form-departure-time") + ":00"));
		} else {
			flight.setDepartureTime(Time.valueOf(request.getParameter("form-departure-time")));
		}
		flight.setArrivalCity(this.cityService.getByName(request.getParameter("form-arrival-city")));
		flight.setArrivalDate(Date.valueOf(request.getParameter("form-arrival-date")));
		if (request.getParameter("form-arrival-time").length() == 5) {
			flight.setArrivalTime(Time.valueOf(request.getParameter("form-arrival-time") + ":00"));
		} else {
			flight.setArrivalTime(Time.valueOf(request.getParameter("form-arrival-time")));
		}
		if (request.getParameter("form-flight-id") != null && !request.getParameter("form-flight-id").isEmpty()) {
			flight.setId(Long.valueOf(request.getParameter("form-flight-id")));
			this.flightService.updateFlight(flight);
		} else {
			this.flightService.saveFlight(flight);
		}
		response.sendRedirect("/admin");
	}
}
