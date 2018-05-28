package org.climb.consumer.dao.interfaces;

import org.climb.model.bean.route.Site;

/**
 * Site DAO to interact with DB - functionnalities
 * @author bob
 *
 */
public interface SiteDao {

	public int addSite(Site site);
}
