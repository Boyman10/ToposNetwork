package org.climb.consumer.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.climb.consumer.dao.interfaces.GradeDao;
import org.climb.model.bean.route.Grade;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component("gradeDao")
public class GradeDaoImpl extends AbstractDaoImpl implements GradeDao {

	private static final Log LOGGER = LogFactory.getLog(GradeDaoImpl.class);

	@Override
	public List<Grade> getListGrades() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int addGrade(Grade grade) {
		
		
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
 		Integer affectedRows = (Integer)session.save(grade);
 
		session.getTransaction().commit();
		session.close();
		
		return affectedRows;
	}

	@Override
	public Grade getGradeFromId(int id) {
		
		String sql = "SELECT * FROM public.climb_grade WHERE id = :id";
		
		try {
			LOGGER.debug("Setting up dataSource initializing NamedParameterJdbcTemplate under npjTemplate");
			
			this.setDataSource(getDataSource());
			MapSqlParameterSource vParams = new MapSqlParameterSource();			
			
			LOGGER.debug("getting grade by id : " + id);

			vParams.addValue("id", id);
			
			LOGGER.debug("Launching query now...");

			Grade grade = (Grade) this.npjTemplate.queryForObject(sql, vParams, new BeanPropertyRowMapper(Grade.class));
			
			LOGGER.debug("Query done ! ");
			
			return grade;

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
