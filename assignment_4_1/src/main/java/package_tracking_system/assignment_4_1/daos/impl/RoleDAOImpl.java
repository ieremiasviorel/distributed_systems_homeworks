package package_tracking_system.assignment_4_1.daos.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import package_tracking_system.assignment_4_1.daos.RoleDAO;
import package_tracking_system.assignment_4_1.daos.config.EntityManagerProvider;
import package_tracking_system.assignment_4_1.models.Role;

public class RoleDAOImpl implements RoleDAO {

	private EntityManagerFactory emf = EntityManagerProvider.getInstance();
	
	@Override
	public Role find(Integer id) {
		EntityManager em = emf.createEntityManager();

		Role role = em.find(Role.class, id);
		em.close();

		return role;
	}

	@Override
	public Role find(String name) {
		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("SELECT r FROM Role r WHERE r.name = :name");
		query.setParameter("name", name);

		Role role = (Role) query.getSingleResult();
		em.close();

		return role;
	}
}
