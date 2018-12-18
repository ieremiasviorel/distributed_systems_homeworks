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
import javax.servlet.http.HttpSession;

import package_tracking_system.assignment_4_1.services.ParcelService;
import package_tracking_system.assignment_4_1.services.impl.ParcelServiceImpl;
import package_tracking_system.assignment_4_1.models.Parcel;

@WebServlet("/client")
//@ServletSecurity(value = @HttpConstraint(rolesAllowed = { "CLIENT" }))
public class ClientServlet extends HttpServlet {

	private static final long serialVersionUID = 5575507490396958636L;

	private ParcelService packageService;

	@Override
	public void init() {
		this.packageService = new ParcelServiceImpl();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String loggedInUsername = (String) session.getAttribute("username");

		List<Parcel> clientPackages = new ArrayList<Parcel>();
		for (Parcel p : this.packageService.getBySender(loggedInUsername)) {
			clientPackages.add(p);
		}
		for (Parcel p : this.packageService.getByReceiver(loggedInUsername)) {
			clientPackages.add(p);
		}
		request.setAttribute("clientPackages", clientPackages);

		RequestDispatcher rd = request.getRequestDispatcher("/client-home.jsp");
		rd.forward(request, response);
	}
}
