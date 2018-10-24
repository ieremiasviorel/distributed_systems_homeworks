package com.flight_management_system.business_logic.services;

import java.util.List;

import com.flight_management_system.business_logic.entities.Flight;
import com.flight_management_system.data_access.repositories.FlightRepository;

public class FlightServiceImpl {

	private FlightRepository flightDAO;

	public FlightServiceImpl() {
		this.flightDAO = new FlightRepository();
	}

	public List<Flight> getAllFlights() {
		return this.flightDAO.findAll();
	}
}
