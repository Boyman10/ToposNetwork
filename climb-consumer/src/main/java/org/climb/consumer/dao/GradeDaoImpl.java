package org.climb.consumer.dao;

import java.util.List;

import org.climb.consumer.dao.interfaces.GradeDao;
import org.climb.model.bean.route.Grade;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component("gradeDao")
public class GradeDaoImpl extends AbstractDaoImpl implements GradeDao {

	@Override
	public List<Grade> getListGrades() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void addGrade(Grade grade) {
		
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
 		session.save(grade);
 
		session.getTransaction().commit();
		session.close();
	}

}
