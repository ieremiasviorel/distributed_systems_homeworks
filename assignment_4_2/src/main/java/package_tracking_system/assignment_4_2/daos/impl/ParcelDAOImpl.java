package package_tracking_system.assignment_4_2.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import package_tracking_system.assignment_4_2.daos.ParcelDAO;
import package_tracking_system.assignment_4_2.daos.config.EntityManagerProvider;
import package_tracking_system.assignment_4_2.models.Parcel;
import package_tracking_system.assignment_4_2.models.User;

public class ParcelDAOImpl implements ParcelDAO {

	private EntityManagerFactory emf = EntityManagerProvider.getInstance();

	@Override
	public void save(Parcel parcel) {
		EntityManager em = emf.createEntityManager();

		em.persist(parcel);

		em.close();
	}

	@Override
	public Parcel find(Integer id) {
		EntityManager em = emf.createEntityManager();

		Parcel _package = em.find(Parcel.class, id);
		em.close();

		return _package;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Parcel> find(String name) {
		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("SELECT p FROM Parcel p WHERE p.name = :name");
		query.setParameter("name", name);

		List<Parcel> packages = query.getResultList();
		em.close();

		return packages;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Parcel> findBySender(User sender) {
		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("SELECT p FROM Parcel p WHERE p.sender = :sender");
		query.setParameter("sender", sender);

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Parcel> findByReceiver(User receiver) {
		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("SELECT p FROM Parcel p WHERE p.receiver = :receiver");
		query.setParameter("receiver", receiver);

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Parcel> findAll() {
		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("SELECT p FROM Parcel p");

		return query.getResultList();
	}
}
