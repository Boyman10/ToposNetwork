package org.rhm.climb.webapp.action.admin;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.climb.business.manager.interfaces.factory.ManagerFactory;
import org.climb.model.bean.route.Area;
import org.climb.model.bean.route.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Providing a way to add a new Site with its details
 * @author bob
 * @version 0.1.0
 */
public class NewArea extends ActionSupport {

	private static final long serialVersionUID = 189L;
	private static final Logger LOGGER = LogManager.getLogger(NewArea.class);

	// The bean to be defined for the new area form - using corresponding entity
	private Area areaBean;
	private int siteId;
	
	@Autowired
	@Qualifier("managerFactory")
	private ManagerFactory managerFactory;
	
	
	public int getSiteId() {
		return siteId;
	}


	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}


	/**
	 * @return the siteBean
	 */
	public Area getAreaBean() {
		return areaBean;
	}


	/**
	 * @param siteBean the siteBean to set
	 */
	public void setAreaBean(Area areaBean) {
		this.areaBean = areaBean;
	}

	@Override
	public String input() {
		
		LOGGER.debug("Yes we are on the input form for a new Area entry");
		
		return INPUT;
	}

	@Override
	public String execute() {
		
		String vResult = INPUT;
		
		LOGGER.debug("Let's add a new area now !");
		
		// Check if we have a bean filled in :
		if (areaBean != null && !StringUtils.isAllEmpty(areaBean.getName()) && siteId > 0) {

			try {

				LOGGER.debug("About to persist the bean to DB " + areaBean.getName());

				Site areaSite = managerFactory.getSiteManager().getSiteById(siteId);
				areaBean.setSite(areaSite);
				
				// Persist data to db now :
				if (this.managerFactory.getAreaManager().addArea(areaBean) > 0) {
					vResult = ActionSupport.SUCCESS;
					/* Perfect we are all good we should continue now : */

					this.addActionMessage(
							"Thank you for registering a new area entry - please check out the url now to add new routes.");

					LOGGER.debug("Adding area to DB - Adding event to control the location or whatever ?");
					
				} else
					this.addActionError("Something went wrong please check your entries or contact our support");

			} catch (Exception pEx) {

				this.addActionError("Something went wrong please check your entries ! " + pEx.getMessage());
			}
		}
		
		return vResult;
	}

}
