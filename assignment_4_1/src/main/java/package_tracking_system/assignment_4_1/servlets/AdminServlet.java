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
import javax.xml.rpc.ServiceException;

import package_tracking_system.assignment_4_2.models.Parcel;
import package_tracking_system.assignment_4_2.web_services.impl.ParcelWSImpl;
import package_tracking_system.assignment_4_2.web_services.impl.ParcelWSImplServiceLocator;

@WebServlet("/admin")
//@ServletSecurity(value = @HttpConstraint(rolesAllowed = { "ADMIN" }))
public class AdminServlet extends HttpServlet {

	private static final long serialVersionUID = 5575507490396958636L;

	private ParcelWSImpl parcelService;

	@Override
	public void init() {
		ParcelWSImplServiceLocator parcelServiceLocator = new ParcelWSImplServiceLocator();
		try {
			parcelService = parcelServiceLocator.getParcelWSImpl();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Parcel> parcels = new ArrayList<Parcel>();
		for (Parcel p : parcelService.getParcels()) {
			parcels.add(p);
		}
		request.setAttribute("allParcels", parcels);

		RequestDispatcher rd = request.getRequestDispatcher("/admin-home.jsp");
		rd.forward(request, response);
	}
}
