package org.climb.business.manager.impl;

import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.climb.business.manager.interfaces.SiteManager;
import org.climb.model.bean.route.Site;

@Component("siteManager")
public class SiteManagerImpl extends AbstractManager implements SiteManager {
	
	static final Logger LOGGER = LogManager.getLogger(SiteManagerImpl.class);
	
	
	@Override
	public int addSite(Site site) {
		
		LOGGER.debug("Adding new site - Site manager " + site.getName());

		return getDaoFactory().getSiteDao().addSite(site);	
	}

}
