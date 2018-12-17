package package_tracking_system.assignment_4_1.web_services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import package_tracking_system.assignment_4_1.models.City;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface CityWS {

	@WebMethod
	public boolean addCity(City c);
	
	@WebMethod
	public City getCity(Integer id);
	
	@WebMethod
	public City getCity(String name);
}
