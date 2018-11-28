package org.assignment_3_2_consumer.repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SingletonEntityManagerFactory {

	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("JavaHelps");

	public static EntityManagerFactory getInstance() {
		return ENTITY_MANAGER_FACTORY;
	}
}
