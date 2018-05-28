package org.climb.business.manager.interfaces;

import java.util.List;

import org.climb.model.bean.user.User;
import org.springframework.stereotype.Component;

@Component
public interface UserManager {

	public List<User> getUsersList();
	public Boolean addUser(User user);
	public User findUserByBean(User user);
}
