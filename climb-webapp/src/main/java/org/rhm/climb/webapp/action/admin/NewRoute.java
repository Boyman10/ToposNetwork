package org.rhm.climb.webapp.action.admin;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.climb.business.manager.interfaces.factory.ManagerFactory;
import org.climb.model.bean.route.Area;
import org.climb.model.bean.route.Grade;
import org.climb.model.bean.route.Route;
import org.climb.model.bean.route.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Providing a way to add a new Route with details
 * @author bob
 * @version 0.1.0
 */
public class NewRoute extends ActionSupport {

	private static final long serialVersionUID = 18909L;
	private static final Logger LOGGER = LogManager.getLogger(NewRoute.class);

	// The bean to be defined for the new area form - using corresponding entity
	private Route routeBean;
	private int areaId, gradeId;
	
	@Autowired
	@Qualifier("managerFactory")
	private ManagerFactory managerFactory;
	
	
	public int getAreaId() {
		return areaId;
	}


	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public int getGradeId() {
		return gradeId;
	}


	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	/**
	 * @return the routeBean
	 */
	public Route getRouteBean() {
		return routeBean;
	}


	/**
	 * @param areaBean the routeBean to set
	 */
	public void setRouteBean(Route routeBean) {
		this.routeBean = routeBean;
	}

	@Override
	public String input() {
		
		LOGGER.debug("Yes we are on the input form for a new Route entry");
		
		return INPUT;
	}

	@Override
	public String execute() {
		
		String vResult = INPUT;
		
		LOGGER.debug("Let's add a new route now !");
		
		// Check if we have a bean filled in :
		if (routeBean != null && !StringUtils.isAllEmpty(routeBean.getName()) && areaId > 0 && gradeId > 0) {

			try {

				LOGGER.debug("About to persist the bean to DB " + routeBean.getName());

				Area routeArea = managerFactory.getAreaManager().getAreaById(areaId);
				routeBean.setArea(routeArea);
				Grade routeGrade = managerFactory.getGradeManager().getGradeById(gradeId);
				routeBean.setGrade(routeGrade);				
				
				
				// Persist data to db now :
				if (this.managerFactory.getRouteManager().addRoute(routeBean) > 0) {
					vResult = ActionSupport.SUCCESS;
					/* Perfect we are all good we should continue now : */

					this.addActionMessage(
							"Thank you for registering a new route entry.");

					LOGGER.debug("Adding route to DB - Adding event to control the location or whatever ?");
					
				} else
					this.addActionError("Something went wrong please check your entries or contact our support");

			} catch (Exception pEx) {

				this.addActionError("Something went wrong please check your entries ! " + pEx.getMessage());
			}
		}
		
		return vResult;
	}

}
