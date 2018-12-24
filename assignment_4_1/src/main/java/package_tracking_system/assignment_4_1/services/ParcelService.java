package package_tracking_system.assignment_4_1.services;

import java.util.List;

import package_tracking_system.assignment_4_1.models.Parcel;

public interface ParcelService {
	
	public Parcel getById(Integer id);

	public List<Parcel> getBySender(String senderUsername);
	
	public List<Parcel> getByReceiver(String receiverUsername);
}
