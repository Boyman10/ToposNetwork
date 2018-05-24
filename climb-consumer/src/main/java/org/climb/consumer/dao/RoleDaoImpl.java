package org.climb.consumer.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.climb.consumer.dao.interfaces.RoleDao;
import org.climb.model.bean.user.Role;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component("roleDao")
public class RoleDaoImpl extends AbstractDaoImpl implements RoleDao {
	
	private static final Log LOGGER = LogFactory.getLog(RoleDaoImpl.class);
	
	@Override
	public Role getRoleByName(String name) {

		String sql = "SELECT * FROM public.climb_role WHERE name = :name";
		
		try {
			LOGGER.debug("Setting up dataSource initializing NamedParameterJdbcTemplate under npjTemplate");
			
			this.setDataSource(getDataSource());
			MapSqlParameterSource vParams = new MapSqlParameterSource();			
			
			LOGGER.debug("getting role by name : " + name);

			vParams.addValue("name", name);
			
			LOGGER.debug("Launching query now...");

			Role role = (Role) this.npjTemplate.queryForObject(sql, vParams, new BeanPropertyRowMapper(Role.class));
			
			LOGGER.debug("Query done ! ");
			
			return role;

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
