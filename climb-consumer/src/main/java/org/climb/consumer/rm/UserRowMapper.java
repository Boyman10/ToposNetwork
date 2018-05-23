package org.climb.consumer.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.climb.model.bean.user.User;
import org.springframework.jdbc.core.RowMapper;

/**
 * Let's use a rowMapper for ...
 * @author bill
 *
 */
public class UserRowMapper implements RowMapper<User> {
		
		public User mapRow(ResultSet pRS, int pRowNum) throws SQLException {
		    User vUser = new User();
		   // vUser.setLibelle(pRS.getString("libelle"));
		    return vUser;
		}
	}