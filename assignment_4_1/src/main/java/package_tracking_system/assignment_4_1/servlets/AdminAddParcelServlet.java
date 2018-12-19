package package_tracking_system.assignment_4_1.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

import package_tracking_system.assignment_4_1.models.City;
import package_tracking_system.assignment_4_1.models.User;
import package_tracking_system.assignment_4_1.services.CityService;
import package_tracking_system.assignment_4_1.services.UserService;
import package_tracking_system.assignment_4_1.services.impl.CityServiceImpl;
import package_tracking_system.assignment_4_1.services.impl.UserServiceImpl;
import package_tracking_system.assignment_4_2.web_services.impl.ParcelWSImpl;
import package_tracking_system.assignment_4_2.web_services.impl.ParcelWSImplServiceLocator;

@WebServlet("/admin/add-parcel")
public class AdminAddParcelServlet extends HttpServlet {

	private static final long serialVersionUID = -3521990592696607115L;

	private ParcelWSImpl parcelService;
	private UserService userService;
	private CityService cityService;

	@Override
	public void init() {
		ParcelWSImplServiceLocator parcelServiceLocator = new ParcelWSImplServiceLocator();
		try {
			parcelService = parcelServiceLocator.getParcelWSImpl();
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		userService = new UserServiceImpl();
		cityService = new CityServiceImpl();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> users = this.userService.getAllUsers();
		List<City> cities = this.cityService.getAllCities();
		request.setAttribute("allUsers", users);
		request.setAttribute("allCities", cities);

		RequestDispatcher rd = request.getRequestDispatcher("/admin-add-parcel.jsp");
		rd.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		
		String senderName = request.getParameter("sender");
		String receiverName = request.getParameter("receiver");
		
		String senderCityName = request.getParameter("senderCity");
		String receiverCityName = request.getParameter("receiverCity");
		
		parcelService.addParcel(name, description, senderName, receiverName, senderCityName, receiverCityName);
		
		response.sendRedirect("/assignment_4_1/admin");
	}
}
