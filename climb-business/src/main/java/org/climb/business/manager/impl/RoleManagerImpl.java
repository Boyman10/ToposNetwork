package org.climb.business.manager.impl;

import org.climb.business.manager.interfaces.RoleManager;
import org.climb.model.bean.user.Role;
import org.springframework.stereotype.Component;

@Component("roleManager")
public class RoleManagerImpl extends AbstractManager implements RoleManager {

	@Override
	public Role getRoleByName(String name) {

		return getDaoFactory().getRoleDao().getRoleByName(name);
	}

}
