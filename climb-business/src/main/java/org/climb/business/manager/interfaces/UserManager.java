package org.climb.business.manager.interfaces;

import java.util.List;

import org.climb.model.bean.user.User;
import org.springframework.stereotype.Service;

public interface UserManager {

	public List<User> getUsersList();
	public void addUser(User user);
}
