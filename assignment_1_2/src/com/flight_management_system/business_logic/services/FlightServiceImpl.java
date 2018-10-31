package com.flight_management_system.business_logic.services;

import java.util.List;

import com.flight_management_system.business_logic.entities.Flight;
import com.flight_management_system.business_logic.utils.FlightFilter;
import com.flight_management_system.data_access.repositories.CityRepository;
import com.flight_management_system.data_access.repositories.FlightRepository;

public class FlightServiceImpl {

	private FlightRepository flightRepository;
	private CityRepository cityRepository;

	public FlightServiceImpl() {
		this.flightRepository = new FlightRepository();
		this.cityRepository = new CityRepository();
	}

	public List<Flight> getAll() {
		return this.flightRepository.findAll();
	}

	public Flight getByFlightNumber(String flightNumber) {
		return this.flightRepository.findByFlightNumber(flightNumber);
	}

	public List<Flight> getByFilter(FlightFilter filter) {
		return this.flightRepository.findByFilter(filter);
	}

	public List<String> getCountriesWithFlights() {
		return this.cityRepository.getCountryList();
	}
	
	public Long saveFlight(Flight flight) {
		return this.flightRepository.add(flight);
	}

	public void updateFlight(Flight flight) {
		this.flightRepository.update(flight);
	}
}
