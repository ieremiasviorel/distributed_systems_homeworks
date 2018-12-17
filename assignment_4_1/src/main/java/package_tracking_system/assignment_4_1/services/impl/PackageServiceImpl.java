package package_tracking_system.assignment_4_1.services.impl;

import java.util.List;

import package_tracking_system.assignment_4_1.daos.PackageDAO;
import package_tracking_system.assignment_4_1.daos.UserDAO;
import package_tracking_system.assignment_4_1.daos.impl.PackageDAOImpl;
import package_tracking_system.assignment_4_1.daos.impl.UserDAOImpl;
import package_tracking_system.assignment_4_1.models.Package;
import package_tracking_system.assignment_4_1.models.User;
import package_tracking_system.assignment_4_1.services.PackageService;

public class PackageServiceImpl implements PackageService {

	private UserDAO userDAO;
	private PackageDAO packageDAO;
	
	public PackageServiceImpl() {
		this.userDAO = new UserDAOImpl();
		this.packageDAO = new PackageDAOImpl();
	}
	
	@Override
	public List<Package> getBySender(String senderUsername) {
		User user = this.userDAO.find(senderUsername);
		return this.packageDAO.findBySender(user);
	}

	@Override
	public List<Package> getByReceiver(String receiverUsername) {
		User user = this.userDAO.find(receiverUsername);
		return this.packageDAO.findByReceiver(user);
	}

}
