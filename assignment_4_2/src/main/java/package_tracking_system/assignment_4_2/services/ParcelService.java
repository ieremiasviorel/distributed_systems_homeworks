package package_tracking_system.assignment_4_2.services;

import java.util.List;

import package_tracking_system.assignment_4_2.models.Parcel;;

public interface ParcelService {
	
	public void add(Parcel parcel);

	public Parcel getById(Integer id);
	
	public List<Parcel> getBySender(String senderUsername);

	public List<Parcel> getByReceiver(String receiverUsername);
	
	public List<Parcel> getAll();
}
