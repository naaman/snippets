package com.force.sample.snippets.test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class TestContext {
	
	String persistenceUnit = "forceDatabase";
	
	public EntityManager getEntityManager() {
		return getEntityManager(persistenceUnit);
	}
	
	public EntityManager getEntityManager(String persistenceUnit) {
		return Persistence.createEntityManagerFactory(persistenceUnit).createEntityManager();
	}
}
