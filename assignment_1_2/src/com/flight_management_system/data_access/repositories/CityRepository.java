package com.flight_management_system.data_access.repositories;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.flight_management_system.business_logic.entities.City;

public class CityRepository {

	private final SessionFactory sessionFactory;

	public CityRepository() {
		this.sessionFactory = SingletonSessionFactory.getInstance();
	}

	public Long add(City cityToAdd) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		Long cityId = null;

		try {
			tx = session.beginTransaction();
			cityId = (Long) session.save(cityToAdd);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			throw new HibernateException(ex);
		} finally {
			session.close();
		}
		return cityId;
	}

	@SuppressWarnings("unchecked")
	public List<City> findAll() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		List<City> cities = null;

		try {
			tx = session.beginTransaction();
			cities = session.createCriteria(City.class).list();
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			throw new HibernateException(ex);
		} finally {
			session.close();
		}
		return cities;
	}

	public City findById(Long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		City city = null;

		try {
			tx = session.beginTransaction();
			city = (City) session.get(City.class, id);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			throw new HibernateException(ex);
		} finally {
			session.close();
		}
		return city;
	}

	public City findByName(String name) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		City city = null;

		try {
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(City.class);
			cr.add(Restrictions.eq("name", name));
			city = (City) cr.uniqueResult();
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			throw new HibernateException(ex);
		} finally {
			session.close();
		}
		return city;
	}

	@SuppressWarnings("unchecked")
	public List<City> findByCountry(String country) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		List<City> cities = null;

		try {
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(City.class);
			cr.add(Restrictions.eq("country", country));
			cities = (List<City>) cr.list();
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			throw new HibernateException(ex);
		} finally {
			session.close();
		}
		return cities;
	}

	@SuppressWarnings("unchecked")
	public List<String> getCountryList() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		List<String> countries = null;

		try {
			tx = session.beginTransaction();
			String hql = "SELECT DISTINCT(C.country) FROM City C";
			Query query = session.createQuery(hql);
			countries = (List<String>) query.list();
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			throw new HibernateException(ex);
		} finally {
			session.close();
		}
		return countries;
	}
}
