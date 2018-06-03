package org.climb.consumer.dao.interfaces;

import java.util.List;

import org.climb.model.bean.route.Grade;

/**
 * Interface representing the access DAO for Grade Entity
 * @author bill
 *
 */
public interface GradeDao {

	public List<Grade> getListGrades();

	int addGrade(Grade grade);
}
