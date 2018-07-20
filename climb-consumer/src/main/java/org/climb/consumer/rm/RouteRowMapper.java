package org.climb.consumer.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.climb.model.bean.route.Route;
import org.climb.model.bean.route.Site;
import org.springframework.jdbc.core.RowMapper;

/**
 * Use the Route RowMapper in order to map a row from the DB to result line
 * needs to reflect all fields and fill the Object accordingly
 * @author bob
 */
public class RouteRowMapper implements RowMapper<Route> {

	@Override
	public Route mapRow(ResultSet rs, int rowNum) throws SQLException {
		
        Route vRoute = new Route();
        
        vRoute.setId(rs.getInt("id"));
        vRoute.setName(rs.getString("name"));
        vRoute.setSummit(rs.getDouble("summit"));
        vRoute.setNbPoints(rs.getInt("nb_points"));
        vRoute.setDetails(rs.getString("details"));

        // Fill in new Grade and new Area here - should update the query accordingly... @TODO
        
        return vRoute;
	}

}
