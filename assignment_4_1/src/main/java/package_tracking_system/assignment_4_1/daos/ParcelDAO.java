package package_tracking_system.assignment_4_1.daos;

import java.util.List;

import package_tracking_system.assignment_4_1.models.Parcel;
import package_tracking_system.assignment_4_1.models.User;

public interface ParcelDAO {

	public void save(Parcel _package);

	public Parcel find(Integer id);

	public List<Parcel> find(String name);

	public List<Parcel> findBySender(User sender);

	public List<Parcel> findByReceiver(User receiver);

	public List<Parcel> findAll();
}
