package org.climb.business.manager.interfaces;

import java.util.List;

import org.climb.model.bean.route.Route;
import org.springframework.stereotype.Component;

@Component
public interface RouteManager {

	public List<Route> getRouteList();
	public int addRoute(Route route);
}
