package org.climb.consumer.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.climb.model.bean.route.Site;
import org.springframework.jdbc.core.RowMapper;

/**
 * Use the Site RowMapper in order to map a row from the DB to result line
 * needs to reflect all fields and fill the Object accordingly
 * @author bob
 */
public class SiteRowMapper implements RowMapper<Site> {

	@Override
	public Site mapRow(ResultSet rs, int rowNum) throws SQLException {
		
        Site vSite = new Site();
        
        vSite.setId(rs.getInt("id"));
        vSite.setName(rs.getString("name"));
        vSite.setCountry(rs.getString("country"));
        vSite.setDepartment(rs.getString("department"));
        vSite.setLocation(rs.getString("location"));
        vSite.setType(rs.getString("type"));
        vSite.setRegion(rs.getString("region"));
        
        return vSite;
	}

}
