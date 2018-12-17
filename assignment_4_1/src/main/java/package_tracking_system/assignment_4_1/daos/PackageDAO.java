package package_tracking_system.assignment_4_1.daos;

import java.util.List;

import package_tracking_system.assignment_4_1.models.Package;
import package_tracking_system.assignment_4_1.models.User;

public interface PackageDAO {

	public void save(Package _package);

	public Package find(Integer id);

	public List<Package> find(String name);

	public List<Package> findBySender(User sender);

	public List<Package> findByReceiver(User receiver);

	public List<Package> findAll();
}
