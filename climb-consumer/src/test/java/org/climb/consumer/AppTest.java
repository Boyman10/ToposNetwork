package org.climb.consumer;

import org.climb.model.bean.route.Area;
import org.climb.model.bean.route.Site;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Site site = new Site();
		site.setName("Beauty site");
		site.setType("Block");
		
		session.save(site);

		Area area = new Area();
		area.setName("My area nice..");
		area.setDetails("details about area");
		area.setSite(site);
		// area.setDate(new Date());

		site.getAreas().add(area);

		session.save(area);

		session.getTransaction().commit();

	}
}
