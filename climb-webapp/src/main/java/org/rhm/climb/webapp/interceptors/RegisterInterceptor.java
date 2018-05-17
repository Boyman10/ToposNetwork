package org.rhm.climb.webapp.interceptors;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.rhm.climb.webapp.action.UserAction;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Interceptor controling access using session and role
 */
public class RegisterInterceptor extends AbstractInterceptor  {

	private static final long serialVersionUID = 7995153741671857846L;

	static final Logger logger = LogManager.getLogger(AuthInterceptor.class);

   
	@Override
	public String intercept(ActionInvocation pInvocation) throws Exception {

		String vResult = "";

		logger.debug("Triggering interceptor for registration control - avoid use of admin username");

		HttpServletRequest request = ServletActionContext.getRequest();

		if (request.getMethod().equals("GET")) {
			
			System.out.println("Within intereceptor... GET");

			return pInvocation.invoke();
			
		} else if (request.getMethod().equals("POST")) {
			
			System.out.println("Within intereceptor... POST");
			
		// ex of use : http://www.wideskills.com/struts/struts-param-interceptor
			String username = request.getParameter("userBean.username");
			
			//UserAction action = (UserAction) pInvocation.getAction();
			//String username = action.getUserBean().getUsername();

		System.out.println("Retrieving user with pseudo " + username);
			
			logger.debug("Within action User  - intercepting username : " + username);

			if (StringUtils.containsAny(username, "admin", "bob")) {
				
				
				vResult = "error-forbidden";
			}
		} else {
			System.out.println("Within intereceptor... METHOD : " + request.getMethod());
			
		}

		System.out.println(vResult + " " );
		return vResult;
	}
}
