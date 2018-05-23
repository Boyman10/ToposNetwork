package org.climb.business.manager;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.climb.business.manager.interfaces.UserManager;
import org.climb.model.bean.user.User;
import org.springframework.stereotype.Service;

@Service("userManager")
public class UserManagerImpl extends AbstractManager implements UserManager {

	private static final Log LOGGER = LogFactory.getLog(UserManagerImpl.class);
	@Override
	public List<User> getUsersList() {
		
		LOGGER.debug("REtrieving user lising - User manager");
		return getDaoFactory().getUserDao().getListUsers();
	}
	
	@Override
	public void addUser(User user) {
		
		LOGGER.debug("Adding new user - User manager " + user.getUsername());
		
		getDaoFactory().getUserDao().addUser(user);
		
	}

}
