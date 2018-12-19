package package_tracking_system.assignment_4_1.services;

import java.util.List;

import package_tracking_system.assignment_4_1.models.User;

public interface UserService {

	public User login(String username, String password);
	
	public User getUserByUsername(String username);

	public void register(String username, String password, String fullName);
	
	public List<User> getAllUsers();
}
