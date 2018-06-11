package org.climb.business.manager.interfaces;

import java.util.List;

import org.climb.model.bean.route.Site;

/**
 * 
 * Interface for site management features
 * @author bob
 *
 */
public interface SiteManager {

	public int addSite(Site site);
	public List<Site> getSiteList();
	Site getSiteById(int id);
}
