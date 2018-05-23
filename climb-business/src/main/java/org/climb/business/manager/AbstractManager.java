package org.climb.business.manager;

import org.climb.consumer.dao.interfaces.DaoFactory;

/**
 * Contract linking to DaoFactory 
 * @author bob
 *
 */
public class AbstractManager {
	private DaoFactory daoFactory;

	public DaoFactory getDaoFactory() {
		return daoFactory;
	}

	public void setDaoFactory(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

}
