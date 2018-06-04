package org.rhm.climb.webapp.action.admin;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.climb.business.manager.interfaces.factory.ManagerFactory;
import org.climb.model.bean.route.Grade;
import org.climb.model.bean.route.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Adding grade
 * Authorized access only to ROLE_ADMIN
 * @author bill
 *
 */
public class AddGrade extends ActionSupport {

	private static final long serialVersionUID = 1546L;
	private static final Logger LOGGER = LogManager.getLogger(NewSite.class);

	// The bean to be defined for the login form - using corresponding entity
	private Grade gradeBean;

	// retrieve level list for the select box ! -- could be done via Ajax also ;) @todo
	private List<Level> levels = Arrays.asList(Level.values());

	public List<Level> getLevels() {
		return levels;
	}
	
	public void setLevels(List<Level> levels) {
		this.levels = levels;
	}

	

	@Autowired
	@Qualifier("managerFactory")
	private ManagerFactory managerFactory;
	
	
	/**
	 * @return the siteBean
	 */
	public Grade getGradeBean() {
		return gradeBean;
	}


	/**
	 * @param gradeBean the gradeBean to set
	 */
	public void setGradeBean(Grade gradeBean) {
		this.gradeBean = gradeBean;
	}

	@Override
	public String input() {
		
		LOGGER.debug("Yes we are on the input form for a new Grade entry");
		
		return INPUT;
	}

	@Override
	public String execute() {
		
		String vResult = INPUT;
		
		LOGGER.debug("Let's add a new grade now !");
		
		// Check if we have a bean filled in :
		if (gradeBean != null && !StringUtils.isAnyEmpty(gradeBean.getDetails())) {

			try {
				
				LOGGER.debug("About to persist the bean to DB ");

				// Persist data to db now :
				if (this.managerFactory.getGradeManager().addGrade(gradeBean) > 0) {
					vResult = ActionSupport.SUCCESS;
					/* Perfect we are all good we should continue now : */

					this.addActionMessage(
							"Thank you for registering a new grade entry.");

					LOGGER.debug("Adding grade to DB");
					
				} else
					this.addActionError("Something went wrong please check your entries or contact our support");

			} catch (Exception pEx) {

				this.addActionError("Something went wrong please check your entries !");
			}
		}
		
		return vResult;
	}

}
