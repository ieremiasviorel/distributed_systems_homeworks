package package_tracking_system.assignment_4_1.services;

import java.util.List;

import package_tracking_system.assignment_4_1.models.Package;

public interface PackageService {

	public List<Package> getBySender(String senderUsername);
	
	public List<Package> getByReceiver(String receiverUsername);
}
