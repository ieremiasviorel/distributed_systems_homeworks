package com.flight_management_system.data_access.repositories;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.flight_management_system.business_logic.entities.Flight;
import com.flight_management_system.business_logic.utils.FlightFilter;

public class FlightRepository {

	private final SessionFactory sessionFactory;

	public FlightRepository() {
		this.sessionFactory = SingletonSessionFactory.getInstance();
	}

	public Long add(Flight flightToAdd) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		Long flightId = null;

		try {
			tx = session.beginTransaction();
			flightId = (Long) session.save(flightToAdd);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			throw new HibernateException(ex);
		} finally {
			session.close();
		}
		return flightId;
	}

	@SuppressWarnings("unchecked")
	public List<Flight> findAll() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		List<Flight> flights = null;

		try {
			tx = session.beginTransaction();
			flights = session.createCriteria(Flight.class).list();
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			throw new HibernateException(ex);
		} finally {
			session.close();
		}
		return flights;
	}

	public Flight findById(Long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		Flight flight = null;

		try {
			tx = session.beginTransaction();
			flight = (Flight) session.get(Flight.class, id);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			throw new HibernateException(ex);
		} finally {
			session.close();
		}
		return flight;
	}

	public Flight findByFlightNumber(String flightNumber) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		Flight flight = null;

		try {
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Flight.class);
			cr.add(Restrictions.eq("flightNumber", flightNumber));
			flight = (Flight) cr.uniqueResult();
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			throw new HibernateException(ex);
		} finally {
			session.close();
		}
		return flight;
	}

	@SuppressWarnings("unchecked")
	public List<Flight> findByFilter(FlightFilter filter) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		List<Flight> flights = null;

		try {
			tx = session.beginTransaction();
			String hql = "FROM Flight F";
			boolean addWhereKeyWord = true;

			if (filter.getDepartureCountry() != null && !filter.getDepartureCountry().isEmpty()) {
				hql += " WHERE F.departureCity.country = '" + filter.getDepartureCountry() + "'";
				addWhereKeyWord = false;
			}
			if (filter.getDepartureCity() != null && !filter.getDepartureCity().isEmpty()) {
				if (addWhereKeyWord) {
					hql += " WHERE F.departureCity.name = '" + filter.getDepartureCity() + "'";
					addWhereKeyWord = false;
				} else {
					hql += " AND F.departureCity.name = '" + filter.getDepartureCity() + "'";
				}
			}
			if (filter.getArrivalCountry() != null && !filter.getArrivalCountry().isEmpty()) {
				if (addWhereKeyWord) {
					hql += " WHERE F.arrivalCity.country = '" + filter.getArrivalCountry() + "'";
					addWhereKeyWord = false;
				} else {
					hql += " AND F.arrivalCity.country = '" + filter.getArrivalCountry() + "'";
				}
			}
			if (filter.getArrivalCity() != null && !filter.getArrivalCity().isEmpty()) {
				if (addWhereKeyWord) {
					hql += " WHERE F.arrivalCity.name = '" + filter.getArrivalCity() + "'";
					addWhereKeyWord = false;
				} else {
					hql += " AND F.arrivalCity.name = '" + filter.getArrivalCity() + "'";
				}
			}
			if (filter.getDepartureStartDate() != null) {
				if (addWhereKeyWord) {
					hql += " WHERE F.departureDate > '" + filter.getDepartureStartDate() + "'";
					addWhereKeyWord = false;
				} else {
					hql += " AND F.departureDate > '" + filter.getDepartureStartDate() + "'";
				}
			}
			if (filter.getDepartureEndDate() != null) {
				if (addWhereKeyWord) {
					hql += " WHERE F.departureDate < '" + filter.getDepartureEndDate() + "'";
					addWhereKeyWord = false;
				} else {
					hql += " AND F.departureDate < '" + filter.getDepartureEndDate() + "'";
				}
			}

			Query query = session.createQuery(hql);
			flights = (List<Flight>) query.list();
			tx.commit();

		} catch (HibernateException ex) {
			tx.rollback();
			throw new HibernateException(ex);
		} finally {
			session.close();
		}
		return flights;
	}

	public void update(Flight updatedFlight) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			
			session.update(updatedFlight);
			
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			throw new HibernateException(ex);
		} finally {
			session.close();
		}
	}
}