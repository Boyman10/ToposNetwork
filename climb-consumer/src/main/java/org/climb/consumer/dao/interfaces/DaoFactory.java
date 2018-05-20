package org.climb.consumer.dao.interfaces;

/**
 * Our Dao factory to get and set the proper Dao
 * @author bill
 * @version 0.1.0
 */
public interface DaoFactory {

	public UserDao getUserDao();
	
	public void setUserDao(UserDao td);
}
