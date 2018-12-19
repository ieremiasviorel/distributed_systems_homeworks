package package_tracking_system.assignment_4_1.services;

import java.util.List;

import package_tracking_system.assignment_4_1.models.City;

public interface CityService {

	public City getCityByName(String name);
	
	public List<City> getAllCities();
}
