package package_tracking_system.assignment_4_1.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import package_tracking_system.assignment_4_1.models.Role;
import package_tracking_system.assignment_4_1.models.User;
import package_tracking_system.assignment_4_1.services.UserService;
import package_tracking_system.assignment_4_1.services.impl.UserServiceImpl;

@WebServlet("/")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 2094807164771303725L;

	private UserService userService;

	@Override
	public void init() {
		this.userService = new UserServiceImpl();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
		rd.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User user = userService.login(username, password);
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user.getUsername());
			Role grantedAuthority = user.getRole();
			session.setAttribute("username", user.getUsername());
			session.setAttribute("user_role", grantedAuthority);
			session.setMaxInactiveInterval(30 * 60);
			if (grantedAuthority.getName().equals("ADMIN")) {
				response.sendRedirect("/assignment_4_1/admin");
			} else if (grantedAuthority.getName().equals("CLIENT")) {
				response.sendRedirect("/assignment_4_1/client");
			}
		} else {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			response.sendRedirect("assignment_4_1/");
		}
	}
}
