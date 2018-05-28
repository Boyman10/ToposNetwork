package org.climb.consumer.dao.interfaces;

import org.springframework.stereotype.Service;

/**
 * Our Dao factory to get and set the proper Dao
 * @author bill
 * @version 0.1.0
 */
@Service
public interface DaoFactory {

	public UserDao getUserDao();
	public void setUserDao(UserDao uDao);
	
	public RoleDao getRoleDao();
	public SiteDao getSiteDao();
}
