package com.flight_management_system.data_access.repositories;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.flight_management_system.business_logic.entities.Flight;

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

	public Flight findByFlightNumber(Long flightNumber) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		Flight flight = null;

		try {
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Flight.class);
			cr.add(Restrictions.eq("flight_number", flightNumber));
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

	public void updateFlight(Integer flightId, Flight updatedFlight) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Flight oldFlight = (Flight) session.get(Flight.class, flightId);
			oldFlight.setFlightNumber(updatedFlight.getFlightNumber());
			oldFlight.setAirplaneType(updatedFlight.getAirplaneType());
			oldFlight.setDepartureCity(updatedFlight.getDepartureCity());
			oldFlight.setDepartureTime(updatedFlight.getDepartureTime());
			oldFlight.setArrivalCity(updatedFlight.getArrivalCity());
			oldFlight.setArrivalTime(updatedFlight.getArrivalTime());

			session.update(oldFlight);
		} catch (HibernateException ex) {
			tx.rollback();
			throw new HibernateException(ex);
		} finally {
			session.close();
		}
	}
}