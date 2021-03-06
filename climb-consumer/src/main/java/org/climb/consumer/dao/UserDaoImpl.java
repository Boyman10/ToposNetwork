package org.climb.consumer.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.climb.consumer.dao.interfaces.UserDao;
import org.climb.consumer.rm.UserRowMapper;
import org.climb.model.bean.user.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

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
	public boolean addUser(User user) {

		try {
			LOGGER.debug("Setting up dataSource initializing NamedParameterJdbcTemplate under npjTemplate");
			this.setDataSource(getDataSource());
			
			LOGGER.debug("adding user to DB - UserDAO : " + user.getUsername());

			BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);

			LOGGER.debug("Launching query now...");

			int nRows = this.npjTemplate.update(
					"INSERT INTO public.climb_user(username,email,pass,datereg,role_id) values(:username,:email,:password,TO_DATE(:datereg,'YYYY-MM-DD'),:role.id)",
					params);
			LOGGER.debug("Query done ! ");
			
			
			
			return nRows == 1;

		} catch (InvalidResultSetAccessException e) {
			LOGGER.error("FATAL ERROR Invalid resultset " + e.getMessage());
			throw new RuntimeException(e);
		} catch (DataAccessException e) {
			LOGGER.error("FATAL ERROR dataAccess " + e.getMessage());
			throw new RuntimeException(e);
		} catch (Exception e) {
			LOGGER.error("FATAL ERROR Exception " + e.getMessage());
			throw new RuntimeException(e);
		}

	}

	/**
	 * Getting the user from db using the bean data / password and email/name
	 */
	@Override
	public User findUserByBean(User user) {
		
		String sql = "SELECT * FROM public.climb_user WHERE (username = :name )";
		
		try {
			LOGGER.debug("Setting up dataSource initializing NamedParameterJdbcTemplate under npjTemplate");
			
			this.setDataSource(getDataSource());
			MapSqlParameterSource vParams = new MapSqlParameterSource();			
			
			LOGGER.debug("getting user by name and pass : " + user.getUsername());

			vParams.addValue("name", user.getUsername());
			//vParams.addValue("password", user.getPassword());
			
			LOGGER.debug("Launching query now...");

			RowMapper<User> vRowMapper = new UserRowMapper();
			
			// Case fields match the ones in DB we can use a defaultRowMapper using the User.class...
			User qUser = (User) this.npjTemplate.queryForObject(sql, vParams, vRowMapper);
			
			LOGGER.debug("Query done - returning user " + qUser.getUsername());
			
			return qUser;
			
			
		} catch (InvalidResultSetAccessException e) {
			LOGGER.error("FATAL ERROR Invalid resultset " + e.getMessage());
			throw new RuntimeException(e);
		} catch (DataAccessException e) {
			LOGGER.error("FATAL ERROR dataAccess " + e.getMessage());
			throw new RuntimeException(e);
		} catch (Exception e) {
			LOGGER.error("FATAL ERROR Exception " + e.getMessage());
			throw new RuntimeException(e);
		}
	}
}
