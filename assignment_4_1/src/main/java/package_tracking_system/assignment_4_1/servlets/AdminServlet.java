package package_tracking_system.assignment_4_1.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin")
//@ServletSecurity(value = @HttpConstraint(rolesAllowed = { "ADMIN" }))
public class AdminServlet extends HttpServlet {

	private static final long serialVersionUID = 5575507490396958636L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/admin-home.jsp");
		rd.forward(request, response);
	}
}
