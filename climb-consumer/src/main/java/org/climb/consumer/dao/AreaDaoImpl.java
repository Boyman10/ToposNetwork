package org.climb.consumer.dao;

import java.util.List;

import javax.persistence.EntityTransaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.climb.consumer.dao.interfaces.AreaDao;
import org.climb.model.bean.route.Area;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

/**
 * Dao for Area - using Hibernate
 * 
 * @author bob
 * @see https://www.tutorialspoint.com/hibernate/hibernate_examples.htm
 */
@Component("areaDao")
public class AreaDaoImpl extends AbstractDaoImpl implements AreaDao {

	private static final Log LOGGER = LogFactory.getLog(AreaDaoImpl.class);

	
	/**
	 * Method returning the listing of all area from the DB using Hibernate
	 */
	@Override
	public List<Area> getListArea() {

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

		LOGGER.debug("Preparing sessionFactory for Hibernate");

		Session session = sessionFactory.openSession();

		Integer affectedRows = 0;

		try {
			
			LOGGER.debug("Begin transaction");

			Transaction tx = session.beginTransaction();
			affectedRows = (Integer) session.save(area);

			LOGGER.debug("Saving data AREA to DB");

			tx.commit();
			LOGGER.debug("Commit done !!");


		} catch (Exception e) {
			if (session != null)
				((EntityTransaction) session).rollback();
			//e.printStackTrace();
			
			LOGGER.debug("exception reached " + e.getMessage());

		} finally {
			session.close();
		}

		return affectedRows;
	}
	@Override
	public Area getAreaFromId(int id) {
		
		String sql = "SELECT * FROM public.climb_area WHERE id = :id";
		
		try {
			LOGGER.debug("Setting up dataSource initializing NamedParameterJdbcTemplate under npjTemplate");
			
			this.setDataSource(getDataSource());
			MapSqlParameterSource vParams = new MapSqlParameterSource();			
			
			LOGGER.debug("getting area by id : " + id);

			vParams.addValue("id", id);
			
			LOGGER.debug("Launching query now...");

			Area area = (Area) this.npjTemplate.queryForObject(sql, vParams, new BeanPropertyRowMapper(Area.class));
			
			LOGGER.debug("Query done ! ");
			
			return area;

		} catch (InvalidResultSetAccessException e) {
			LOGGER.error("FATAL ERROR Invalid resultset " + e.getMessage());
			throw new RuntimeException(e);
		} catch (DataAccessException e) {
			LOGGER.error("FATAL ERROR dataAccess " + e.getMessage());
			throw new RuntimeException(e);
		} catch (Exception e) {
			LOGGER.error("FATAL ERROR Exception " + e.getMessage());
			throw new RuntimeException(e);
		}
	}
}
