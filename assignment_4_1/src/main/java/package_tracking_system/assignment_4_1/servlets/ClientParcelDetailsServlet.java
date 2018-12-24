package package_tracking_system.assignment_4_1.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import package_tracking_system.assignment_4_1.models.City;
import package_tracking_system.assignment_4_1.models.Parcel;
import package_tracking_system.assignment_4_1.services.CityService;
import package_tracking_system.assignment_4_1.services.ParcelService;
import package_tracking_system.assignment_4_1.services.impl.CityServiceImpl;
import package_tracking_system.assignment_4_1.services.impl.ParcelServiceImpl;

@WebServlet("/client/parcel-details")
public class ClientParcelDetailsServlet extends HttpServlet {

	private static final long serialVersionUID = 616227739581218783L;

	private ParcelService packageService;
	private CityService cityService;

	@Override
	public void init() {
		this.packageService = new ParcelServiceImpl();
		this.cityService = new CityServiceImpl();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer parcelId = Integer.valueOf(request.getParameter("id"));

		Parcel parcel = packageService.getById(parcelId);

		request.setAttribute("parcel", parcel);

		List<City> cities = new ArrayList<City>();
		if (parcel.getDelivery() != null && parcel.getDelivery().getRoute() != null) {
			for (String idAsString : parcel.getDelivery().getRoute().split(", ")) {
				cities.add(cityService.getCityById(Integer.valueOf(idAsString)));
			}
		}

		request.setAttribute("routeCities", cities);

		RequestDispatcher rd = request.getRequestDispatcher("/client-parcel-details.jsp");
		rd.forward(request, response);
	}
}
