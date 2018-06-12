package org.climb.business.manager.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.climb.business.manager.interfaces.SiteManager;
import org.climb.model.bean.route.Site;
import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;

@Component("siteManager")
//@Transactional
public class SiteManagerImpl extends AbstractManager implements SiteManager {
	
	static final Logger LOGGER = LogManager.getLogger(SiteManagerImpl.class);
	
	
	@Override
	public int addSite(Site site) {
		
		LOGGER.debug("Adding new site - Site manager " + site.getName());

		return getDaoFactory().getSiteDao().addSite(site);	
	}


	@Override
	public List<Site> getSiteList() {
		LOGGER.debug("Getting list of sites - Site manager ");
			
		
		return getDaoFactory().getSiteDao().getSites();
	}
	@Override
	public Site getSiteById(int id) {
		LOGGER.debug("Getting site - from Site id");
			
		
		return getDaoFactory().getSiteDao().getSiteFromId(id);
	}

}
