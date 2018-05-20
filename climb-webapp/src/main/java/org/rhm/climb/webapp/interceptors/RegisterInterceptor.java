package org.rhm.climb.webapp.interceptors;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Interceptor controling access using session and role
 */
public class RegisterInterceptor extends AbstractInterceptor  {

	private static final long serialVersionUID = 7995153741671857846L;

	//static final Logger logger = LogManager.getLogger("org.rhm.climb");
	private static final Log LOGGER = LogFactory.getLog(RegisterInterceptor.class);
   
	@Override
	public String intercept(ActionInvocation pInvocation) throws Exception {

		String vResult = "";

		LOGGER.debug("Triggering interceptor for registration control - avoid use of admin username");

		HttpServletRequest request = ServletActionContext.getRequest();

		if (request.getMethod().equals("GET")) {
			
			return pInvocation.invoke();
			
		} else if (request.getMethod().equals("POST")) {
						
		// ex of use : http://www.wideskills.com/struts/struts-param-interceptor
			String username = request.getParameter("userBean.username");
			
			//UserAction action = (UserAction) pInvocation.getAction();
			//String username = action.getUserBean().getUsername();
			
			LOGGER.debug("Within action User  - intercepting username : " + username);

			if (StringUtils.containsAny(username, "admin", "bob")) {
						
				return "error-forbidden";
			}
		} else {
			LOGGER.debug("Within intereceptor... METHOD : " + request.getMethod());
		}

		return pInvocation.invoke();
	}
}
