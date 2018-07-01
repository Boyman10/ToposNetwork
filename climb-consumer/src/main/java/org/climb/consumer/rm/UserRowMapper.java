package org.climb.consumer.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.climb.model.bean.user.User;
import org.springframework.jdbc.core.RowMapper;

/**
 * Let's use a rowMapper for the user entity
 * @TODO load the user Role ! 
 * @author Boyman10
 *
 */
public class UserRowMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int pRowNum) throws SQLException {
		User vUser = new User();

		vUser.setId(rs.getInt("id"));
		vUser.setPassword(rs.getString("pass"));
		vUser.setUsername(rs.getString("username"));
		vUser.setGravatar(rs.getString("gravatar"));
		vUser.setEmail(rs.getString("email"));
		vUser.setDatereg(rs.getString("datereg"));

		return vUser;
	}
}