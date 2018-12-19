package package_tracking_system.assignment_4_1.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import package_tracking_system.assignment_4_1.services.UserService;
import package_tracking_system.assignment_4_1.services.impl.UserServiceImpl;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = -9089607621431386895L;

	private UserService userService;

	@Override
	public void init() {
		this.userService = new UserServiceImpl();
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/register.jsp");
		rd.forward(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String fullname = request.getParameter("fullname");
		
		userService.register(username, password, fullname);
		
		response.sendRedirect("/assignment_4_1/");
	}
}
