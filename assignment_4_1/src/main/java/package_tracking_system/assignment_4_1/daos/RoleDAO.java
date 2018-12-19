package package_tracking_system.assignment_4_1.daos;

import package_tracking_system.assignment_4_1.models.Role;

public interface RoleDAO {

	public Role find(Integer id);

	public Role find(String name);
}
