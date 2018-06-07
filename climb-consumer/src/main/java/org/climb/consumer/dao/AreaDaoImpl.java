package org.climb.consumer.dao;

import java.util.List;

import javax.persistence.EntityTransaction;

import org.climb.consumer.dao.interfaces.AreaDao;
import org.climb.model.bean.route.Area;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

/**
 * Dao for Area - using Hibernate
 * 
 * @author bob
 * @see https://www.tutorialspoint.com/hibernate/hibernate_examples.htm
 */
@Component("areaDao")
public class AreaDaoImpl extends AbstractDaoImpl implements AreaDao {

	
	/**
	 * Method returning the listing of all area from the DB using Hibernate
	 */
	@Override
	public List<Area> getListArea() {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Area> areas = null;

		try {
			tx = session.beginTransaction();

			areas = session.createQuery("FROM Area").list();

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return areas;
	}

	@Override
	public int addArea(Area area) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Integer affectedRows = 0;

		try {

			session.beginTransaction();
			affectedRows = (Integer) session.save(area);

			session.getTransaction().commit();

		} catch (Exception e) {
			if (session != null)
				((EntityTransaction) session).rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return affectedRows;
	}

}
