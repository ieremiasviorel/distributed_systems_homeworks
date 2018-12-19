package package_tracking_system.assignment_4_2.services;

import java.util.List;

import package_tracking_system.assignment_4_2.models.User;

public interface UserService {

	public User login(String username, String password);
	
	public User getUserByUsername(String username);
	
	public List<User> getAllUsers();
}
