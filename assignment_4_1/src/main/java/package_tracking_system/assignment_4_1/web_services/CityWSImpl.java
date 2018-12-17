package package_tracking_system.assignment_4_1.web_services;

import javax.jws.WebService;

import package_tracking_system.assignment_4_1.daos.CityDAO;
import package_tracking_system.assignment_4_1.daos.impl.CityDAOImpl;
import package_tracking_system.assignment_4_1.models.City;

@WebService(endpointInterface = "package_tracking_system.assignment_4_1.web_services.CityWS")
public class CityWSImpl implements CityWS {

	private CityDAO cityDAO = new CityDAOImpl();
	
	@Override
	public boolean addCity(City c) {
		cityDAO.save(c);
		return true;
	}

	@Override
	public City getCity(Integer id) {
		return cityDAO.find(id);
	}

	@Override
	public City getCity(String name) {
		return cityDAO.find(name);
	}
}
