package org.climb.consumer.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.climb.model.bean.route.Site;
import org.springframework.jdbc.core.RowMapper;

/**
 * Use the Site RowMapper in order to map a row from the DB to result line
 * @author bob
 *
 */
public class SiteRowMapper implements RowMapper<Site> {

	@Override
	public Site mapRow(ResultSet rs, int rowNum) throws SQLException {
		
        Site vSite = new Site();
        vSite.setId(rs.getInt("id"));
        vSite.setName(rs.getString("name"));
        
        return vSite;
	}

}
