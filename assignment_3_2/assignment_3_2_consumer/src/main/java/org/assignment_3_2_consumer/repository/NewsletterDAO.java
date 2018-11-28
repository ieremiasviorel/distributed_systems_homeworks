package org.assignment_3_2_consumer.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.assignment_3_2_common_classes.entity.NewsletterSubscription;

public class NewsletterDAO {

	EntityManager entityManager = SingletonEntityManagerFactory.getInstance().createEntityManager();

	public List<NewsletterSubscription> getAll() {
		EntityTransaction transaction = null;

		List<NewsletterSubscription> subscriptions = null;

		try {
			transaction = entityManager.getTransaction();
			transaction.begin();

			subscriptions = entityManager
					.createQuery("SELECT s FROM NewsletterSubscription s", NewsletterSubscription.class)
					.getResultList();

			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		}
		return subscriptions;
	}
}
