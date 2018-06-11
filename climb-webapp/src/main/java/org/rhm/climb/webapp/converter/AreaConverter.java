package org.rhm.climb.webapp.converter;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.util.StrutsTypeConverter;
import org.climb.business.manager.interfaces.factory.ManagerFactory;
import org.climb.model.bean.route.Area;
import org.climb.model.bean.route.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * A Converter for our Area Bean using the Site object property
 * 
 * @author Boyman10
 */
public class AreaConverter extends StrutsTypeConverter {

	private static final Logger LOGGER = LogManager.getLogger(AreaConverter.class);
	
	@Autowired
	@Qualifier("managerFactory")
	private ManagerFactory managerFactory;
	
	
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {

		Object vReturn = null;

		if (values != null) {
			if (values.length == 3) {
				String name = values[0];
				String details = values[1];
				String site = values[2];
				try {
					
					Site areaSite = managerFactory.getSiteManager().getSiteById(Integer.parseInt(site));
					vReturn = new Area(name,details,areaSite);
					
					
				} catch (IllegalArgumentException pEx) {
					throw new IllegalArgumentException("Invalid type for Enum", pEx);
				}
			} else {
				vReturn = performFallbackConversion(context, values, toClass);
			}
		}

		LOGGER.info("Inside convertFromString...");

		return vReturn;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
        
        LOGGER.info("Inside convertToString...");
        
        return arg1.toString();
	}

}
