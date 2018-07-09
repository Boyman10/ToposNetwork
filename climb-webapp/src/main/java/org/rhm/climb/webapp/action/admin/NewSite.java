package org.rhm.climb.webapp.action.admin;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.climb.business.manager.interfaces.factory.ManagerFactory;
import org.climb.model.bean.route.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Providing a way to add a new Site with its details
 * @author bob
 * @version 0.1.0
 */
public class NewSite extends ActionSupport {

	private static final long serialVersionUID = 189L;
	private static final Logger LOGGER = LogManager.getLogger(NewSite.class);

	// The bean to be defined for the login form - using corresponding entity
	private Site siteBean;

	@Autowired
	@Qualifier("managerFactory")
	private ManagerFactory managerFactory;
	
	
	/**
	 * @return the siteBean
	 */
	public Site getSiteBean() {
		return siteBean;
	}


	/**
	 * @param siteBean the siteBean to set
	 */
	public void setSiteBean(Site siteBean) {
		this.siteBean = siteBean;
	}

	@Override
	public String execute() {
		
		String vResult = INPUT;
		
		LOGGER.debug("Let's add a new site now !");
		
		// Check if we have a bean filled in :
		if (siteBean != null && !StringUtils.isAllEmpty(siteBean.getName())) {

			try {

				LOGGER.debug("About to persist the bean to DB " + siteBean.getName());

				// Persist data to db now :
				if (this.managerFactory.getSiteManager().addSite(siteBean) > 0) {
					vResult = ActionSupport.SUCCESS;
					/* Perfect we are all good we should continue now : */

					this.addActionMessage(
							"Thank you for registering a new site entry - please check out the url now to add new area and routes.");

					LOGGER.debug("Adding site to DB - Adding event to control the location or whatever ?");
					
				} else
					this.addActionError("Something went wrong please check your entries or contact our support");

			} catch (Exception pEx) {

				this.addActionError("Something went wrong please check your entries !");
			}
		}
		
		return vResult;
	}

}
