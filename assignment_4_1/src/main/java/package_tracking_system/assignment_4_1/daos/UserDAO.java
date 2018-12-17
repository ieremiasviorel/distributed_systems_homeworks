package package_tracking_system.assignment_4_1.daos;

import java.util.List;

import package_tracking_system.assignment_4_1.models.User;

public interface UserDAO {

	public void save(User user);
	
	public User find(Integer id);
	
	public User find(String username);
	
	public User find(String username, String password);
	
	public List<User> findAll();
}
