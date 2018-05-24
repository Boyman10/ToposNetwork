package org.climb.consumer.dao;

import org.climb.consumer.dao.interfaces.DaoFactory;
import org.climb.consumer.dao.interfaces.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("daoFactory")
public class DaoFactoryImpl implements DaoFactory {

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDao getUserDao() {
		return userDao;
	}

	@Override
	public void setUserDao(UserDao uDao) {
		this.userDao = uDao;
	}

}
