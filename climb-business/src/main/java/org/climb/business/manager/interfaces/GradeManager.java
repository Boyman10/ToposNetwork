package org.climb.business.manager.interfaces;

import java.util.List;

import org.climb.model.bean.route.Grade;
import org.springframework.stereotype.Component;

@Component
public interface GradeManager {

	public List<Grade> getGradesList();
	public int addGrade(Grade grade);
	Grade getGradeById(int id);

}
