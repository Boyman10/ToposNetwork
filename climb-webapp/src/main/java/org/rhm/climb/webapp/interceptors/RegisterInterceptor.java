package org.rhm.climb.webapp.interceptors;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.rhm.climb.webapp.action.Register;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Interceptor controling access using session and role
 * @see https://struts.apache.org/core-developers/writing-interceptors.html
 */
public class RegisterInterceptor extends AbstractInterceptor  {

	private static final long serialVersionUID = 7995153741671857846L;

	static final Logger LOGGER = LogManager.getLogger(RegisterInterceptor.class);
	//private static final Log LOGGER = LogFactory.getLog(RegisterInterceptor.class);
   
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
										
			       Register action = (Register)pInvocation.getAction();
			       action.setError("What language are you speaking !!");
			       
			       return pInvocation.invoke();
			       
			}
		} else {
			LOGGER.debug("Within intereceptor... METHOD : " + request.getMethod());
		}

		//allow the next Interceptor to execute
		return pInvocation.invoke();
	}
}
