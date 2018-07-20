package org.climb.business.manager.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.climb.business.manager.interfaces.RouteManager;
import org.climb.model.bean.route.Route;
import org.springframework.stereotype.Component;

@Component("routeManager")
public class RouteManagerImpl extends AbstractManager implements RouteManager {

	static final Logger LOGGER = LogManager.getLogger(RouteManagerImpl.class);

	@Override
	public List<Route> getRouteList() {
		LOGGER.debug("Getting list of routes - Route manager ");
		
		return getDaoFactory().getRouteDao().getRoutes();	
	}

	@Override
	public int addRoute(Route route) {
	
		
		LOGGER.debug("Adding new route - Route manager " + route.getName());

		return getDaoFactory().getRouteDao().addRoute(route);	
	}

}
