package package_tracking_system.assignment_4_2.daos.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import package_tracking_system.assignment_4_2.daos.CityDAO;
import package_tracking_system.assignment_4_2.daos.config.EntityManagerProvider;
import package_tracking_system.assignment_4_2.models.City;

public class CityDAOImpl implements CityDAO {

	private EntityManagerFactory emf = EntityManagerProvider.getInstance();

	public void save(City city) {
		EntityManager em = emf.createEntityManager();

		em.persist(city);

		em.close();
	}

	@Override
	public City find(Integer id) {
		EntityManager em = emf.createEntityManager();

		City city = em.find(City.class, id);
		em.close();

		return city;
	}

	@Override
	public City find(String name) {
		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("SELECT c FROM City c WHERE c.name = :name");
		query.setParameter("name", name);

		City city = (City) query.getSingleResult();
		em.close();

		return city;
	}

	@Override
	public List<City> findAll() {
		EntityManager em = emf.createEntityManager();

		List<City> cities = null;

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<City> cq = cb.createQuery(City.class);
		Root<City> from = cq.from(City.class);
		CriteriaQuery<City> all = cq.select(from);
		TypedQuery<City> allQuery = em.createQuery(all);

		cities = allQuery.getResultList();
		return cities;
	}
}
