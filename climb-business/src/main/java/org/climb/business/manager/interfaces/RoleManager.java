package org.climb.business.manager.interfaces;

import org.climb.model.bean.user.Role;
import org.springframework.stereotype.Component;

@Component
public interface RoleManager {

	public Role getRoleByName(String name);
}
