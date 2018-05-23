package org.climb.business.manager.interfaces.factory;

import org.climb.business.manager.interfaces.UserManager;

public interface ManagerFactory {


	UserManager getUserManager();

	void setUserManager(UserManager userManager);

}
