package org.climb.consumer.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.climb.consumer.dao.interfaces.SiteDao;
import org.climb.model.bean.route.Site;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
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

			nRows = this.npjTemplate.update(
					"INSERT INTO public.climb_site(location,region,department,name,country,type) "
					+ "values(:location,:region,:department,:name,:type)",
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

}
