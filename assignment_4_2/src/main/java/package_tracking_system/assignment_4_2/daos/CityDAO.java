package package_tracking_system.assignment_4_2.daos;

import java.util.List;

import package_tracking_system.assignment_4_2.models.City;

public interface CityDAO {
	
	public void save(City city);
	
	public City find(Integer id);
	
	public City find(String name);
	
	public List<City> findAll();
}
