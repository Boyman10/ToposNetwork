package org.climb.business.manager.impl;

import java.util.List;

import org.climb.business.manager.interfaces.GradeManager;
import org.climb.model.bean.route.Grade;
import org.springframework.stereotype.Component;

@Component("gradeManager")
public class GradeManagerImpl extends AbstractManager implements GradeManager {

	@Override
	public List<Grade> getGradesList() {
		// TODO Auto-generated method stub
		return null;
	}

}
