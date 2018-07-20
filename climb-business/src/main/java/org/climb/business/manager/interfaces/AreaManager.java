package org.climb.business.manager.interfaces;

import java.util.List;

import org.climb.model.bean.route.Area;
import org.springframework.stereotype.Component;

@Component
public interface AreaManager {

	public List<Area> getAreaList();
	public int addArea(Area area);
	Area getAreaById(int id);

}
