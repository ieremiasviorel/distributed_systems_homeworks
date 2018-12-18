package package_tracking_system.assignment_4_2.services.impl;

import package_tracking_system.assignment_4_2.daos.UserDAO;
import package_tracking_system.assignment_4_2.daos.impl.UserDAOImpl;
import package_tracking_system.assignment_4_2.models.User;
import package_tracking_system.assignment_4_2.services.UserService;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	
	public UserServiceImpl() {
		this.userDAO = new UserDAOImpl();
	}
	
	public User login(String username, String password) {
		return this.userDAO.find(username, password);
	}
}
