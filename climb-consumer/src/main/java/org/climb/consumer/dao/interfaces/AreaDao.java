package org.climb.consumer.dao.interfaces;

import java.util.List;

import org.climb.model.bean.route.Area;

/**
 * interface for Area manip.
 * @author bob
 *
 */
public interface AreaDao {
	
	public List<Area> getListArea();
	int addArea(Area area);
}
