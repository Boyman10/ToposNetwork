package org.climb.consumer.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.climb.consumer.dao.interfaces.RouteDao;
import org.climb.consumer.rm.RouteRowMapper;
import org.climb.model.bean.route.Route;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

@Component("routeDao")
public class RouteDaoImpl extends AbstractDaoImpl implements RouteDao {
	
	private static final Log LOGGER = LogFactory.getLog(SiteDaoImpl.class);

	@Override
	public int addRoute(Route route) {
		
		int nRows = 0;
		
		try {
			LOGGER.debug("Setting up dataSource initializing NamedParameterJdbcTemplate under npjTemplate");
			this.setDataSource(getDataSource());
			
			LOGGER.debug("adding route to DB : " + route.getName());

			BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(route);

			LOGGER.debug("Launching query now...");

			// Using keyholder to retrieve the last insert id :
			KeyHolder keyHolder = new GeneratedKeyHolder();
	        String[] columnNames = new String[] {"id"};
			
			nRows = this.npjTemplate.update(
					"INSERT INTO public.climb_route(name,grade_id,area_id,details,summit,nb_points) "
					+ "values(:name,:gradeId,:areaId,:details,:summit,:nbPoints)",
					params, keyHolder, columnNames);
			
			Map<String,Object> keys = keyHolder.getKeys();
			
			LOGGER.debug("Query done ! " + keys.get("id"));
			
						
			return nRows;

		}catch (DuplicateKeyException e) {
			LOGGER.error("FATAL ERROR duplicate entry " + e.getMessage());
			throw new RuntimeException(e);
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


	@Override
	public List<Route> getRoutes() {
		
        String vSQL = "SELECT * FROM public.climb_route";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        RowMapper<Route> vRowMapper = new RouteRowMapper();

        List<Route> vListRoute = vJdbcTemplate.query(vSQL, vRowMapper);

        return vListRoute;
	}
	
	@Override
	public Route getRouteFromId(int id) {
		
		String sql = "SELECT * FROM public.climb_route WHERE id = :id";
		
		try {
			LOGGER.debug("Setting up dataSource initializing NamedParameterJdbcTemplate under npjTemplate");
			
			this.setDataSource(getDataSource());
			MapSqlParameterSource vParams = new MapSqlParameterSource();			
			
			LOGGER.debug("getting route by id : " + id);

			vParams.addValue("id", id);
			
			LOGGER.debug("Launching query now...");

			Route route = (Route) this.npjTemplate.queryForObject(sql, vParams, new BeanPropertyRowMapper(Route.class));
			
			LOGGER.debug("Query done ! ");
			
			return route;

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
