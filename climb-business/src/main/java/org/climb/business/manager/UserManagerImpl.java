package org.climb.business.manager;

import java.util.List;

import org.climb.business.manager.interfaces.UserManager;
import org.climb.model.bean.user.User;

public class UserManagerImpl extends AbstractManager implements UserManager {

	@Override
	public List<User> getUsersList() {
		
		return getDaoFactory().getUserDao().;
	}

}
