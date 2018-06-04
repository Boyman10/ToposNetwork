package org.rhm.climb.webapp.converter;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.util.StrutsTypeConverter;
import org.climb.model.bean.route.Level;

/**
 * Type converter for struts2 to understand Level enumeration type
 * @author John
 *
 */
public class LevelConverter  extends StrutsTypeConverter {

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		
	       Object vReturn = null;

	        if (values != null) {
	            if (values.length == 1) {
	                String vValue = values[0];
	                try {
	                	vReturn = StringUtils.isEmpty(vValue) ? null : Level.valueOf(vValue);
	                } catch (IllegalArgumentException pEx) {
	                    throw new IllegalArgumentException("Invalid type for Enum", pEx);
	                }
	            } else {
	            	vReturn = performFallbackConversion(context, values, toClass);
	            }
	        }

	        return vReturn;
	}

	@Override
	public String convertToString(Map context, Object o) {
		
        String vString;
        if (o instanceof Level) {
        	Level vLevel = (Level) o;
            vString = o.toString();
        } else {
            vString = "";
        }
        return vString;
	}
	

}
