package com.force.sample.snippets.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import com.force.sample.snippets.test.TestContext;

public class SnippetFTest {
	
	static TestContext ctx;
	static EntityManager em;
	
	@BeforeClass
	public static void before() {
		ctx = new TestContext();
		em = ctx.getEntityManager();
	}
	
//	@Test
	public void testSnippetQuery() {
		List<Snippet> snippets = em.createQuery("Select o From Snippet o").getResultList();
		Assert.assertEquals(0, snippets.size());
	}
}
