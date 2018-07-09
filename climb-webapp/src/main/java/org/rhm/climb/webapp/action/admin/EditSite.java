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
 * Providing a way to edit a Site with its details
 * @author bob
 * @version 0.1.0
 */
public class EditSite extends ActionSupport {

	private static final long serialVersionUID = 189L;
	private static final Logger LOGGER = LogManager.getLogger(EditSite.class);

	// The bean to be defined for the login form - using corresponding entity
	private Site siteBean;

	@Autowired
	@Qualifier("managerFactory")
	private ManagerFactory managerFactory;
	
	// The id to retrieve for the site edition
	private int id;
	
	
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

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String input() {
		
		LOGGER.debug("Yes we are on the input form for editing a Site entry - Retrieving the id from the request parameter : " + this.id);
		
		siteBean = this.managerFactory.getSiteManager().getSiteById(this.id);
		
		if (siteBean == null) {
			this.addActionError("There must be something wrong here - please contact the support for debugging");
		}
		
		return INPUT;
	}

	@Override
	public String execute() {
		
		String vResult = INPUT;
		
		LOGGER.debug("Let's update a site now !");
		
		// Check if we have a bean filled in :
		if (siteBean != null && !StringUtils.isAllEmpty(siteBean.getName())) {

			try {

				LOGGER.debug("About to persist the bean to DB " + siteBean.getName());

				// Persist data to db now :
				if (this.managerFactory.getSiteManager().updateSite(siteBean) > 0) {
					vResult = ActionSupport.SUCCESS;
					/* Perfect we are all good we should continue now : */

					this.addActionMessage(
							"Thank you for updating the site entry - please check out the url now to add new area and routes.");

					LOGGER.debug("Updating site to DB - Adding event to control the location or whatever ?");
					
				} else
					this.addActionError("Something went wrong please check your entries or contact our support");

			} catch (Exception pEx) {

				this.addActionError("Something went wrong please check your entries !");
			}
		} else {
			// We are in input method :
			
			siteBean = this.managerFactory.getSiteManager().getSiteById(this.id);
			
			if (siteBean == null) {
				this.addActionError("There must be something wrong here - please contact the support for debugging");
			}
			
		}
		
		return vResult;
	}

}
