package org.climb.consumer.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.climb.consumer.dao.interfaces.UserDao;
import org.climb.consumer.rm.UserRowMapper;
import org.climb.model.bean.user.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("userDao")
public class UserDaoImpl extends AbstractDaoImpl implements UserDao {

	private static final Log LOGGER = LogFactory.getLog(UserDaoImpl.class);

	@Override
	public int getCountUsers() {

		StringBuilder vSQL = new StringBuilder("SELECT COUNT(*) FROM public.user WHERE 1=1");

		MapSqlParameterSource vParams = new MapSqlParameterSource();

		return this.npjTemplate.queryForObject(vSQL.toString(), vParams, Integer.class);
	}

	@Override
	public void updateRole() {
		// TODO Auto-generated method stub

	}

	/**
	 * Method to retrieve the list users
	 * 
	 * @return List of Users
	 */
	public List<User> getListUsers() {

		String vSQL = "SELECT * FROM public.climb_user";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		RowMapper<User> vRowMapper = new UserRowMapper();

		List<User> vListUsers = vJdbcTemplate.query(vSQL, vRowMapper);

		return vListUsers;
	}

	/**
	 * method which persists User to DB
	 * 
	 * @param User
	 */
	@Override
	@Transactional
	public boolean addUser(User user) {

		try {
			LOGGER.debug("adding user to DB - UserDAO : " + user.getUsername());
			BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);

			return this.npjTemplate.update(
					"INSERT INTO public.climb_user(username,email,password) values(:username,:email,:password)", params) == 1;
			
		} catch (InvalidResultSetAccessException e) {
			LOGGER.error("FATAL ERROR " + e.getMessage());
			throw new RuntimeException(e);
		} catch (DataAccessException e) {
			LOGGER.error("FATAL ERROR " + e.getMessage());
			throw new RuntimeException(e);
		}catch (Exception e) {
			LOGGER.error("FATAL ERROR " + e.getMessage());
			throw new RuntimeException(e);
		}
		

	}
}
