package org.rhm.climb.webapp.interceptors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Interceptor controling access using session and role
 */
public class AuthInterceptor extends AbstractInterceptor {

    private static final long serialVersionUID = 7995153741671857846L;

    static final Logger logger = LogManager.getLogger(AuthInterceptor.class);
    		
    		
    @Override
    public String intercept(ActionInvocation pInvocation) throws Exception {
        String vResult;
        
        logger.debug("Triggering interceptor for access control");
        
        if (pInvocation.getInvocationContext().getSession().get("user") != null) {
            vResult = pInvocation.invoke();
        } else {
            vResult = "error-forbidden";
        }
        return vResult;
    }
}