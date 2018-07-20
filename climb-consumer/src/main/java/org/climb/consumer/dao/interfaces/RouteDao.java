package org.climb.consumer.dao.interfaces;

import java.util.List;

import org.climb.model.bean.route.Route;

public interface RouteDao {

	int addRoute(Route route);

	List<Route> getRoutes();

	Route getRouteFromId(int id);

}
