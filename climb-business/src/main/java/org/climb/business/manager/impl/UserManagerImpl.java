package org.climb.business.manager.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.climb.business.manager.interfaces.UserManager;
import org.climb.model.bean.user.User;
import org.springframework.stereotype.Component;

@Component("userManager")
public class UserManagerImpl extends AbstractManager implements UserManager {

//	private static final Log LOGGER = LogFactory.getLog("climb");
	static final Logger LOGGER = LogManager.getLogger(UserManagerImpl.class);

	@Override
	public List<User> getUsersList() {
		
		
		LOGGER.debug("REtrieving user lising - User manager");
		return getDaoFactory().getUserDao().getListUsers();
	}
	
	@Override
	public boolean addUser(User user) {
		
		LOGGER.debug("Adding new user - User manager " + user.getUsername());
		
		return getDaoFactory().getUserDao().addUser(user);
		
	}

}