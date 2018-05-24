package org.climb.consumer.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.climb.consumer.dao.interfaces.UserDao;
import org.climb.consumer.rm.UserRowMapper;
import org.climb.model.bean.user.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("userDao")
public class UserDaoImpl extends AbstractDaoImpl implements UserDao {

	private static final Log LOGGER = LogFactory.getLog(UserDaoImpl.class);

	@Override
	public int getCountUsers() {

		StringBuilder vSQL = new StringBuilder("SELECT COUNT(*) FROM public.user WHERE 1=1");

		NamedParameterJdbcTemplate nParamTemplate = new NamedParameterJdbcTemplate(getDataSource());
		MapSqlParameterSource vParams = new MapSqlParameterSource();

		return nParamTemplate.queryForObject(vSQL.toString(), vParams, Integer.class);
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

		String vSQL = "SELECT * FROM public.user";

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
	public void addUser(User user) {
		
		LOGGER.debug("adding user to DB - UserDAO : " + user.getUsername());
		
		
	}
}
