package org.climb.business.manager.impl;

import org.climb.business.manager.interfaces.GradeManager;
import org.climb.business.manager.interfaces.RoleManager;
import org.climb.business.manager.interfaces.SiteManager;
import org.climb.business.manager.interfaces.UserManager;
import org.climb.business.manager.interfaces.factory.ManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Service to be injected to do business with the consumer module
 * we do use some entity manager to handle the data
 * @author bob
 *
 */
@Component("managerFactory")
public class ManagerFactoryImpl implements ManagerFactory {

	@Autowired
	private UserManager userManager;
	
	@Autowired
	private RoleManager roleManager;

	@Autowired
	private GradeManager gradeManager;
		
	@Autowired
	private SiteManager siteManager;
	
	@Override
	public UserManager getUserManager() {
		
		return this.userManager;
	}

	@Override
	public void setUserManager(UserManager userManager) {

		this.userManager = userManager;
	}

	public GradeManager getBrandManager() {
		return gradeManager;
	}

	public void setBrandManager(GradeManager gradeManager) {
		this.gradeManager = gradeManager;
	}

	@Override
	public RoleManager getRoleManager() {
		
		return roleManager;
	}

	@Override
	public void setRoleManager(RoleManager roleManager) {

		this.roleManager = roleManager;
	}

	@Override
	public SiteManager getSiteManager() {
		return siteManager;
	}

	@Override
	public void setSiteManager(SiteManager siteManager) {
		this.siteManager = siteManager;		
	}

}
