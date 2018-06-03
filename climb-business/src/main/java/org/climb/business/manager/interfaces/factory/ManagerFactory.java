package org.climb.business.manager.interfaces.factory;

import org.climb.business.manager.interfaces.GradeManager;
import org.climb.business.manager.interfaces.RoleManager;
import org.climb.business.manager.interfaces.SiteManager;
import org.climb.business.manager.interfaces.UserManager;

public interface ManagerFactory {


	UserManager getUserManager();
	RoleManager getRoleManager();
	SiteManager getSiteManager();
	GradeManager getBrandManager();
	
	void setUserManager(UserManager userManager);
	void setRoleManager(RoleManager roleManager);
	void setSiteManager(SiteManager siteManager);
	void setBrandManager(GradeManager brandManager);

}
