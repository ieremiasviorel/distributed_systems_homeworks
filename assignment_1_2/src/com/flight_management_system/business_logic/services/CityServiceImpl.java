package com.flight_management_system.business_logic.services;

import java.util.List;

import com.flight_management_system.business_logic.entities.City;
import com.flight_management_system.data_access.repositories.CityRepository;

public class CityServiceImpl {

	private CityRepository cityRepository;
	
	public CityServiceImpl() {
		this.cityRepository = new CityRepository();
	}

	public City getByName(String name) {
		return this.cityRepository.findByName(name);
	}
	
	public List<City> getAll() {
		return this.cityRepository.findAll();
	}

	public List<City> getByCountry(String country) {
		return this.cityRepository.findByCountry(country);
	}
}
