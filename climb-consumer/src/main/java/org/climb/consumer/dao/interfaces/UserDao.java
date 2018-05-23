package org.climb.consumer.dao.interfaces;

import java.util.List;

import org.climb.model.bean.user.User;

/**
 * Interface to define contract for managing users
 * @author bill
 *
 */
public interface UserDao {
	
	public int getCountUsers();
	public void updateRole();
	public List<User> getListUsers();
	public void addUser(User user);

}
