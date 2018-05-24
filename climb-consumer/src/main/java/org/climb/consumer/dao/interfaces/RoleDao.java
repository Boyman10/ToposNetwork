package org.climb.consumer.dao.interfaces;

import org.climb.model.bean.user.Role;

/**
 * Role Repository
 * @author bob
 *
 */
public interface RoleDao {

	public Role getRoleByName(String name);
}
