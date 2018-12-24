package package_tracking_system.assignment_4_1.services.impl;

import java.util.List;

import package_tracking_system.assignment_4_1.daos.ParcelDAO;
import package_tracking_system.assignment_4_1.daos.UserDAO;
import package_tracking_system.assignment_4_1.daos.impl.ParcelDAOImpl;
import package_tracking_system.assignment_4_1.daos.impl.UserDAOImpl;
import package_tracking_system.assignment_4_1.models.Parcel;
import package_tracking_system.assignment_4_1.models.User;
import package_tracking_system.assignment_4_1.services.ParcelService;

public class ParcelServiceImpl implements ParcelService {

	private UserDAO userDAO;
	private ParcelDAO packageDAO;
	
	public ParcelServiceImpl() {
		this.userDAO = new UserDAOImpl();
		this.packageDAO = new ParcelDAOImpl();
	}

	@Override
	public Parcel getById(Integer id) {
		return this.packageDAO.find(id);
	}
	
	@Override
	public List<Parcel> getBySender(String senderUsername) {
		User user = this.userDAO.find(senderUsername);
		return this.packageDAO.findBySender(user);
	}

	@Override
	public List<Parcel> getByReceiver(String receiverUsername) {
		User user = this.userDAO.find(receiverUsername);
		return this.packageDAO.findByReceiver(user);
	}

}
