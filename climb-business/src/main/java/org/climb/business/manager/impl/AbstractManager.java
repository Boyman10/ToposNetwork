package org.climb.business.manager.impl;

import org.climb.consumer.dao.interfaces.DaoFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Contract linking to DaoFactory 
 * @author bob
 *
 */
public class AbstractManager {
	
	@Autowired
	private DaoFactory daoFactory;

	public DaoFactory getDaoFactory() {
		return daoFactory;
	}

	public void setDaoFactory(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

}
