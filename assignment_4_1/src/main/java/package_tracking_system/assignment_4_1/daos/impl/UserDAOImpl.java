package package_tracking_system.assignment_4_1.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import package_tracking_system.assignment_4_1.daos.UserDAO;
import package_tracking_system.assignment_4_1.daos.config.EntityManagerProvider;
import package_tracking_system.assignment_4_1.models.User;

public class UserDAOImpl implements UserDAO {

	private EntityManagerFactory emf = EntityManagerProvider.getInstance();

	@Override
	public void save(User user) {
		EntityManager em = emf.createEntityManager();

		em.persist(user);

		em.close();
	}

	@Override
	public User find(Integer id) {
		EntityManager em = emf.createEntityManager();

		User user = em.find(User.class, id);

		em.close();
		return user;
	}

	@Override
	public User find(String username) {
		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("SELECT u FROM User u WHERE u.username = :username");
		query.setParameter("username", username);

		User user = (User) query.getSingleResult();
		em.close();

		return user;
	}

	@Override
	public User find(String username, String password) {
		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password");
		query.setParameter("username", username);
		query.setParameter("password", password);

		User user = (User) query.getSingleResult();
		em.close();

		return user;
	}

	@Override
	public List<User> findAll() {
		EntityManager em = emf.createEntityManager();

		List<User> users = null;

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> from = cq.from(User.class);
		CriteriaQuery<User> all = cq.select(from);
		TypedQuery<User> allQuery = em.createQuery(all);

		users = allQuery.getResultList();
		return users;
	}
}
