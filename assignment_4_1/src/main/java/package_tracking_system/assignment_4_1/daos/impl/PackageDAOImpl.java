package package_tracking_system.assignment_4_1.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import package_tracking_system.assignment_4_1.daos.PackageDAO;
import package_tracking_system.assignment_4_1.daos.config.EntityManagerProvider;
import package_tracking_system.assignment_4_1.models.Package;
import package_tracking_system.assignment_4_1.models.User;

public class PackageDAOImpl implements PackageDAO {

	private EntityManagerFactory emf = EntityManagerProvider.getInstance();

	@Override
	public void save(Package _package) {
		EntityManager em = emf.createEntityManager();

		em.persist(_package);

		em.close();
	}

	@Override
	public Package find(Integer id) {
		EntityManager em = emf.createEntityManager();

		Package _package = em.find(Package.class, id);
		em.close();

		return _package;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Package> find(String name) {
		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("SELECT p FROM Pckage p WHERE p.name = :name");
		query.setParameter("name", name);

		List<Package> packages = query.getResultList();
		em.close();

		return packages;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Package> findBySender(User sender) {
		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("SELECT p FROM Package p WHERE p.sender = :sender");
		query.setParameter("sender", sender);

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Package> findByReceiver(User receiver) {
		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("SELECT p FROM Package p WHERE p.receiver = :receiver");
		query.setParameter("receiver", receiver);

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Package> findAll() {
		EntityManager em = emf.createEntityManager();

		Query query = em.createNativeQuery("SELECT * FROM Package p", Package.class);

		return query.getResultList();
	}
}
