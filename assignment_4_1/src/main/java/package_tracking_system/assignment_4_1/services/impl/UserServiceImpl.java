package package_tracking_system.assignment_4_1.services.impl;

import java.util.List;

import package_tracking_system.assignment_4_1.daos.RoleDAO;
import package_tracking_system.assignment_4_1.daos.UserDAO;
import package_tracking_system.assignment_4_1.daos.impl.RoleDAOImpl;
import package_tracking_system.assignment_4_1.daos.impl.UserDAOImpl;
import package_tracking_system.assignment_4_1.models.Role;
import package_tracking_system.assignment_4_1.models.User;
import package_tracking_system.assignment_4_1.services.UserService;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	private RoleDAO roleDAO;
	
	public UserServiceImpl() {
		this.userDAO = new UserDAOImpl();
		this.roleDAO = new RoleDAOImpl();
	}
	
	@Override
	public User login(String username, String password) {
		return this.userDAO.find(username, password);
	}
	
	@Override
	public User getUserByUsername(String username) {
		return this.userDAO.find(username);
	}
	
	@Override
	public void register(String username, String password, String fullName) { 
		User user = new User(username, password, fullName);
		Role role = roleDAO.find("CLIENT");
		user.setRole(role);
		
		userDAO.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return this.userDAO.findAll();
	}
}
