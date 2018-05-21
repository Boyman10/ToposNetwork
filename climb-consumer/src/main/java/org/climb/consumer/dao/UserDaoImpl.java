package org.climb.consumer.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.climb.consumer.dao.interfaces.UserDao;

public class UserDaoImpl extends AbstractDaoImpl implements UserDao{

	private static final Log LOGGER = LogFactory.getLog(UserDaoImpl.class);
	
	@Override
	public int getCountUsers() {

		return 0;
	}

	@Override
	public void updateRole() {
		// TODO Auto-generated method stub
		
	}

}
