package org.climb.business.manager.impl;

import org.climb.business.manager.interfaces.UserManager;
import org.climb.business.manager.interfaces.factory.ManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Service to be injected to do business with the consumer module
 * we do use some entity manager to handle the data
 * @author bob
 *
 */
@Component("managerFactory")
public class ManagerFactoryImpl implements ManagerFactory {

	@Autowired
	private UserManager userManager;
	
	@Override
	public UserManager getUserManager() {
		
		return this.userManager;
	}

	@Override
	public void setUserManager(UserManager userManager) {

		this.userManager = userManager;
	}

}
