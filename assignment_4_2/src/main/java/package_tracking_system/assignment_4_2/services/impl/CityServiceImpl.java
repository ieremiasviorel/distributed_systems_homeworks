package package_tracking_system.assignment_4_2.services.impl;

import java.util.List;

import package_tracking_system.assignment_4_2.daos.CityDAO;
import package_tracking_system.assignment_4_2.daos.impl.CityDAOImpl;
import package_tracking_system.assignment_4_2.models.City;
import package_tracking_system.assignment_4_2.services.CityService;

public class CityServiceImpl implements CityService {

	private CityDAO cityDAO;
	
	public CityServiceImpl() {
		this.cityDAO = new CityDAOImpl();
	}
	
	@Override
	public City getCityByName(String name) {
		return this.cityDAO.find(name);
	}
	
	@Override
	public List<City> getAllCities() {
		return this.cityDAO.findAll();
	}

}
