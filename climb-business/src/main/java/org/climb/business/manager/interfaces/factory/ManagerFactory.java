package org.climb.business.manager.interfaces.factory;

import org.climb.business.manager.interfaces.AreaManager;
import org.climb.business.manager.interfaces.GradeManager;
import org.climb.business.manager.interfaces.RoleManager;
import org.climb.business.manager.interfaces.RouteManager;
import org.climb.business.manager.interfaces.SiteManager;
import org.climb.business.manager.interfaces.UserManager;

public interface ManagerFactory {


	UserManager getUserManager();
	RoleManager getRoleManager();
	SiteManager getSiteManager();
	GradeManager getGradeManager();
	AreaManager getAreaManager();
	RouteManager getRouteManager();

	void setUserManager(UserManager userManager);
	void setRoleManager(RoleManager roleManager);
	void setSiteManager(SiteManager siteManager);
	void setGradeManager(GradeManager gradeManager);
	void setAreaManager(AreaManager areaManager);
	void setRouteManager(RouteManager routeManager);

}
