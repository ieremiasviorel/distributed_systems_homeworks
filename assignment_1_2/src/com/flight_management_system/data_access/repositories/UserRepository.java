package com.flight_management_system.data_access.repositories;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.flight_management_system.business_logic.entities.User;

public class UserRepository {

	private final SessionFactory sessionFactory;

	public UserRepository() {
		this.sessionFactory = SingletonSessionFactory.getInstance();
	}

	public Long add(User userToAdd) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		Long userId = null;

		try {
			tx = session.beginTransaction();
			userId = (Long) session.save(userToAdd);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			throw new HibernateException(ex);
		} finally {

			session.close();
		}
		return userId;
	}

	public User findById(Long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		User user = null;

		try {
			tx = session.beginTransaction();
			user = (User) session.get(User.class, id);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			throw new HibernateException(ex);
		} finally {
			session.close();
		}
		return user;
	}

	public User findByUsername(String username) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		User user = null;

		try {
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(User.class);
			cr.add(Restrictions.eq("username", username));
			user = (User) cr.uniqueResult();
		} catch (HibernateException ex) {
			tx.rollback();
			throw new HibernateException(ex);
		} finally {
			session.close();
		}
		return user;
	}

	public User findByUsernameAndPassword(String username, String password) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		User user = null;

		try {
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(User.class);
			cr.add(Restrictions.eq("username", username));
			cr.add(Restrictions.eq("password", password));
			user = (User) cr.uniqueResult();
		} catch (HibernateException ex) {
			tx.rollback();
			throw new HibernateException(ex);
		} finally {
			session.close();
		}
		return user;
	}
}
