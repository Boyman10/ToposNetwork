package org.climb.business.manager.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.climb.business.manager.interfaces.AreaManager;
import org.climb.model.bean.route.Area;
import org.springframework.stereotype.Component;

@Component("areaManager")
public class AreaManagerImpl extends AbstractManager implements AreaManager {

	static final Logger LOGGER = LogManager.getLogger(AreaManagerImpl.class);

	@Override
	public List<Area> getAreaList() {
		LOGGER.debug("Getting list of areas - Area manager ");
		
		return getDaoFactory().getAreaDao().getListArea();	
	}

	@Override
	public int addArea(Area area) {
	
		
		LOGGER.debug("Adding new area - Area manager " + area.getName());

		return getDaoFactory().getAreaDao().addArea(area);	
	}

}
