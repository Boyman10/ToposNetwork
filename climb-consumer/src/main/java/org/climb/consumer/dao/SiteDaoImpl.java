package org.climb.consumer.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.climb.consumer.dao.interfaces.SiteDao;
import org.climb.consumer.rm.SiteRowMapper;
import org.climb.model.bean.route.Site;
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

@Component("siteDao")
public class SiteDaoImpl extends AbstractDaoImpl implements SiteDao {
	
	private static final Log LOGGER = LogFactory.getLog(SiteDaoImpl.class);

	@Override
	public int addSite(Site site) {
		
		int nRows = 0;
		
		try {
			LOGGER.debug("Setting up dataSource initializing NamedParameterJdbcTemplate under npjTemplate");
			this.setDataSource(getDataSource());
			
			LOGGER.debug("adding site to DB : " + site.getName());

			BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(site);

			LOGGER.debug("Launching query now...");

			// Using keyholder to retrieve the last insert id :
			KeyHolder keyHolder = new GeneratedKeyHolder();
	        String[] columnNames = new String[] {"id"};
			
			nRows = this.npjTemplate.update(
					"INSERT INTO public.climb_site(location,region,department,name,country,type) "
					+ "values(:location,:region,:department,:name,:country,:type)",
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
	public int updateSite(Site site) {
		
		int nRows = 0;
		
		try {
			LOGGER.debug("Setting up dataSource initializing NamedParameterJdbcTemplate under npjTemplate");
			this.setDataSource(getDataSource());
			
			LOGGER.debug("updating site to DB : " + site.getName());

			BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(site);

			LOGGER.debug("Launching query now...");

			nRows = this.npjTemplate.update(
					"UPDATE public.climb_site SET location=:location,region=:region,department=:department,name=:name,country=:country,type=:type "
					+ " WHERE id = :id",
					params);
			
			LOGGER.debug("Query done ! ");
			
						
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
	public List<Site> getSites() {
		
        String vSQL = "SELECT * FROM public.climb_site";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        RowMapper<Site> vRowMapper = new SiteRowMapper();

        List<Site> vListSite = vJdbcTemplate.query(vSQL, vRowMapper);

        return vListSite;
	}
	
	@Override
	public Site getSiteFromId(int id) {
		
		String sql = "SELECT * FROM public.climb_site WHERE id = :id";
		
		try {
			LOGGER.debug("Setting up dataSource initializing NamedParameterJdbcTemplate under npjTemplate");
			
			this.setDataSource(getDataSource());
			MapSqlParameterSource vParams = new MapSqlParameterSource();			
			
			LOGGER.debug("getting site by id : " + id);

			vParams.addValue("id", id);
			
			LOGGER.debug("Launching query now...");

			Site site = (Site) this.npjTemplate.queryForObject(sql, vParams, new BeanPropertyRowMapper(Site.class));
			
			LOGGER.debug("Query done ! ");
			
			return site;

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
