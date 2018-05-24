package org.climb.business.manager.interfaces;

import java.util.List;

import org.climb.model.bean.user.User;

public interface UserManager {

	public List<User> getUsersList();
	public boolean addUser(User user);
	public User findUserByBean(User user);
}
