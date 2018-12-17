package package_tracking_system.assignment_4_1.daos.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProvider {

	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("PACKAGE_TRACKING_PERSISTENCE_UNIT");

	public static EntityManagerFactory getInstance() {
		return ENTITY_MANAGER_FACTORY;
	}
}
