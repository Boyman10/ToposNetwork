package org.rhm.climb.webapp.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.climb.business.manager.interfaces.factory.ManagerFactory;
import org.climb.model.bean.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.ParameterNameAware;

/**
 * Defined Action for authentication purpose and may be additional user
 * management - will be separated..
 * 
 * @author bob
 * @version 1.0
 */
@Service
public class UserAction extends ActionSupport implements SessionAware, ServletRequestAware {

	/**
	 * TODO :
	 * https://www.journaldev.com/2203/get-servlet-session-request-response-context-attributes-struts-2-action
	 */
	private static final long serialVersionUID = -312477649388098567L;

	private static final Logger LOGGER = LogManager.getLogger(UserAction.class);

	// Constant to be used to identify session
	private static final String USER = "user";

	// Handling session
	private Map<String, Object> userSession;
	private HttpServletRequest servletRequest;

	// The bean to be defined for the login form - using corresponding entity
	private User userBean;

	@Autowired
	@Qualifier("managerFactory")
	private ManagerFactory managerFactory;

	@Override
	public void setSession(Map<String, Object> session) {
		userSession = session;
	}

	/**
	 * @return the userBean
	 */
	public User getUserBean() {
		return userBean;
	}

	/**
	 * @param userBean
	 *            the userBean to set
	 */
	public void setUserBean(User userBean) {
		this.userBean = userBean;
	}

	/**
	 * Login method checking user sign in
	 * 
	 * @return
	 */
	public String doLogin() {

		// Return input by default :
		String vResult = ActionSupport.INPUT;

		LOGGER.debug("Entering doLogin action...");
		
		// Redirect if user already logged in :
		if (null != this.userSession.get(USER) && this.userSession.containsKey(USER)) {

			LOGGER.debug("Already connected " + userBean.getUsername());
			return ActionSupport.SUCCESS;
		}

		// Check if we have password and userBean submitted :
		if (userBean != null && !StringUtils.isAllEmpty(userBean.getUsername(), userBean.getPassword())) {

			LOGGER.debug("We DO have a userBean " + userBean.getUsername());
			
			try {

				LOGGER.debug("Retrieving user with pseudo and password " + userBean.getUsername());

				// Should match the DB now :
				User uEx = this.managerFactory.getUserManager().findUserByBean(userBean);

				if (uEx != null) {
					/* Perfect we are all good we should continue now : */

					LOGGER.debug("Adding user to session");
					userBean = uEx;
					// Adding user to session :
					this.userSession.put(USER, uEx);

					return ActionSupport.SUCCESS;

				} else 
					this.addActionError("Wrong username and password combination !");

			} catch (Exception pEx) {

				this.addActionError("Identifiant ou mot de passe invalide !");
			}
		} else {
			
			LOGGER.debug("Are we in POST ? ");
			
		}

		return vResult;
	}

	/**
	 * Login out current user :
	 * 
	 * @return success
	 */
	public String doLogout() {

		this.userSession.remove(USER);
		// Invalide session - security @TODO check further details about security :
		this.servletRequest.getSession().invalidate();
		return ActionSupport.SUCCESS;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.servletRequest = request;

	}


}
